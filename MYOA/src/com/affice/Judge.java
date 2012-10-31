package com.affice;

import oa.sys.*;
import oa.sys.Time;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	Judge<br>
 *类功能：	判断是否为公告发布者<br>
 ****************************************************
 */
public class Judge extends HttpServlet{
	private HttpSession session=null;
	private ResultSet rs=null;
	private Statement stmt=null;

	private int id;
	private RequestDispatcher dispatcher;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");//设定统一编码样式，解决中文显示问题
		response.setContentType("text/html; charset=gb2312");
		Db db=new Db();//获得数据库连接对象
		PrintWriter out=response.getWriter();//获得输出流对象
		session=request.getSession();//返回和客户端关联的Session
		//id=Integer.parseInt((String)session.getAttribute("id"));//获得员工登陆的ID号
		//上面这种转换出现错误~说session里的是object对象
		Object obj=session.getAttribute("id");
		id=Integer.parseInt(obj.toString());

		try{
			stmt=db.getStmt();
			rs=stmt.executeQuery("select * from eminfo where employeeid ="+id+" and limit=1");
				
			if(rs.next())
			{//是发布者                    
		      dispatcher=request.getRequestDispatcher("add.jsp");	
		      dispatcher.forward(request,response);
			}		
		else{
			   session.setAttribute("error", "您不是信息发布者，不能发布信息");
			   dispatcher=request.getRequestDispatcher("/error/errorpage.jsp");
			   dispatcher.forward(request,response);
			}
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
				
		finally{
			db.close();						
			
		}
	}
	
	
	
	//doGet()方法的执行效果和doPost()方法一样
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
