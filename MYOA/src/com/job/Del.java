package com.job;

import oa.sys.*;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *�����ƣ�	Del<br>
 *�๦�ܣ�	ɾ��ְλ��Ϣ<br>
 ****************************************************
*/
public class Del extends HttpServlet{
	private HttpSession session=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private String sqld,sqls;
	private int temp=0,id=0;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		PrintWriter out=response.getWriter();
		session=request.getSession();
		try{
		id=Integer.parseInt((String)request.getParameter("id"));
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		sqld="DELETE FROM job WHERE jobid="+id;
		sqls="SELECT * FROM job WHERE jobid="+id;
		stmt=db.getStmtread();
		try {
			rs=stmt.executeQuery(sqls);
			//��ѯ���ְλ�Ƿ����
			if(rs.next()){
				rs.close();
				stmt.close();
				//ɾ��ְλ
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqld);
				if(temp>0){
					request.setAttribute("delmsg","ɾ���ɹ�");
				}else{
					request.setAttribute("delmsg","ɾ��ʧ��");
				}
			}else{
				request.setAttribute("delmsg","��ְλ������");
			}
		} catch (SQLException e) {
			request.setAttribute("delmsg","ɾ��ʧ��,��ɾ�����ڴ�ְλ�µ�����Ա��");
			System.err.print(e.getMessage());
		}finally{
			db.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("del.jsp");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
