package com.affice;

import oa.sys.*;
import oa.data.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *�����ƣ�	View<br>
 *�๦�ܣ�	�鿴������Ϣ<br>
 ****************************************************
*/
public class View extends HttpServlet{
	private int employeeid;//Ա��id��
	private String time;//����ʱ��
	private Statement stmt;
	private ResultSet rs;
	private String title,content;//������������
	private String affix;
	private RequestDispatcher dispatcher;//����ת������
	private int id=0;//���ı��
	private String flag;//�жϷ���ɾ��ҳ�滹�����ҳ��

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Db db=new Db();
		Str str=new Str();
		Collection ret=new ArrayList();//���һ��������Ķ���
		PrintWriter out=response.getWriter();
		flag=(String)request.getParameter("flag");
		System.out.print(flag);
		if(flag!=null){
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery("SELECT * FROM affice");
			while(rs.next()){//�����ݿ���ȡֵ
				id=rs.getInt(1);
				title=rs.getString(2);
				time=rs.getString(3);
				employeeid=rs.getInt(4);
				content=rs.getString(5);
				affix=rs.getString(6);
				title=str.outStr(title);
				content=str.outStr(content);
				affix=str.outStr(affix);
				//��ù�����ϢBean�Ķ��󣬲��Ҹ�Bean�����Ը�ֵ
				Affice affice=new Affice();
				affice.setId(id);
				affice.setTitle(title);
				affice.setEmid(employeeid);
				affice.setTime(time);
				affice.setContent(content);
				affice.setAffix(affix); 
				//��������ϢBean�Ķ�����ӵ�������Ķ�����
				ret.add(affice);
			}
				request.setAttribute("msg",ret);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
			if(flag.equals("view")){
			dispatcher=request.getRequestDispatcher("view.jsp");
			dispatcher.forward(request,response);
			}
			else if(flag.equals("del"))
			{
				dispatcher=request.getRequestDispatcher("del.jsp");
				dispatcher.forward(request,response);
			}
		}
			
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
