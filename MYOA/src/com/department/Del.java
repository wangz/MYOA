package com.department;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oa.sys.Db;
import oa.sys.Str;
/**
 ****************************************************
 *类名称：	Del<br>
 *类功能：	删除部门信息<br>
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
		sqld="DELETE FROM department WHERE departmentid="+id;
		sqls="SELECT * FROM department WHERE departmentid="+id;
		stmt=db.getStmtread();
		try {
			rs=stmt.executeQuery(sqls);
			//查询添加部门是否存在
			if(rs.next()){
				rs.close();
				stmt.close();
				//删除部门
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqld);
				if(temp>0){
					request.setAttribute("delmsg","删除成功");
				}else{
					request.setAttribute("delmsg","删除失败");
				}
			}else{
				request.setAttribute("delmsg","该部门不存在");
			}
		} catch (SQLException e) {
			request.setAttribute("delmsg","删除失败,请删除属于此部门的所有员工");
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
