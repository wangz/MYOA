package oa.sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbtest 
{
	Connection conn=null; 
    ResultSet rs=null;
    Statement stat=null;
    String url="jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=MYOA;SelectMethod=direct";
    
	public dbtest()
	{
		try { 
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
			} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		} 
	}
	
	public ResultSet executeQuery(String sql)
	{
	    try {
	    	conn=DriverManager.getConnection(url,"sa","1");
	        stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	        rs=stat.executeQuery(sql);
	        } 
	    catch (Exception ex1)
	    {
	    	System.err.println(ex1.getMessage());
	    }
	    return rs;
	 }
	
	public int executeUpdate(String sql)
	{
	    int result=0;
		try {
	    	    conn=DriverManager.getConnection(url,"sa","1");
	            stat=conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
	            result=stat.executeUpdate(sql);
	        } 
	     catch (Exception ex2) 
	     {
	    	 System.err.println(ex2.getMessage());
	     }
	     return result;
	 }
    
	public void closeDB(){
		try{
			rs.close();
			stat.close();
			conn.close();
		}catch(Exception ex3){System.err.println(ex3.getMessage());
	}
}
	public static void main(String[] args) {
		dbtest condb=new dbtest();
		String sql="select * from job";
		try{
			ResultSet rs=condb.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
		
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
