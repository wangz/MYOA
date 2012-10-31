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
 *类名称：	Select<br>
 *类功能：	按员工信息，获取员工信息和职位，状态，和部门信息等条件浏览员工
 ****************************************************
 */
public class Select extends HttpServlet{
	private Statement stmt=null;
	private ResultSet rs=null;
	private Statement stmt1=null;
	private ResultSet rs1=null;
	private String name,birthday,dep,job,state,learn,post,tel,addr,sql;
	private RequestDispatcher dispatcher=null;
	private HttpSession session=null;
	private int depid,jobid,stateid,sex,id;
	private PrintWriter out=null;
	private String flag;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out=response.getWriter();
		session=request.getSession();
		Collection coll=new ArrayList();
		//获取数据
		Db db=new Db();
		Str str=new Str();
		flag=(String)request.getParameter("flag");
		depid=Integer.parseInt(request.getParameter("depid"));
		jobid=Integer.parseInt(request.getParameter("jobid"));
		stateid=Integer.parseInt(request.getParameter("emsid"));
		
		
		request.setAttribute("depid", String.valueOf(depid));		
		request.setAttribute("jobid", String.valueOf(jobid));		
		request.setAttribute("stateid", String.valueOf(stateid));
		
		if(depid==0&&jobid==0&&stateid==0)
		{
			sql="select * from eminfo";
		}
		else if(depid==0&&jobid==0&&stateid!=0)
		{
			sql="select * from eminfo where stateid="+stateid;
		}
		else if(depid==0&&jobid!=0&&stateid==0)
		{
			sql="select * from eminfo where jobid="+jobid;
		}
		else if(depid==0&&jobid!=0&&stateid!=0)
		{
			sql="select * from eminfo where stateid="+stateid+" and jobid="+jobid;
		}
		else if(depid!=0&&jobid==0&&stateid==0)
		{
			sql="select * from eminfo where departmentid="+depid;
		}
		else if(depid!=0&&jobid==0&&stateid!=0)
		{
			sql="select * from eminfo where departmentid="+depid+" and stateid="+stateid;
		}
		else if(depid!=0&&jobid!=0&&stateid==0)
		{
			sql="select * from eminfo where departmentid="+depid+" and jobid="+jobid;
		}
		else if(depid!=0&&jobid!=0&&stateid!=0)
		{
			sql="select * from eminfo where departmentid="+depid+" and jobid="+jobid+" and stateid="+stateid;
		}
		
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
		}
		
		
		try{
			stmt=db.getStmtread();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				id=rs.getInt(1);
				name=rs.getString(2);
				sex=rs.getInt(3);
				birthday=rs.getString(4);
				learn=rs.getString(5);
				post=rs.getString(6);
				depid=rs.getInt(7);
				jobid=rs.getInt(8);
				tel=rs.getString(9);
				addr=rs.getString(10);
				stateid=rs.getInt(11);
				dep=db.IdtoDo("Name","department WHERE departmentid="+depid);
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
				eminfo.setId(id);
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
			}
			

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.close();
			
			request.setAttribute("msg",coll);
			if(flag.equals("update"))
			{
		      dispatcher=request.getRequestDispatcher("update.jsp");
		      dispatcher.forward(request,response);
			}
			else{
			dispatcher=request.getRequestDispatcher("view.jsp");
			dispatcher.forward(request,response);
			}
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}