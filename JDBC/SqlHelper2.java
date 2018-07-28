package com.yf.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SqlHelper
{// 定义变量
	private static Connection ct = null;
	// 大多数情况下用preparedstatement替代statement
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static Connection getCt()
	{
		return ct;
	}

	public static PreparedStatement getPs()
	{
		return ps;
	}

	public static ResultSet getRs()
	{
		return rs;
	}


	// 连接数据库的参数
	private static String url = "";
	private static String username = "";
	private static String driver = "";
	private static String passwd = "";

	private static CallableStatement cs = null;

	public static CallableStatement getCs()
	{
		return cs;
	}

	private static Properties pp = null;
	private static InputStream fis = null;
	// 加载驱动，只需要一次，用静态代码块
	static
	{
		try
		{
			// 从dbinfo.properties
			pp = new Properties();
			//fis = new FileInputStream("dbinfo.properties");//==>tomcat主目录 /bin
			//当我们使用web的时候,读取文件要是用类加载器，类加载器去读取资源的时候默认的目录是src目录
			fis = SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);
			url = pp.getProperty("url");
			username = pp.getProperty("username");
			driver = pp.getProperty("driver");
			passwd = pp.getProperty("passwd");

			Class.forName(driver);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			fis = null;// 垃圾回收站上收拾
		}

	}

	// 得到连接
	public static Connection getConnection()
	{
		try
		{
			ct = DriverManager.getConnection(url, username, passwd);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ct;
	}

	// 调用Oracle的没有返回结果的存储过程
	public static CallableStatement callPro1(String sql, String[] parameters)
	{
		try
		{
			ct = getConnection();
			cs = ct.prepareCall(sql);
			if (parameters != null)
			{
				for (int i = 0; i < parameters.length; i++)
				{
					cs.setObject(i + 1, parameters[i]);
				}
			}
			cs.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//抛出运行时异常 客户端就看不到可怕的错误提醒 
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			close(rs, cs, ct);
		}
		return cs;
	}

	// 调用Oracle的有返回结果的存储过程
	public static CallableStatement callPro2(String sql, String[] inparameters,
			Integer[] outparameters)
	{
		try
		{
			ct = getConnection();
			cs = ct.prepareCall(sql);
			if (inparameters != null)
			{
				for (int i = 0; i < inparameters.length; i++)
				{
					cs.setObject(i + 1, inparameters[i]);
				}
			}
			// cs.registerOutparameter(2,oracle.jdbc.OracleTypes.CURSOR);
			if (outparameters != null)
			{
				for (int i = 0; i < outparameters.length; i++)
				{
					cs.registerOutParameter(inparameters.length + 1 + i,
							outparameters[i]);
				}
			}
			cs.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		finally
		{

		}
		return cs;
	}

	//统一的select操作
	public static ResultSet executeQuery(String sql, String[] parameters)
	{
		try
		{
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if (parameters != null && ! "".equals(parameters))
			{
				for (int i = 0; i < parameters.length; i++)
				{
					ps.setString(i + 1, parameters[i]);
				}
			}
			rs = ps.executeQuery();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			close(rs, ps, ct);
		}
		return rs;
	}
	
	//将查询结果封装成对象 然后返回一个对象数组
	public static ArrayList executeQuery2(String sql, String[] parameters)
	{
		ArrayList al = new ArrayList();
		
		try
		{
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if (parameters != null && ! "".equals(parameters))
			{
				for (int i = 0; i < parameters.length; i++)
				{
					ps.setString(i + 1, parameters[i]);
				}
			}
			rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next())
			{
				Object [] objects = new Object[rsmd.getColumnCount()];
				
				for (int i = 0; i < objects.length; i++)
				{
					objects[i] = rs.getObject(i + 1);
				}
				
				al.add(objects);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			close(rs, ps, ct);
		}
		return al;
	}


	//如果同时有多个update、delete、insert操作 要考虑事务 
	public static void executeUpdate2(String[] sql, String[][] parameters)
	{
		try
		{
			ct = getConnection();
			ct.setAutoCommit(false);

			for (int i = 0; i < sql.length; i++)
			{

				if (null != parameters[i])
				{
					ps = ct.prepareStatement(sql[i]);
					for (int j = 0; j < parameters[i].length; j++)
					{
						ps.setString(j + 1, parameters[i][j]);
					}
					ps.executeUpdate();
				}

			}

			ct.commit();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				ct.rollback();
			}
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			close(rs, ps, ct);
		}

	}

	// 单个update、delete、insert操作
	// sql格式：update 表名 set 字段名 =？where 字段=？
	// parameters 应该是{"abc",23}
	public static void executeUpdate(String sql, String[] parameters)
	{
		try
		{
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if (parameters != null)
			{
				for (int i = 0; i < parameters.length; i++)
				{
				    //？是从1开始的 所以必须加1
					ps.setString(i + 1, parameters[i]);
				}

			}
			
			//此处为什么不用一个整数接收 然后判断是不是大于零？  因为有些是操作多行数据 难保既有正确又有错误的
			ps.executeUpdate();
		}
		catch (Exception e)
		{
		    // 开发阶段打印一下
			e.printStackTrace();
			// 抛出异常，给调用者一个选择:可以处理也可以不处理
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			close(rs, ps, ct);
		}
	}

	public static void close(ResultSet rs, Statement ps, Connection ct)
	{
		// 关闭资源(先开后关)
		if (rs != null)
		{
			try
			{
				rs.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			rs = null;
		}
		if (ps != null)
		{
			try
			{
				ps.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			ps = null;
		}
		if (null != ct)
		{
			try
			{
				ct.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			ct = null;
		}
	}

}
