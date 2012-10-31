package com.department;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oa.data.Department;
import oa.sys.Db;
import oa.sys.Str;
/**
 ****************************************************
 *类名称：	Select<br>
 *类功能：	查找部门信息<br>
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
		
		sqls="SELECT * FROM department WHERE departmentid="+id;
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
					Department dep=new Department();
					dep.setId(id);
					dep.setName(name);
					dep.setExplain(explain);
					ret.add(dep);
				}
				request.setAttribute("msg2",ret);
			}
			db.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
				dispatcher=request.getRequestDispatcher("change.jsp");
			   dispatcher.forward(request,response);
		}
	}	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}