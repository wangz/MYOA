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
 *�����ƣ�	View<br>
 *�๦�ܣ�	���Ա����Ϣ����ȡԱ����Ϣ��ְλ��״̬���Ͳ�����Ϣ
 ****************************************************
 */
public class View extends HttpServlet{
	private Statement stmt=null;
	private ResultSet rs=null;
	private Statement stmt1=null;
	private ResultSet rs1=null;
	private String name,birthday,dep,job,state,learn,post,tel,addr,sql="SELECT * FROM eminfo";
	private RequestDispatcher dispatcher=null;
	private HttpSession session=null;
	private int deid,jobid,stateid,sex,id;
	private PrintWriter out=null;
	private String flag;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		out=response.getWriter();
		session=request.getSession();
		Collection coll=new ArrayList();
		flag=(String)request.getParameter("flag");
		//��ȡ����
		Db db=new Db();
		Str str=new Str();
		
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
				deid=rs.getInt(7);
				jobid=rs.getInt(8);
				tel=rs.getString(9);
				addr=rs.getString(10);
				stateid=rs.getInt(11);
				dep=db.IdtoDo("Name","department WHERE departmentid="+deid);
				job=db.IdtoDo("Name","job WHERE jobid="+jobid);
				state=db.IdtoDo("Name","emstate WHERE stateid="+stateid);
				//�ַ�ת��
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