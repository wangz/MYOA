<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>��ǰ���淢����</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-family: "����";
	font-weight: bold;
}
.style8 {color: #000000; font-family: "����"; font-size: 14px; font-weight: bold; }
.style9 {
	color: #0F2771;
	font-weight: bold;
}
-->
</style>
	

  </head>
 <body bgcolor="#ECF1FF">
 <table width="50%" height="157" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
 <tr>
    <td height="22" colspan="11" align="center"  background="../KCM/zs.gif"><span class="style1">����������</span></td>
  </tr>
  <tr align="center" class="column">
    <td height="26"><span class="style8">���</span></td>
    <td><span class="style8">����</span></td>            
    <td><span class="style8">����</span></td>    
    <td><span class="style8">�绰</span></td>
    <td><span class="style8">״̬</span></td>
  </tr>
  <%
Collection coll=(Collection)request.getAttribute("msg");
if(coll==null){
%><tr align="center">
    <td colspan="11" class="advise style9">��ǰû�й��淢����</td>
  </tr>
  <%
  }else{
Iterator it=coll.iterator();
while(it.hasNext()){
	Eminfo dep=(Eminfo)it.next();
%>
<tr align="center">
    <td><%= dep.getId() %></td>
    <td><%= dep.getName() %></td>
    <td><%= dep.getDepartment()%></td>
    <td><%= dep.getTel() %></td>
    <td><%= dep.getState() %></td>
 </tr>
   <%
	}
}
request.removeAttribute("msg");
%>
  <tr align="right" bgcolor="#ECF1FF">
    <td height="27" colspan="11"><span class="return" onclick="javascript:history.go(-1);">����</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
 
 </table>
  </body>
</html>
