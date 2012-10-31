<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="java.sql.*"%>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<% Db db=new Db();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>查看站内信件</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
 
<style type="text/css">
<!--
.style3 {
	color: #0000EA;
	font-weight: bold;
}
.style4 {
	font-size: 16px;
	font-weight: bold;
}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="668" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="69%" height="23" colspan="6" align="center" background="../KCM/zs.gif" class="style1 advise"><strong>站内信内容</strong></td>
  </tr>
</table>
<table width="668" height="214" align="center" cellpadding="0" cellspacing="0">
<%
	Collection coll=(Collection)request.getAttribute("msg");
	Str str=new Str();
	if(coll!=null){	
		Iterator it=coll.iterator();
		if(it.hasNext()){
			Message dep=(Message)it.next();
%>
  <tr>

    <td width="221" height="25" align="center" bgcolor="#FFFFFF" class="column" ><div align="center">发 信 人：</div></td>
    <td width="557" bgcolor="#FFFFFF" >
<%
	Connection con=Db.getCon();
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	ResultSet rs=stmt.executeQuery("SELECT name FROM eminfo WHERE employeeid="+dep.getSender());
		if(rs.next()){
			out.print(str.outStr(rs.getString(1)));
		}else{
			out.print(dep.getSender());
		}
	db.close();
%>
</td>

  </tr>
  <tr >
    <td height="23" align="center" bgcolor="#FFFFFF" class="column" >发送时间：</td>
    <td bgcolor="#FFFFFF" ><%= dep.getTime().substring(0,19)%></td>
  </tr>
  <tr >
    <td height="18" align="center" bgcolor="#FFFFFF" class="column" >标&nbsp;&nbsp;&nbsp;&nbsp;题：</td>
    <td bgcolor="#FFFFFF" ><%= dep.getTitle() %></td>
  </tr>
  <tr >
    <td height="61" align="center" bgcolor="#FFFFFF" ><p class="column">内&nbsp;&nbsp;&nbsp;&nbsp;容：</p>    </td>
    <td valign="middle" bgcolor="#FFFFFF" ><%= dep.getContent() %></td>
  </tr>
  <tr >
    <td height="19" colspan="2" align="center" bgcolor="#FFFFFF" ><div align="center"><a href="del?messageid=<%= dep.getId() %>">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="send.jsp?acceptid=<%= dep.getSender() %>">回复</a></div></td>
  </tr>
<%
		}
	}
	request.removeAttribute("msg");
%>
  <tr align="right">
    <td height="13" colspan="4"><span class="return" onclick="javascript:history.go(-1);"><img src="../image/more.gif" width="30" height="9" /><span class="style3">返回</span></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
</body>
</html>
