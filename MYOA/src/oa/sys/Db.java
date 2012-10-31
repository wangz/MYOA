package oa.sys;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
/**
 ****************************************************
 *类名称：	Db<br>
 *类功能：	数据库操作 <br>
 ****************************************************
 */
public class Db {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	public static int error=0;

	/***************************************************
	*函数名称：	getCon()<br>
	*函数功能：	获取数据库连接<br>
	****************************************************/
	public static synchronized Connection getCon()throws Exception{
		Context ctx;
		DataSource ds;
		try{
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MYOA");
		
			System.err.println();
			System.err.println("数据连接+"+(++error));
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
	*函数名称：	getStmtread()<br>
	*函数功能：	获取数据库集合<br>
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
	*函数名称：	getRowCount()<br>
	*函数功能：	返回表的行数<br>
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
	*函数名称：	getStmt()<br>
	*函数功能：	获取数据库集合<br>
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
	*函数名称：	IdtoName()<br>
	*函数功能：	根据员工ID获取员工姓名<br>
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
				name="被删除";
			}
			this.close();
		}catch(Exception e){
			System.out.println("IdtoName");
			System.out.println(e.getMessage());
		}
		return name;
	}
	/***************************************************
	*函数名称：	IdtoDeName()<br>
	*函数功能：	根据员工ID获取员工部门名称<br>
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
				name="无此部门";
			}
			this.close();
		}catch(Exception e){
			System.out.println("IdtoName");
			System.out.println(e.getMessage());
		}
		return name;
	}
	/***************************************************
	*函数名称：	IdtoDo()<br>
	*函数功能：	根据输入条件获取单字段一条数据<br>
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
	*函数名称：	getPstmt()<br>
	*函数功能：	获取数据库集合<br>
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
	*函数名称：close()<br>
	*函数功能：关闭数据库连接<br>
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
			System.err.println("数据连接-"+(--error));
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