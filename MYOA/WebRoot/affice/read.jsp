<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="java.sql.*"%>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>短信息</title>
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
<table width="668" height="25" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="90%" height="23" colspan="6" align="center" background="../KCM/zs.gif" class="style1 advise"><strong>公告内容</strong></td>
  </tr>
</table>
<table width="668" height="" border="0" align="center" cellpadding="0" cellspacing="0">
<%
	Collection coll=(Collection)request.getAttribute("msg");
	Str str=new Str();
	if(coll!=null){	
		Iterator it=coll.iterator();
		if(it.hasNext()){
			Affice dep=(Affice)it.next();
%>
  <tr >

    <td width="93" height="20" align="center" bgcolor="#FFFFFF" class="column" ><div align="center">发 布 者：</div></td>
    <td width="140" bgcolor="#FFFFFF"  >
<%
	Connection con=Db.getCon();
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	ResultSet rs=stmt.executeQuery("SELECT name FROM eminfo WHERE employeeid="+dep.getEmid());
		if(rs.next()){
			out.print(str.outStr(rs.getString(1)));
		}else{
			out.print(dep.getEmid());
		}
	con.close();
%></td>

    <td width="109" height="20" align="center" bgcolor="#FFFFFF" ><span class="column">发布时间：</span></td>
    <td width="324"   bgcolor="#FFFFFF" ><%= dep.getTime().substring(0,19)%></td>
  </tr>

  <tr >
    <td height="18" align="center" bgcolor="#FFFFFF" class="column" >标&nbsp;&nbsp;题：</td>
    <td height="18" bgcolor="#FFFFFF" ><%= dep.getTitle() %></td>
    <td height="18" bgcolor="#FFFFFF" align="center" >附件：</td>
    <td height="18" bgcolor="#FFFFFF"  >
	<form  action="download" method="post" name="form1">
	<% if(dep.getAffix()!=null){ %>
	<!-- <a href="download?affix=<%= dep.getAffix()%>"><%= dep.getAffix()%></a>  -->
	<%= dep.getAffix()%> 
	<input name="button1"  type="submit" id="button1" value="下载" />
	<input name="affix" type="hidden" value="<%= dep.getAffix()%>"  />
	<% }
	else{
		out.print("无附件");
		}%>
	  </form></td>
  </tr>
  <tr  bgcolor="#FFFFFF">
  <td  align="center" colspan="4" height="5">具体内容:</td>
  </tr>
  <tr >

    <td colspan="4" valign="middle" bgcolor="#FFFFFF" ><%= dep.getContent() %></td>
  </tr>

<%
		}
	}
	request.removeAttribute("msg");
%>
</table>
<table width="668" align="center">
  <tr align="right">
    <td height="13" colspan="6"><span class="return" onclick="javascript:history.go(-1);"><img src="../image/undo16.bmp" width="30" height="18"/><span class="style3">返回</span></span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
</body>
</html>
