package com.job;

import oa.sys.*;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *�����ƣ�	Add<br>
 *�๦�ܣ�	����ְλ��Ϣ<br>
 ****************************************************
*/
public class Add extends HttpServlet{
	private HttpSession session=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private String name,explain,sqli,sqls;
	private int temp=0;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		session=request.getSession();
		name=request.getParameter("name");
		explain=request.getParameter("explain");
		name=str.inStr(name);
		explain=str.inStr(explain);
		sqli="INSERT INTO job(name,explain) VALUES('"+name+"','"+explain+"')";
		sqls="SELECT * FROM job WHERE name='"+name+"'";
		stmt=db.getStmtread();
		try {
			rs=stmt.executeQuery(sqls);
			//��ѯ���ְλ�Ƿ����
			if(rs.next()){
				session.setAttribute("depmsg","��ְλ�Ѵ���");
			}else{
				rs.close();
				stmt.close();
				//���ְλ
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqli);
				if(temp>0){
					session.setAttribute("depmsg","��ӳɹ�");
				}else{
					session.setAttribute("depmsg","���ʧ��");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request,response);
		}
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
