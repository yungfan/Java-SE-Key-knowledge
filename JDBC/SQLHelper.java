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
 * �Ѷ����ݿ�Ĳ�����װ��һ����
 * @author �
 *
 */
public class SQLHelper
{
     //������Ҫ�ı���   �������Ƚϴ�ʱ������static
	private static Connection ct = null;
	// ������������preparedstatement���statement
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static Properties pp = null;
	private static FileInputStream fis = null;
	private static CallableStatement cs = null;

	
	//���Ĵ���Դ����get����  Ϊ��������纯�����
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
	
	//�������� ֻ��Ҫһ��
	static
	{
		try
		{
			//�������ļ��ж�ȡ������Ϣ
			pp = new Properties();
			fis = new FileInputStream("oracleinfo.properties");
			//fis = new FileInputStream("mysqlinfo.properties");
			//fis = new FileInputStream("sqlserverinfo.properties");
			//������ʹ��web��ʱ��,��ȡ�ļ�Ҫ��������������������ȥ��ȡ��Դ��ʱ��Ĭ�ϵ�Ŀ¼��srcĿ¼
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
	
	//�õ�����
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
	
	//�޸� Update  Delete  Insert
	// sql��ʽ��update ����  set �ֶ��� =��where �ֶ�=��
	// parametersӦ���� {"abc",23}
	public static void executeUpdate(String sql, String[] parameters)
	{
		
		//����ps
	    try
		{   
	    	ct = getConnection();
			ps = ct.prepareStatement(sql);
			//��û�д����� �еĻ�������ֵ
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
			e.printStackTrace();// �����׶δ�ӡһ��
			// �׳�����ʱ�쳣  �����ö�һ��ѡ�񣺿��Դ���Ҳ���Բ�����
			throw new RuntimeException(e.getMessage());
		}
		
		finally
		{
			close(rs, ps, ct);
		}
	}
	
	//������һ��Update�����
	//����ж��Update, �������������
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
	
	//��ѯ
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
            //�ر�Ҫ�ͺ� ��Ȼ�޷�����rs
			//���Էŵ����ö˹ر�
		}
		return rs;
	}
	
	// ����û�з��صĴ洢����
	// �洢����������{call pro(?, ?)}
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

	// �����з��ؽ���Ĵ洢����  inparameters������Ĳ���  outparameters����Ҫע��Ĳ���
	// �洢����������{call pro(?, ?, ?, ?)}
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
			// ��Out������ֵ
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
	
	//�ر���Դ
	public static void close(ResultSet rs, Statement ps, Connection ct)
	{
		// �ȿ����
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
