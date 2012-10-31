
package com.message;

import oa.sys.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	Del<br>
 *类功能：	删除短消息<br>
 ****************************************************
*/
public class Del extends HttpServlet{
	private int temp;
	private String sqli;
	private int id;
	private int messageid;
	private HttpSession session=null;
	private ResultSet rs=null;
	private Statement stmt=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		PrintWriter out=response.getWriter();
		session=request.getSession();
		try{
		id=Integer.parseInt(session.getAttribute("id").toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			messageid=Integer.parseInt((String)request.getParameter("messageid"));
		}catch(Exception e){
			e.printStackTrace();
		}
		if(id==-1){
			sqli="DELETE FROM message WHERE messageid="+messageid;
		}else{
			sqli="DELETE FROM message WHERE accepter="+id+" AND messageid="+messageid;
		}
		try {
			stmt=db.getStmt();
			temp=stmt.executeUpdate(sqli);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("view");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}