package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oa.sys.Db;

public class Admin extends HttpServlet {

	private HttpSession session=null;
	private String name;
	private String password,sqls;
	private Statement stmt=null;
	private ResultSet rs=null;
	private RequestDispatcher dispatcher;
	
	public Admin() {
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
		name=request.getParameter("name");
		password=request.getParameter("password");
		sqls="SELECT * FROM admin WHERE name='"+name+"' AND password='"+password+"'";
		Db db=new Db();

//		验证
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqls);
			if(rs.next()){
				db.close();
				session.setAttribute("name",name);
				session.setAttribute("id","-1");
				out.print("<script>parent.location.href='adminlogin_ok.jsp';</script>");
			}
			else{
				//验证失败
				session.setAttribute("error","您输入的用户名或密码错误");
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
