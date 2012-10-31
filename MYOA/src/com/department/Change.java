package com.department;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oa.sys.Db;
import oa.sys.Str;
/**
 ****************************************************
 *类名称：	Change<br>
 *类功能：	更新部门信息<br>
 ****************************************************
 * */
public class Change extends HttpServlet{
	private Statement stmt=null;
	private String name,explain,sqlu;
	private int id=0,temp=0;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		//获取id
		try{
		id=Integer.parseInt((String)request.getParameter("id"));
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		name=request.getParameter("name");
		explain=request.getParameter("explain");
		name=str.inStr(name);
		explain=str.inStr(explain);
		sqlu="UPDATE department SET name='"+name+"',explain='"+explain+"' WHERE departmentid="+id;
		//修改
		try{
			stmt=db.getStmt();
			temp=stmt.executeUpdate(sqlu);
			if(temp>0){
				request.setAttribute("selmsg","修改成功");
			}else{
				request.setAttribute("selmsg","修改失败");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			db.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("change.jsp");
			dispatcher.forward(request,response);
		}
	}	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}