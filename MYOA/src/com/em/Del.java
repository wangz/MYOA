package com.em;

import oa.sys.*;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Del extends HttpServlet {

	/**
	 * 删除员工信息
	 */
	private HttpSession session=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private String sqld;
	private int temp=0,emid=0;


	


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Db db=new Db();
		PrintWriter out=response.getWriter();
		session=request.getSession();
		try{
			emid=Integer.parseInt((String)request.getParameter("emid"));
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		sqld="DELETE FROM eminfo WHERE employeeid="+emid;
		try {
			//删除员工信息
			stmt=db.getStmt();
			temp=stmt.executeUpdate(sqld);
			if(temp>0){
				request.setAttribute("msg1","删除成功");
			}else{
				request.setAttribute("msg1","删除失败");
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		db.close();
		RequestDispatcher dispatcher=request.getRequestDispatcher("view?flag=update");
		dispatcher.forward(request,response);
	}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
     doPost(request,response);
    }



}
