package com.message;

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
 *类功能：	读站内信息<br>
 ****************************************************
 */
public class Read extends HttpServlet{
	private int news;
	private int accepter;
	private int sender;
	private String time;
	private int messageid;
	private HttpSession session=null;
	private ResultSet rs=null;
	private Statement stmt=null;
	private String title,content,sqls;
	private int temp=0,id,count;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		Collection coll=new ArrayList();
		PrintWriter out=response.getWriter();
		session=request.getSession();
		try{
			id=Integer.parseInt(session.getAttribute("id").toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			messageid=Integer.parseInt(request.getParameter("messageid").toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		sqls="SELECT * FROM message WHERE accepter="+id+" AND messageid ="+messageid;
		out.print(sqls);
		try {
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqls);
			if(rs.next()){
				messageid=rs.getInt(1);
				title=rs.getString(2);
				time=rs.getString(3);
				sender=rs.getInt(4);
				accepter=rs.getInt(5);
				content=rs.getString(6);
				news=rs.getInt(7);
				Message info=new Message();
				info.setId(messageid);
				info.setTitle(title);
				info.setTime(time);
				info.setSender(sender);
				info.setAccepter(accepter);
				info.setContent(content);
				info.setNews(news);
				coll.add(info);
				rs.close();
				stmt.close();
				stmt=db.getStmt();
				stmt.executeUpdate("UPDATE message SET new=1 WHERE messageid="+messageid);
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