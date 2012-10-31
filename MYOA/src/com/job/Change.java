package com.job;

import oa.sys.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *�����ƣ�	Change<br>
 *�๦�ܣ�	����ְλ��Ϣ<br>
 ****************************************************
 */
public class Change extends HttpServlet{
	private Statement stmt=null;
	private String name,explain,sqlu;
	private int id=0,temp=0;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		//��ȡid
		try{
		id=Integer.parseInt((String)request.getParameter("id"));
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		name=request.getParameter("name");
		explain=request.getParameter("explain");
		name=str.inStr(name);
		explain=str.inStr(explain);
		PrintWriter out=response.getWriter();
		sqlu="UPDATE job SET name='"+name+"',explain='"+explain+"' WHERE jobid="+id;
		//�޸�
		try{
			stmt=db.getStmt();
			temp=stmt.executeUpdate(sqlu);
			if(temp>0){
				request.setAttribute("selmsg","�޸ĳɹ�");
			}else{
				request.setAttribute("selmsg","�޸�ʧ��");
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