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
 *类名称：	Read<br>
 *类功能：	读取公告<br>
 ****************************************************
*/
public class Read extends HttpServlet{
	private int news;
	private String time;
	private int afficeid,employeeid;
	private HttpSession session=null;
	private ResultSet rs=null;
	private Statement stmt=null;
	private String title,content,sqls;
	private int temp=0;
	private String affix;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		Collection coll=new ArrayList();
		PrintWriter out=response.getWriter();
		session=request.getSession();
		try{
			afficeid=Integer.parseInt((String)request.getParameter("afficeid"));
		}catch(Exception e){
			e.printStackTrace();
		}
		sqls="SELECT * FROM affice WHERE afficeid="+afficeid;
		out.print(sqls);
		try {
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqls);
			if(rs.next()){
				afficeid=rs.getInt(1);
				title=rs.getString(2);
				time=rs.getString(3);
				employeeid=rs.getInt(4);
				content=rs.getString(5);
				affix=rs.getString(6);
				Affice aff=new Affice();
				aff.setId(afficeid);
				aff.setTitle(title);
				aff.setEmid(employeeid);
				aff.setTime(time);
				aff.setContent(content);
				aff.setAffix(affix);
				coll.add(aff);
				rs.close();
				stmt.close();				
			}
			request.setAttribute("msg",coll);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			db.close();
			RequestDispatcher dispatcher=request.getRequestDispatcher("read.jsp");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}