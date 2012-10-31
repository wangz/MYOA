package com.sys;

import oa.sys.*;
import oa.sys.Time;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	Set<br>
 *类功能：	设置员工密码<br>
 ****************************************************
*/
public class Set1 extends HttpServlet{
	private Db db=null;
	private Str str=null;
	private Time time=null;
	private int temp,id;
	private String password,sqlu,sqli,sqlsp,sqlse;
	private HttpSession session=null;
	private PrintWriter out=null;
	private ResultSet rs=null;
	private Statement stmt=null;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out = response.getWriter();
		session=request.getSession();
		time=new Time();
		str=new Str();
		db=new Db();
		
		//取得
		try{
			id=Integer.parseInt((String)request.getParameter("id"));
		}catch(Exception e){
			id=0;
		}
		password=request.getParameter("password");
		password=str.inStr(password);
		sqlsp="SELECT * FROM password WHERE employeeid="+id;
		sqlse="SELECT employeeid FROM eminfo WHERE employeeid="+id;
		sqlu="UPDATE password SET time='"+time.getYMDHMS()+"',password='"+password+"' WHERE employeeid="+id;
		sqli="INSERT INTO password(employeeid,password,time) VALUES("+id+",'"+password+"','"+time.getYMDHMS()+"')";
		try {
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqlsp);
			//不是第一次设置更新数据库
			if(rs.next()){
				db.close();
				stmt=db.getStmt();
				temp=0;
				temp=stmt.executeUpdate(sqlu);
				if(temp>0){
					request.setAttribute("msg","设置成功");
				}else{
					request.setAttribute("msg","设置失败");
				}
				db.close();
			}else{
			//第一次设置
				db.close();
				temp=0;
				stmt=db.getStmtread();
				rs=stmt.executeQuery(sqlse);
				if(rs.next()){
					//id存在
					rs.close();
					stmt.close();
					temp=0;
					stmt=db.getStmt();
					temp=stmt.executeUpdate(sqli);
					if(temp>0){
						request.setAttribute("msg","设置成功");
					}else{
						request.setAttribute("msg","设置失败");
					}
					db.close();
				}else{
				//id不存在
					db.close();
					request.setAttribute("msg","员工序号不存在");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			RequestDispatcher dispatcher=request.getRequestDispatcher("set1.jsp");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
