package com.em;

import oa.sys.*;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	Save<br>
 *类功能：	保存员工信息<br>
 ****************************************************
*/
public class Save extends HttpServlet{
	private Statement stmt=null;
	private String name,birthday,learn,post,tel,addr,sex,sql;
	private RequestDispatcher dispatcher=null;
	private HttpSession session=null;
	private int deid,jobid,stateid,temp,id;
	private PrintWriter out=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out=response.getWriter();
		session=request.getSession();
		//获取数据
		name=(String)request.getParameter("name");
		sex=(String)request.getParameter("sex");
		birthday=(String)request.getParameter("birthday");
		learn=(String)request.getParameter("learn");
		post=(String)request.getParameter("post");
		tel=(String)request.getParameter("tel");
		addr=(String)request.getParameter("addr");
		try{
			id=Integer.parseInt(request.getParameter("id"));
		}catch(Exception e){
			id=0;
		}
		try{
			deid=Integer.parseInt((String)request.getParameter("depid"));
		}catch(Exception e){
		}
		try{
			jobid=Integer.parseInt((String)request.getParameter("jobid"));
		}catch(Exception e){
		}
		try{
			stateid=Integer.parseInt((String)request.getParameter("emsid"));
		}catch(Exception e){
		}
		Db db=new Db();
		Str str=new Str();
		//字符转换
		name=str.inStr(name);
		sex=str.inStr(sex);
		birthday=str.inStr(birthday);
		learn=str.inStr(learn);
		post=str.inStr(post);
		tel=str.inStr(tel);
		addr=str.inStr(addr);
		
		stmt=db.getStmt();
		int idd=0;
		ResultSet rs;
		try {
			rs= stmt.executeQuery("select employeeid from eminfo");
			while(rs.next())
			{
				idd=rs.getInt(1);
			}
			idd=idd+1;
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		if(id!=0){
			sql="UPDATE eminfo SET name='"+name+"',sex='"+sex+"',birthday='"+birthday+"',learn='"
			+learn+"',post='"+post+"',departmentid="+deid+",jobid="+jobid+",tel='"+tel+"',addr='"
			+addr+"',stateid="+stateid+" WHERE employeeid="+id;
		}else{
			sql="INSERT INTO eminfo(employeeid,name,sex,birthday,learn,post,departmentid,jobid,tel,addr,stateid)"
			+"VALUES("+idd+",'"+name+"','"+sex+"','"+birthday+"','"+learn+"','"+post+"',"+deid+","+jobid+",'"
			+tel+"','"+addr+"',"+stateid+")";
		}
		try{
			stmt=db.getStmt();
			temp=stmt.executeUpdate(sql);
			if(temp>0){
				request.setAttribute("msg","操作成功");
			}else{
				request.setAttribute("msg","操作失败");
			}
		}catch(Exception e){
			request.setAttribute("msg","操作失败,请先添加部门、职位和员工状态等信息");
			e.printStackTrace();
		}finally{
			db.close();
			if(id!=0){
				dispatcher=request.getRequestDispatcher("add?id="+id);
			}else{
				dispatcher=request.getRequestDispatcher("add.jsp");
			}
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
