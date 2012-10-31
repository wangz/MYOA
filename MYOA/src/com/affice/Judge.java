package com.affice;

import oa.sys.*;
import oa.sys.Time;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *�����ƣ�	Judge<br>
 *�๦�ܣ�	�ж��Ƿ�Ϊ���淢����<br>
 ****************************************************
 */
public class Judge extends HttpServlet{
	private HttpSession session=null;
	private ResultSet rs=null;
	private Statement stmt=null;

	private int id;
	private RequestDispatcher dispatcher;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");//�趨ͳһ������ʽ�����������ʾ����
		response.setContentType("text/html; charset=gb2312");
		Db db=new Db();//������ݿ����Ӷ���
		PrintWriter out=response.getWriter();//������������
		session=request.getSession();//���غͿͻ��˹�����Session
		//id=Integer.parseInt((String)session.getAttribute("id"));//���Ա����½��ID��
		//��������ת�����ִ���~˵session�����object����
		Object obj=session.getAttribute("id");
		id=Integer.parseInt(obj.toString());

		try{
			stmt=db.getStmt();
			rs=stmt.executeQuery("select * from eminfo where employeeid ="+id+" and limit=1");
				
			if(rs.next())
			{//�Ƿ�����                    
		      dispatcher=request.getRequestDispatcher("add.jsp");	
		      dispatcher.forward(request,response);
			}		
		else{
			   session.setAttribute("error", "��������Ϣ�����ߣ����ܷ�����Ϣ");
			   dispatcher=request.getRequestDispatcher("/error/errorpage.jsp");
			   dispatcher.forward(request,response);
			}
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
				
		finally{
			db.close();						
			
		}
	}
	
	
	
	//doGet()������ִ��Ч����doPost()����һ��
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
