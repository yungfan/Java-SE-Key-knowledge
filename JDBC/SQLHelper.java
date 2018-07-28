package com.yangfan.jdbc;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 把对数据库的操作封装成一个类
 * @author 杨帆
 *
 */
public class SQLHelper
{
     //定义需要的变量   并发量比较大时不宜用static
	private static Connection ct = null;
	// 大多数情况下用preparedstatement替代statement
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static Properties pp = null;
	private static FileInputStream fis = null;
	private static CallableStatement cs = null;

	
	//给四大资源生成get方法  为了是让外界函数获得
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

	public static CallableStatement getCs()
	{
		return cs;
	}
	
	//加载驱动 只需要一次
	static
	{
		try
		{
			//从配置文件中读取配置信息
			pp = new Properties();
			fis = new FileInputStream("oracleinfo.properties");
			//fis = new FileInputStream("mysqlinfo.properties");
			//fis = new FileInputStream("sqlserverinfo.properties");
			//当我们使用web的时候,读取文件要是用类加载器，类加载器去读取资源的时候默认的目录是src目录
			//fis = SqlHelper.class.getClassLoader().getResourceAsStream("oracleinfo.properties");
			pp.load(fis);
			driver = pp.getProperty("driver");
			url = pp.getProperty("url");
			username = pp.getProperty("username");
			password = pp.getProperty("password");
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
			fis = null;
		}
	}
	
	//得到连接
	public static Connection getConnection()
	{
		try
		{
			ct = DriverManager.getConnection(url, username, password);
		}
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}
	
	//修改 Update  Delete  Insert
	// sql格式：update 表名  set 字段名 =？where 字段=？
	// parameters应该是 {"abc",23}
	public static void executeUpdate(String sql, String[] parameters)
	{
		
		//创建ps
	    try
		{   
	    	ct = getConnection();
			ps = ct.prepareStatement(sql);
			//有没有传参数 有的话给？赋值
			if(null != parameters)
			{
				for (int i = 0; i < parameters.length; i++)
				{
					ps.setString(i + 1, parameters[i]);
				}
			}
			ps.executeUpdate();
		}
	    
		catch (SQLException e)
		{
			e.printStackTrace();// 开发阶段打印一下
			// 抛出运行时异常  给调用段一个选择：可以处理，也可以不处理
			throw new RuntimeException(e.getMessage());
		}
		
		finally
		{
			close(rs, ps, ct);
		}
	}
	
	//上述是一个Update的情况
	//如果有多个Update, 必须加入事务处理
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
	
	//查询
	public static ResultSet executeQuery(String sql, String[] parameters)
	{
		try
		{
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			if ( null != parameters && ! "".equals(parameters))
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
            //关闭要滞后 不然无法返回rs
			//可以放到调用端关闭
		}
		return rs;
	}
	
	// 调用没有返回的存储过程
	// 存储过程类似于{call pro(?, ?)}
	public static void callPro1(String sql, String[] parameters)
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
			throw new RuntimeException(e.getMessage());
		}
		
		finally
		{
			close(rs, cs, ct);
		}
		
	}

	// 调用有返回结果的存储过程  inparameters是输入的参数  outparameters是需要注册的参数
	// 存储过程类似于{call pro(?, ?, ?, ?)}
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
			
			// cs.registerOutparameter(Index, oracle.jdbc.OracleTypes.CURSOR);
			// 给Out参数赋值
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
	
	//关闭资源
	public static void close(ResultSet rs, Statement ps, Connection ct)
	{
		// 先开后关
		if (null != rs) 
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
		
		if (null != ps)
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
