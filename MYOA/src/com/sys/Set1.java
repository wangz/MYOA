package com.sys;

import oa.sys.*;
import oa.sys.Time;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *�����ƣ�	Set<br>
 *�๦�ܣ�	����Ա������<br>
 ****************************************************
*/
public class Set1 extends HttpServlet{
	private Db db=null;
	private Str str=null;
	private Time time=null;
	private int temp,id;
	private String password,sqlu,sqli,sqlsp,sqlse;
	private HttpSession session=null;
	private PrintWriter out=null;
	private ResultSet rs=null;
	private Statement stmt=null;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out = response.getWriter();
		session=request.getSession();
		time=new Time();
		str=new Str();
		db=new Db();
		
		//ȡ��
		try{
			id=Integer.parseInt((String)request.getParameter("id"));
		}catch(Exception e){
			id=0;
		}
		password=request.getParameter("password");
		password=str.inStr(password);
		sqlsp="SELECT * FROM password WHERE employeeid="+id;
		sqlse="SELECT employeeid FROM eminfo WHERE employeeid="+id;
		sqlu="UPDATE password SET time='"+time.getYMDHMS()+"',password='"+password+"' WHERE employeeid="+id;
		sqli="INSERT INTO password(employeeid,password,time) VALUES("+id+",'"+password+"','"+time.getYMDHMS()+"')";
		try {
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqlsp);
			//���ǵ�һ�����ø������ݿ�
			if(rs.next()){
				db.close();
				stmt=db.getStmt();
				temp=0;
				temp=stmt.executeUpdate(sqlu);
				if(temp>0){
					request.setAttribute("msg","���óɹ�");
				}else{
					request.setAttribute("msg","����ʧ��");
				}
				db.close();
			}else{
			//��һ������
				db.close();
				temp=0;
				stmt=db.getStmtread();
				rs=stmt.executeQuery(sqlse);
				if(rs.next()){
					//id����
					rs.close();
					stmt.close();
					temp=0;
					stmt=db.getStmt();
					temp=stmt.executeUpdate(sqli);
					if(temp>0){
						request.setAttribute("msg","���óɹ�");
					}else{
						request.setAttribute("msg","����ʧ��");
					}
					db.close();
				}else{
				//id������
					db.close();
					request.setAttribute("msg","Ա����Ų�����");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			RequestDispatcher dispatcher=request.getRequestDispatcher("set1.jsp");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
