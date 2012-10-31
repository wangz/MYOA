package com.job;

import oa.sys.*;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	Del<br>
 *类功能：	删除职位信息<br>
 ****************************************************
*/
public class Del extends HttpServlet{
	private HttpSession session=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private String sqld,sqls;
	private int temp=0,id=0;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		PrintWriter out=response.getWriter();
		session=request.getSession();
		try{
		id=Integer.parseInt((String)request.getParameter("id"));
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		sqld="DELETE FROM job WHERE jobid="+id;
		sqls="SELECT * FROM job WHERE jobid="+id;
		stmt=db.getStmtread();
		try {
			rs=stmt.executeQuery(sqls);
			//查询添加职位是否存在
			if(rs.next()){
				rs.close();
				stmt.close();
				//删除职位
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqld);
				if(temp>0){
					request.setAttribute("delmsg","删除成功");
				}else{
					request.setAttribute("delmsg","删除失败");
				}
			}else{
				request.setAttribute("delmsg","该职位不存在");
			}
		} catch (SQLException e) {
			request.setAttribute("delmsg","删除失败,请删除属于此职位下的所有员工");
			System.err.print(e.getMessage());
		}finally{
			db.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("del.jsp");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
