package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import oa.sys.*;


import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Em extends HttpServlet {

	private HttpSession session=null;
	private int id=0;
	private String password,sqls;
	private Statement stmt=null;
	private ResultSet rs=null;
	private RequestDispatcher dispatcher;
	
	public Em() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		PrintWriter out = response.getWriter();
		session=request.getSession();
//		获取数据
		id=Integer.parseInt((String)request.getParameter("id"));
		password=request.getParameter("password");
		sqls="SELECT * FROM password WHERE employeeid="+id+" AND password='"+password+"'";
		Db db=new Db();

//		验证
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqls);
			if(rs.next()){
				db.close();
				session.setAttribute("id",id);
				out.print("<script>parent.location.href='emlogin_ok.htm';</script>");
			}
			else{
				//验证失败
				session.setAttribute("error","您输入的用户名或密码错误 ");
				dispatcher=request.getRequestDispatcher("/error/errorpage.jsp");
				dispatcher.forward(request,response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{  
			db.close();
		}
			
	}
		


	public void init() throws ServletException {
		// Put your code here
	}

}
