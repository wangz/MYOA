package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test extends HttpServlet {


	public test() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException
    {
       res.setContentType("text/html");
       PrintWriter out=res.getWriter();
       out.println("<html><head><title>hello world!</title></head>");
       out.println("<body>");
       out.println("<h2><center>Hello world!</center></h2></body></html>"); 
    }


	public void init() throws ServletException {
		// Put your code here
	}

}
