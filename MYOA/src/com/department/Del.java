package com.department;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oa.sys.Db;
import oa.sys.Str;
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
		sqld="DELETE FROM department WHERE departmentid="+id;
		sqls="SELECT * FROM department WHERE departmentid="+id;
		stmt=db.getStmtread();
		try {
			rs=stmt.executeQuery(sqls);
			//��ѯ��Ӳ����Ƿ����
			if(rs.next()){
				rs.close();
				stmt.close();
				//ɾ������
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqld);
				if(temp>0){
					request.setAttribute("delmsg","ɾ���ɹ�");
				}else{
					request.setAttribute("delmsg","ɾ��ʧ��");
				}
			}else{
				request.setAttribute("delmsg","�ò��Ų�����");
			}
		} catch (SQLException e) {
			request.setAttribute("delmsg","ɾ��ʧ��,��ɾ�����ڴ˲��ŵ�����Ա��");
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
