package com.em;

import oa.sys.*;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *�����ƣ�	Save<br>
 *�๦�ܣ�	�޸ĺ󱣴�Ա����Ϣ<br>
 ****************************************************
*/
public class Change_save extends HttpServlet{
	private Statement stmt=null;
	private String name,birthday,learn,post,tel,addr,sex,sql;
	private RequestDispatcher dispatcher=null;
	private HttpSession session=null;
	private int deid,jobid,stateid,temp,emid;
	private PrintWriter out=null;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out=response.getWriter();
		session=request.getSession();
		//��ȡ����
		name=(String)request.getParameter("name");
		sex=(String)request.getParameter("sex");
		birthday=(String)request.getParameter("birthday");
		learn=(String)request.getParameter("learn");
		post=(String)request.getParameter("post");
		tel=(String)request.getParameter("tel");
		addr=(String)request.getParameter("addr");
		emid=Integer.parseInt(request.getParameter("emid"));
		
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
		//�ַ�ת��
		name=str.inStr(name);
		sex=str.inStr(sex);
		birthday=str.inStr(birthday);
		learn=str.inStr(learn);
		post=str.inStr(post);
		tel=str.inStr(tel);
		addr=str.inStr(addr);
		
		stmt=db.getStmt();
		
		ResultSet rs;
	    
				
			sql="UPDATE eminfo SET name='"+name+"',sex='"+sex+"',birthday='"+birthday+"',learn='"
			+learn+"',post='"+post+"',departmentid="+deid+",jobid="+jobid+",tel='"+tel+"',addr='"
			+addr+"',stateid="+stateid+" WHERE employeeid="+emid;		
		
			try{
			stmt=db.getStmt();
			temp=stmt.executeUpdate(sql);
			if(temp>0){
				request.setAttribute("msg","�����ɹ�");
			}else{
				request.setAttribute("msg","����ʧ��");
			}
		}catch(Exception e){
			request.setAttribute("msg","����ʧ��,������Ϣ�Ƿ�����");
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
