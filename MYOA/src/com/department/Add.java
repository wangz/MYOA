package com.department;

import java.io.IOException;
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
 *类名称：	Add<br>
 *类功能：	增加部门信息<br>
 ****************************************************
*/
public class Add extends HttpServlet{
	private HttpSession session=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private String name,explain,sqli,sqls;
	private int temp=0;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		session=request.getSession();
		name=request.getParameter("name");
		explain=request.getParameter("explain");
		name=str.inStr(name);
		explain=str.inStr(explain);
		sqli="INSERT INTO department(name,explain) VALUES('"+name+"','"+explain+"')";
		sqls="SELECT * FROM department WHERE name='"+name+"'";
		stmt=db.getStmtread();
		try {
			rs=stmt.executeQuery(sqls);
			//查询添加部门是否存在
			if(rs.next()){
				session.setAttribute("depmsg","该部门已存在");
			}else{
				rs.close();
				stmt.close();
				//添加部门
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqli);
				if(temp>0){
					session.setAttribute("depmsg","添加成功");
				}else{
					session.setAttribute("depmsg","添加失败");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request,response);
		}
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
