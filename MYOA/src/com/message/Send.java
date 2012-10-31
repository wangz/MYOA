package com.message;

import oa.sys.*;
import oa.sys.Time;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	Send<br>
 *类功能：	发送站内信<br>
 ****************************************************
*/
public class Send extends HttpServlet{
	private int acceptid;
	private HttpSession session=null;
	private ResultSet rs=null;
	private Statement stmt=null;
	private String title,content,sqli,sqls;
	private int temp=0,id;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		Str str=new Str();
		Db db=new Db();
		Time time=new Time();
		PrintWriter out=response.getWriter();
		session=request.getSession();
		id=Integer.parseInt(session.getAttribute("id").toString());
		try{
			acceptid=Integer.parseInt((String)request.getParameter("acceptid"));
		}catch(Exception e){
			e.printStackTrace();
		}
		title=request.getParameter("title");
		content=request.getParameter("content");
		title=str.inStr(title);
		content=str.inStr(content);
		sqli="INSERT INTO message(title,time,sender,accepter,content) VALUES('"+title+"','"+time.getYMDHMS()+"',"+id
			+","+acceptid+",'"+content+"')";
		sqls="SELECT * FROM eminfo WHERE employeeid="+acceptid;
		try {
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sqls);
			if(rs.next()){
				rs.close();
				stmt.close();
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqli);
				if(temp>0){
					request.setAttribute("msg","发送成功");
				}else{
					request.setAttribute("msg","发送失败");
				}
				db.close();
			}else{
				request.setAttribute("msg","接收人序号不存在");
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			RequestDispatcher dispatcher=request.getRequestDispatcher("send.jsp");
			dispatcher.forward(request,response);
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}

