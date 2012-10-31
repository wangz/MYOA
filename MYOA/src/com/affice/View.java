package com.affice;

import oa.sys.*;
import oa.data.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	View<br>
 *类功能：	查看公告信息<br>
 ****************************************************
*/
public class View extends HttpServlet{
	private int employeeid;//员工id号
	private String time;//发布时间
	private Statement stmt;
	private ResultSet rs;
	private String title,content;//公告标题和内容
	private String affix;
	private RequestDispatcher dispatcher;//请求转发对象
	private int id=0;//公文编号
	private String flag;//判断返回删除页面还是浏览页面

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Db db=new Db();
		Str str=new Str();
		Collection ret=new ArrayList();//获得一个容器类的对象
		PrintWriter out=response.getWriter();
		flag=(String)request.getParameter("flag");
		System.out.print(flag);
		if(flag!=null){
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery("SELECT * FROM affice");
			while(rs.next()){//从数据库中取值
				id=rs.getInt(1);
				title=rs.getString(2);
				time=rs.getString(3);
				employeeid=rs.getInt(4);
				content=rs.getString(5);
				affix=rs.getString(6);
				title=str.outStr(title);
				content=str.outStr(content);
				affix=str.outStr(affix);
				//获得公告信息Bean的对象，并且给Bean的属性赋值
				Affice affice=new Affice();
				affice.setId(id);
				affice.setTitle(title);
				affice.setEmid(employeeid);
				affice.setTime(time);
				affice.setContent(content);
				affice.setAffix(affix); 
				//将公告信息Bean的对象添加到容器类的对象中
				ret.add(affice);
			}
				request.setAttribute("msg",ret);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
			if(flag.equals("view")){
			dispatcher=request.getRequestDispatcher("view.jsp");
			dispatcher.forward(request,response);
			}
			else if(flag.equals("del"))
			{
				dispatcher=request.getRequestDispatcher("del.jsp");
				dispatcher.forward(request,response);
			}
		}
			
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
