package com.affice;

import oa.sys.*;
import oa.sys.Time;
import com.jspsmart.upload.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
/**
 ****************************************************
 *�����ƣ�	Add<br>
 *�๦�ܣ�	���ӹ�����Ϣ<br>
 ****************************************************
 */
public class Add extends HttpServlet{ 
	private HttpSession session=null;
	private ResultSet rs=null;
	private Statement stmt=null;
	private String title,content,sqli;
	private int temp=0,id,afficeid=0;
	private PageContext pagecontext=null;
	private JspFactory jspxFactory = null;//���������
	private String filename;//��������
	private int filesize;//������С
	private String filepath;//����·��	
	private String affix="";//���渽������
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");//�趨ͳһ������ʽ�����������ʾ����
		response.setContentType("text/html; charset=gb2312");
		
		Str str=new Str();//����ַ���ת�����еĶ���
		Db db=new Db();//������ݿ����Ӷ���
		Time time=new Time();//�����ʾʱ�����еĶ���
		
		PrintWriter out=response.getWriter();//������������
		session=request.getSession();//���غͿͻ��˹�����Session

		jspxFactory=javax.servlet.jsp.JspFactory.getDefaultFactory();
		pagecontext=jspxFactory.getPageContext(this, request, response,"", true, 8192, true);
		SmartUpload su=new SmartUpload();
		su.initialize(pagecontext);
		
		try {
			su.upload();
			
			int count = su.save("/upload");
			System.out.println(count+"���ļ��ϴ��ɹ���<br>");

		}catch (Exception e) {
			e.printStackTrace();
		}
		//id=Integer.parseInt((String)session.getAttribute("id"));//���Ա����½��ID��
		//��������ת�����ִ���~˵session�����object����
		Object obj=session.getAttribute("id");
		id=Integer.parseInt(obj.toString());
		System.out.println(id);
		title=su.getRequest().getParameter("title");//���ձ��ύ�����������
		content=su.getRequest().getParameter("content");//���ձ��ύ�����Ĺ�������
		title=str.inStr(title);//�Ա�������ַ����ĸ�ʽת��
		content=str.inStr(content);
		
		
		
		
		
		
		try{
		   System.out.print("1"); 
			com.jspsmart.upload.File file=su.getFiles().getFile(0);
			
			
			
		if (!file.isMissing()){
			filename=file.getFileName();
			affix=filename;
			System.out.print(filename);
			filesize=file.getSize();
			filepath=file.getFilePathName();
			
		}else{ 
			filename=null;		
			filesize=0;
			filepath="";
		}		
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		try{
			                  
			stmt=db.getStmt();
			rs=stmt.executeQuery("select afficeid from affice");
		       while(rs.next()){afficeid=rs.getInt(1);}
		       afficeid=afficeid+1;	
		       
		       
		sqli="INSERT INTO affice(afficeid,title,time,employeeid,content,affix)"+
		" VALUES("+afficeid+",'"+title+"','"+time.getYMDHMS()+"',"+id+",'"+content+"','"+affix+"')";
							
				//db.close();
				stmt=db.getStmt();
				temp=stmt.executeUpdate(sqli);//ִ�в����SQL���
				if(temp>0){
					request.setAttribute("msg","�����ɹ�");//ͨ��"��-ֵ"�Ե���ʽ����Ϣ������Request��Χ��
				}
				else{
					request.setAttribute("msg","����ʧ��");
				}
		
			}
		catch (SQLException e) {
			e.printStackTrace();
		}				
		finally{
			db.close();
			//������ͻ�����󣬽�����ת������Ӧ��JSPҳ����ʾ������
			RequestDispatcher dispatcher=request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request,response);
		}
	}
	
		
	//doGet()������ִ��Ч����doPost()����һ��
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
