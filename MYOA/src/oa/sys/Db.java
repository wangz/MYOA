package oa.sys;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
/**
 ****************************************************
 *�����ƣ�	Db<br>
 *�๦�ܣ�	���ݿ���� <br>
 ****************************************************
 */
public class Db {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	public static int error=0;

	/***************************************************
	*�������ƣ�	getCon()<br>
	*�������ܣ�	��ȡ���ݿ�����<br>
	****************************************************/
	public static synchronized Connection getCon()throws Exception{
		Context ctx;
		DataSource ds;
		try{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MYOA");
		
			System.err.println();
			System.err.println("��������+"+(++error));
			return ds.getConnection();
		}catch(SQLException e){
			System.out.print(e);
			throw e;
		}
		catch(NamingException e){
			System.out.print(e);
			throw e;
		}
	}
	/***************************************************
	*�������ƣ�	getStmtread()<br>
	*�������ܣ�	��ȡ���ݿ⼯��<br>
	****************************************************/
	public Statement getStmtread(){
		try{
			con=getCon();
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e){
			System.out.println("getStmtread");
			System.out.println(e.getMessage());
		}
		return stmt;
	}
	/***************************************************
	*�������ƣ�	getRowCount()<br>
	*�������ܣ�	���ر������<br>
	****************************************************/
	public int getRowCount(String sql){
		int count=0;;
		try{
			stmt=this.getStmtread();
			rs=stmt.executeQuery("SELECT COUNT(*) FROM "+sql);
			rs.getMetaData();
			if(rs.next()){
				count=rs.getInt(1);
			}else{
				count=-1;
			}
		}catch(Exception e){
			System.out.println("getRowCount");
			System.out.println(e.getMessage());
			count=-2;
		}finally{
			this.close();
		}
		return count;
	}
	/***************************************************
	*�������ƣ�	getStmt()<br>
	*�������ܣ�	��ȡ���ݿ⼯��<br>
	****************************************************/
	public Statement getStmt(){
		try{
			con=getCon();
			stmt=con.createStatement();
		}catch(Exception e){
			System.out.println("getStmt");
			System.out.println(e.getMessage());
		}
		return stmt;
	}
	/***************************************************
	*�������ƣ�	IdtoName()<br>
	*�������ܣ�	����Ա��ID��ȡԱ������<br>
	****************************************************/
	public String IdtoName(int id){
		String name=null;
		try{
			stmt=this.getStmtread();
			rs=stmt.executeQuery("SELECT name FROM eminfo WHERE employeeid="+id);
			if(rs.next()){
				name=rs.getString(1);
				Str str=new Str();
				name=str.outStr(name);
			}else{
				name="��ɾ��";
			}
			this.close();
		}catch(Exception e){
			System.out.println("IdtoName");
			System.out.println(e.getMessage());
		}
		return name;
	}
	/***************************************************
	*�������ƣ�	IdtoDeName()<br>
	*�������ܣ�	����Ա��ID��ȡԱ����������<br>
	****************************************************/
	public String IdtoDeName(int id){
		String name=null;
		try{
			stmt=this.getStmtread();
			rs=stmt.executeQuery("SELECT name FROM department WHERE departmentid="+id);
			if(rs.next()){
				name=rs.getString(1);
				Str str=new Str();
				name=str.outStr(name);
			}else{
				name="�޴˲���";
			}
			this.close();
		}catch(Exception e){
			System.out.println("IdtoName");
			System.out.println(e.getMessage());
		}
		return name;
	}
	/***************************************************
	*�������ƣ�	IdtoDo()<br>
	*�������ܣ�	��������������ȡ���ֶ�һ������<br>
	****************************************************/
	public String IdtoDo(String field,String from){
		String name=null;
		try{
			stmt=this.getStmtread();
			rs=stmt.executeQuery("SELECT "+field+" FROM "+from);
			if(rs.next()){
				name=rs.getString(1);
				Str str=new Str();
				name=str.outStr(name);
			}
			this.close();
		}catch(Exception e){
			System.out.println("IdtoDo");
			System.out.println(e.getMessage());
		}
		return name;
	}	/***************************************************
	*�������ƣ�	getPstmt()<br>
	*�������ܣ�	��ȡ���ݿ⼯��<br>
	****************************************************/
	public PreparedStatement getPstmt(String sql){
		try{
			con=getCon();
			pstmt=con.prepareStatement(sql);
		}catch(Exception e){
			System.out.println("getPstmt");
			System.out.println(e.getMessage());
		}
		return pstmt;
	}
	/***************************************************
	*�������ƣ�close()<br>
	*�������ܣ��ر����ݿ�����<br>
	****************************************************/
	public void close(){
		try{
			if(rs!=null)rs.close();
		}catch(Exception e){
		}
		try{
			if(stmt!=null)stmt.close();
		}catch(Exception e){
		}
		try{
			if(con!=null){
			con.close();
			con=null;
			System.err.println();
			System.err.println("��������-"+(--error));
			}
		}catch(Exception e){
			System.out.println("close");
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
     Db db=new Db();
    try{ 
     db.stmt=db.getStmtread();
     db.rs=db.stmt.executeQuery("selcet * from job");
     while(db.rs.next())
     {
    	 System.out.print(db.rs.getString("jobid"));
    	 
     }
     db.close();
    }
    catch (Exception e){
		System.out.println(e.getMessage());
	}
    finally{
		db.close();
	}
	}
}