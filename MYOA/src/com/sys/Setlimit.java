package com.sys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oa.sys.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 ****************************************************
 *类名称：	Set<br>
 *类功能：	设置员工发布公告的权限<br>
 ****************************************************
*/
public class Setlimit extends HttpServlet {
	private Db db=null;
	private Str str=null;
	private Time time=null;
	private int limit,id,temp;
	private String sql,sqlsp;
	private HttpSession session=null;
	private PrintWriter out=null;
	private ResultSet rs=null;
	private Statement stmt=null;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out = response.getWriter();
		session=request.getSession();
		time=new Time();
		str=new Str();
		db=new Db();
		//取得表单项
		try{
			id=Integer.parseInt((String)request.getParameter("id"));
		}catch(Exception e){
			id=0;
		}
		
		try{
			limit=Integer.parseInt((String)request.getParameter("limit"));
		}catch(Exception e){
			
		}
		
		sqlsp="SELECT * FROM eminfo WHERE employeeid="+id;
		sql="UPDATE eminfo SET limit="+limit+" WHERE employeeid="+id;
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqlsp);
			if(rs.next()){//存在这个员工
				db.close();
				stmt=db.getStmt();
				temp=0;
				temp=stmt.executeUpdate(sql);
				if(temp>0){
					request.setAttribute("msg","设置成功");
				}else{
					request.setAttribute("msg","设置失败");
				}
				db.close();	
			}
			else{
				//不存在这个员工
				db.close();
				request.setAttribute("msg","员工序号不存在");
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();	
		}
		finally{
			RequestDispatcher dispatcher=request.getRequestDispatcher("setlimit.jsp");
			dispatcher.forward(request,response);
		}
		
		
	}
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

doPost(request,response);
}



}
