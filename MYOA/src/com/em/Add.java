package com.em;

import oa.sys.*;
import oa.data.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 ****************************************************
 *类名称：	Add<br>
 *类功能：	获取部门、职位、员工状态信息<br>
 ****************************************************
 */
public class Add extends HttpServlet{
	private String state;
	private String job;
	private String dep;
	private int stateid;
	private String addr;
	private String tel;
	private int jobid;
	private int deid;
	private String post;
	private String learn;
	private String birthday;
	private int sex;
	private String name;
	private Statement stmt=null;
	private ResultSet rs=null;
	private RequestDispatcher dispatcher=null;
	private HttpSession session=null;
	private int emid=0;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		session=request.getSession();
		Db db=new Db();
		Str str=new Str();
		PrintWriter out=response.getWriter();
		//获取id取出员工基本信息
		try{
			emid=Integer.parseInt((String)request.getParameter("emid"));
			Collection coll=new ArrayList();
			stmt=db.getStmtread();
			rs=stmt.executeQuery("SELECT * FROM eminfo WHERE employeeid="+emid);
			if(rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					emid=rs.getInt(1);
					name=rs.getString(2);
					sex=rs.getInt(3);
					birthday=rs.getString(4);
					learn=rs.getString(5);
					post=rs.getString(6);
					deid=rs.getInt(7);
					jobid=rs.getInt(8);
					tel=rs.getString(9);
					addr=rs.getString(10);
					stateid=rs.getInt(11);
					dep=db.IdtoDo("Name","department WHERE departmentid="+deid);
					job=db.IdtoDo("Name","job WHERE jobid="+jobid);
					state=db.IdtoDo("Name","emstate WHERE stateid="+stateid);
					//字符转换
					name=str.outStr(name);
					birthday=birthday.substring(0,10);
					dep=str.outStr(dep);
					job=str.outStr(job);
					state=str.outStr(state);
					learn=str.outStr(learn);
					post=str.outStr(post);
					tel=str.outStr(tel);
					addr=str.outStr(addr);
					Eminfo eminfo=new Eminfo();
					eminfo.setId(emid);
					eminfo.setName(name);
					eminfo.setSex(sex);
					eminfo.setBirthday(birthday);
					eminfo.setLearn(learn);
					eminfo.setPost(post);
					eminfo.setDepartment(dep);
					eminfo.setJob(job);
					eminfo.setTel(tel);
					eminfo.setAddr(addr);
					eminfo.setState(state);
					coll.add(eminfo);
					//System.out.print(eminfo.getDepartment());
					//System.out.print(eminfo.getState());
					//System.out.print(eminfo.getJob());
				}//while
				session.setAttribute("msgem",coll);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			emid=0;
		}finally{
			db.close();
		}
		//三个条件分别保存
		Collection retd=new ArrayList();
		Collection retj=new ArrayList();
		Collection rete=new ArrayList();
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery("SELECT * from department");
			if(rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String explain=rs.getString(3);
					name=str.outStr(name);
					explain=str.outStr(explain);
					Department dep=new Department();
					dep.setId(id);
					dep.setName(name);
					dep.setExplain(explain);
					retd.add(dep);
				}
			}
			db.close();
			stmt=db.getStmtread();
			rs=stmt.executeQuery("SELECT * from job");
			if(rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String explain=rs.getString(3);
					name=str.outStr(name);
					explain=str.outStr(explain);
					Job dep=new Job();
					dep.setId(id);
					dep.setName(name);
					dep.setExplain(explain);
					retj.add(dep);
				}
			}
			db.close();
			stmt=db.getStmtread();
			rs=stmt.executeQuery("SELECT * from emstate");
			if(rs.next()){
				rs.beforeFirst();
				while(rs.next()){
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String explain=rs.getString(3);
					name=str.outStr(name);
					explain=str.outStr(explain);
					Emstate dep=new Emstate();
					dep.setId(id);
					dep.setName(name);
					dep.setExplain(explain);
					rete.add(dep);
				}
			}
			db.close();
			session.removeAttribute("msgd");
			session.setAttribute("msgd",retd);
			session.removeAttribute("msgj");
			session.setAttribute("msgj",retj);
			session.removeAttribute("msge");
			session.setAttribute("msge",rete);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
			if(emid==0){
				dispatcher=request.getRequestDispatcher("add.jsp");
				dispatcher.forward(request,response);
			}else{
				dispatcher=request.getRequestDispatcher("change.jsp");
				dispatcher.forward(request,response);
			}
			
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
