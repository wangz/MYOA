package com.sys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oa.sys.*;


import java.sql.*;
/**
 ****************************************************
 *�����ƣ�	Set<br>
 *�๦�ܣ�	Ա���޸�����<br>
 ****************************************************
 */
public class Set2 extends HttpServlet {

	/**
	 * Ա���޸�����
	 */
	private Db db=null;
	private Str str=null;
	private int temp,id=0;
	private String password,passwordnew,sql,sqlse;
	private HttpSession session=null;
	private PrintWriter out=null;
	private ResultSet rs=null;
	private Statement stmt=null;




	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out = response.getWriter();
		session=request.getSession();
		db=new Db();
		str=new Str();
		//�޸��˺�
			//System.out.print(session.getAttribute("id"));
			//id=Integer.parseInt((String)session.getAttribute("id"));
		   Object obj=session.getAttribute("id"); 
		   id=Integer.parseInt(obj.toString());

		password=request.getParameter("password");		
		passwordnew=request.getParameter("passwordnew1");
		
		if (password!=null&&passwordnew!=null){
			
			password=str.inStr(password);
			passwordnew=str.inStr(passwordnew);
			//System.out.print(password);
			//System.out.print(passwordnew);
			//System.out.print(id);
			sqlse="SELECT * FROM password WHERE employeeid="+id+" and password='"+password+"'";
			sql="UPDATE password SET password='"+passwordnew+"' WHERE employeeid="+id;
			try {
				stmt=db.getStmtread();
				rs=stmt.executeQuery(sqlse);
				if(rs.next()){
					db.close();
					stmt=db.getStmt();
					temp=0;
					temp=stmt.executeUpdate(sql);
					if(temp>0){
						request.setAttribute("msg","���óɹ�");
					}else{
						request.setAttribute("msg","����ʧ��");
					}
					db.close();
				}
				else
				{ 
					db.close();
					request.setAttribute("msg", "�������ԭ���벻��ȷ,����������");
				}

			}
			catch(SQLException e){
				e.printStackTrace();

			}
			finally{
				RequestDispatcher dispatcher=request.getRequestDispatcher("set2.jsp");
				dispatcher.forward(request,response);
			}
		}
	}




	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		doPost(request,response);
	}


}
