package com.affice;

import oa.sys.*;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *�����ƣ�	Del<br>
 *�๦�ܣ�	ɾ��������Ϣ<br>
 ****************************************************
*/
public class Del extends HttpServlet{
	private HttpSession session=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private String sqld;
	private int temp=0,id=0;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Db db=new Db();
		PrintWriter out=response.getWriter();
		session=request.getSession();
		try{
			id=Integer.parseInt((String)request.getParameter("afficeid"));
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		sqld="DELETE FROM affice WHERE afficeid="+id;
		try {
				//ɾ������
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqld);
				if(temp>0){
					request.setAttribute("msg","ɾ���ɹ�");
				}else{
					request.setAttribute("msg","ɾ��ʧ��");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("view?flag=del");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
