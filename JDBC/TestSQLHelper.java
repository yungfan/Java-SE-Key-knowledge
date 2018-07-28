package com.yangfan.jdbc;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class TestSQLHelper
{
	@Test
    public void testSqlHelper()
    {
//    	String sql = "update myemp set sal = ? where empno = ?";
//      String[] parameters = {"2000", 7934+""};
//      SQLHelper.executeUpdate(sql, parameters);
		
		
// 	    String sql = "INSERT into hero values(?, ?, ?, ?, ?)";
//      String[] parameters = {"6", "Œ‰À…", "––’ﬂ", "ƒ–", 200+""};
//      SQLHelper.executeUpdate(sql, parameters);
		
// 	    String sql = "delete from user where id = 28";
//      SQLHelper.executeUpdate(sql, null);	
		
//    	String sql = "SELECT * from emp";
//    	try
//    	{
//    		ResultSet rs = SQLHelper.executeQuery(sql, null);		
//        	while(rs.next())
//        	{
//        		System.out.println(rs.getString("ename") + " " +  rs.getInt("sal"));
//        	}
//    	}
//    	
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//        
//		finally
//		{
//			SQLHelper.close(SQLHelper.getRs(), SQLHelper.getPs(), SQLHelper.getCt());
//		}
		
		ResultSet rs = null;
		try
		{
			String sql = "{call yf_pro8(?, ?)}";
			String [] in = {10 + ""};
			Integer [] out = {oracle.jdbc.OracleTypes.CURSOR};
	        
			CallableStatement cs = SQLHelper.callPro2(sql, in, out);
						
			rs = (ResultSet) cs.getObject(2);
			
			while(rs.next())
        	{
        		System.out.println(rs.getInt(1)+ "  " + rs.getString(2));
        	}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
        finally
        {
        	SQLHelper.close(rs, SQLHelper.getCs(), SQLHelper.getCt());
        }
    }
}
