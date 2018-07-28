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
{// �������
	private static Connection ct = null;
	// ������������preparedstatement���statement
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


	// �������ݿ�Ĳ���
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
	// ����������ֻ��Ҫһ�Σ��þ�̬�����
	static
	{
		try
		{
			// ��dbinfo.properties
			pp = new Properties();
			//fis = new FileInputStream("dbinfo.properties");//==>tomcat��Ŀ¼ /bin
			//������ʹ��web��ʱ��,��ȡ�ļ�Ҫ��������������������ȥ��ȡ��Դ��ʱ��Ĭ�ϵ�Ŀ¼��srcĿ¼
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
			fis = null;// ��������վ����ʰ
		}

	}

	// �õ�����
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

	// ����Oracle��û�з��ؽ���Ĵ洢����
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
			//�׳�����ʱ�쳣 �ͻ��˾Ϳ��������µĴ������� 
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			close(rs, cs, ct);
		}
		return cs;
	}

	// ����Oracle���з��ؽ���Ĵ洢����
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

	//ͳһ��select����
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
	
	//����ѯ�����װ�ɶ��� Ȼ�󷵻�һ����������
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


	//���ͬʱ�ж��update��delete��insert���� Ҫ�������� 
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

	// ����update��delete��insert����
	// sql��ʽ��update ���� set �ֶ��� =��where �ֶ�=��
	// parameters Ӧ����{"abc",23}
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
				    //���Ǵ�1��ʼ�� ���Ա����1
					ps.setString(i + 1, parameters[i]);
				}

			}
			
			//�˴�Ϊʲô����һ���������� Ȼ���ж��ǲ��Ǵ����㣿  ��Ϊ��Щ�ǲ����������� �ѱ�������ȷ���д����
			ps.executeUpdate();
		}
		catch (Exception e)
		{
		    // �����׶δ�ӡһ��
			e.printStackTrace();
			// �׳��쳣����������һ��ѡ��:���Դ���Ҳ���Բ�����
			throw new RuntimeException(e.getMessage());
		}
		finally
		{
			close(rs, ps, ct);
		}
	}

	public static void close(ResultSet rs, Statement ps, Connection ct)
	{
		// �ر���Դ(�ȿ����)
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
