package com.job;

import oa.sys.*;
import oa.data.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	Select<br>
 *类功能：	查找职位信息<br>
 ****************************************************
*/
public class Select  extends HttpServlet{
	private Statement stmt=null;
	private ResultSet rs=null;
	private String name,explain,sqls;
	private RequestDispatcher dispatcher;
	private int id=0;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Db db=new Db();
		Str str=new Str();
		PrintWriter out=response.getWriter();
		try{
			id=Integer.parseInt((String)request.getParameter("id"));
		}catch(Exception e){
		}
		
		sqls="SELECT * FROM job WHERE jobid="+id;
		Collection ret=new ArrayList();
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqls);
			//判断是否有数据
			if(rs.next()){
				rs.beforeFirst();
				if(rs.next()){
					id=rs.getInt(1);
					name=rs.getString(2);
					explain=rs.getString(3);
					name=str.outStr(name);
					explain=str.outStr(explain);
					Job job=new Job();
					job.setId(id);
					job.setName(name);
					job.setExplain(explain);
					ret.add(job);
				}
				request.setAttribute("msg2",ret);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		db.close();							
			dispatcher=request.getRequestDispatcher("change.jsp");
			dispatcher.forward(request,response);
		}
	}	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}