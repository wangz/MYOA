package com.department;

import java.io.IOException;
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
 *�����ƣ�	Add<br>
 *�๦�ܣ�	���Ӳ�����Ϣ<br>
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
		sqli="INSERT INTO department(name,explain) VALUES('"+name+"','"+explain+"')";
		sqls="SELECT * FROM department WHERE name='"+name+"'";
		stmt=db.getStmtread();
		try {
			rs=stmt.executeQuery(sqls);
			//��ѯ��Ӳ����Ƿ����
			if(rs.next()){
				session.setAttribute("depmsg","�ò����Ѵ���");
			}else{
				rs.close();
				stmt.close();
				//��Ӳ���
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
