package com.affice;

import java.io.IOException;
import java.io.PrintWriter;
import com.jspsmart.upload.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import oa.sys.Str;

public class Download extends HttpServlet {

	private JspFactory jspxFactory = null;//���������
	private String filename;//��������
	private PageContext pagecontext=null;
	Str str=new Str();//����ַ���ת�����еĶ���


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");//�趨ͳһ������ʽ�����������ʾ����
		response.setContentType("text/html; charset=gb2312");
		
		
		jspxFactory=javax.servlet.jsp.JspFactory.getDefaultFactory();
		pagecontext=jspxFactory.getPageContext(this, request, response,"", true, 8192, true);
		SmartUpload su = new SmartUpload();		
		su.initialize(pagecontext);
		su.setContentDisposition(null);
		filename=request.getParameter("affix").toString();
		filename=str.inStr(filename);
		//String result = new String(filename.getBytes("iso-8859-1"), "gb2312"); 
		su.setMaxFileSize(10000000);
		
		System.out.println(filename);
		try {
			
			su.downloadFile("/upload/"+filename);
			
		} 
		catch(java.io.FileNotFoundException e){ 
            //			msg="��ʾ����������δ�ҵ�Ҫ���ص��ļ���";  
		} catch (SmartUploadException e) {

			e.printStackTrace();
		}

	}


}
