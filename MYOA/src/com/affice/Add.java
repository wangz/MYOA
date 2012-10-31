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
 *类名称：	Add<br>
 *类功能：	增加公告信息<br>
 ****************************************************
 */
public class Add extends HttpServlet{ 
	private HttpSession session=null;
	private ResultSet rs=null;
	private Statement stmt=null;
	private String title,content,sqli;
	private int temp=0,id,afficeid=0;
	private PageContext pagecontext=null;
	private JspFactory jspxFactory = null;//工厂类对象
	private String filename;//附件名称
	private int filesize;//附件大小
	private String filepath;//附件路径	
	private String affix="";//保存附件名称
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("gb2312");//设定统一编码样式，解决中文显示问题
		response.setContentType("text/html; charset=gb2312");
		
		Str str=new Str();//获得字符串转化类中的对象
		Db db=new Db();//获得数据库连接对象
		Time time=new Time();//获得显示时间类中的对象
		
		PrintWriter out=response.getWriter();//获得输出流对象
		session=request.getSession();//返回和客户端关联的Session

		jspxFactory=javax.servlet.jsp.JspFactory.getDefaultFactory();
		pagecontext=jspxFactory.getPageContext(this, request, response,"", true, 8192, true);
		SmartUpload su=new SmartUpload();
		su.initialize(pagecontext);
		
		try {
			su.upload();
			
			int count = su.save("/upload");
			System.out.println(count+"个文件上传成功！<br>");

		}catch (Exception e) {
			e.printStackTrace();
		}
		//id=Integer.parseInt((String)session.getAttribute("id"));//获得员工登陆的ID号
		//上面这种转换出现错误~说session里的是object对象
		Object obj=session.getAttribute("id");
		id=Integer.parseInt(obj.toString());
		System.out.println(id);
		title=su.getRequest().getParameter("title");//接收表单提交过来公告标题
		content=su.getRequest().getParameter("content");//接收表单提交过来的公告内容
		title=str.inStr(title);//对标题进行字符串的格式转化
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
				temp=stmt.executeUpdate(sqli);//执行插入的SQL语句
				if(temp>0){
					request.setAttribute("msg","发布成功");//通过"名-值"对的形式将信息保存在Request范围内
				}
				else{
					request.setAttribute("msg","发布失败");
				}
		
			}
		catch (SQLException e) {
			e.printStackTrace();
		}				
		finally{
			db.close();
			//处理完客户请求后，将请求转发到相应的JSP页来显示处理结果
			RequestDispatcher dispatcher=request.getRequestDispatcher("add.jsp");
			dispatcher.forward(request,response);
		}
	}
	
		
	//doGet()方法的执行效果和doPost()方法一样
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
}
