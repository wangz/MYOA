package com.department;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oa.sys.Db;
import oa.sys.Str;
/**
 ****************************************************
 *�����ƣ�	Change<br>
 *�๦�ܣ�	���²�����Ϣ<br>
 ****************************************************
 * */
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
		sqlu="UPDATE department SET name='"+name+"',explain='"+explain+"' WHERE departmentid="+id;
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