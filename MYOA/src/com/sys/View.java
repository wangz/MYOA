package com.sys;

import oa.sys.*;
import oa.data.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	View<br>
 *类功能：	浏览公告发布人信息<br>
 ****************************************************
 */
public class View extends HttpServlet{
	private Statement stmt=null;
	private ResultSet rs=null;
	private Statement stmt1=null;
	private ResultSet rs1=null;
	private String name,dep,state,tel,sql="SELECT * FROM eminfo where limit=1";
	private RequestDispatcher dispatcher=null;
	private HttpSession session=null;
	private int deid,stateid,id;
	private PrintWriter out=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out=response.getWriter();
		session=request.getSession();
		Collection coll=new ArrayList();
		//获取数据
		Db db=new Db();
		Str str=new Str();
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				id=rs.getInt(1);
				name=rs.getString(2);												
				deid=rs.getInt(7);
				tel=rs.getString(9);
				stateid=rs.getInt(11);
				dep=db.IdtoDo("Name","department WHERE departmentid="+deid);
				state=db.IdtoDo("Name","emstate WHERE stateid="+stateid);
				//字符转换
				name=str.outStr(name);
				dep=str.outStr(dep);
				state=str.outStr(state);
				tel=str.outStr(tel);
				Eminfo eminfo=new Eminfo();
				eminfo.setId(id);
				eminfo.setName(name);
				eminfo.setDepartment(dep);
				eminfo.setTel(tel);
				eminfo.setState(state);
				coll.add(eminfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
			request.setAttribute("msg",coll);
			dispatcher=request.getRequestDispatcher("view.jsp");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}