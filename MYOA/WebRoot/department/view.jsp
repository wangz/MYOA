<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>部门查看</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script src="../js/oa.js"></script>
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-weight: bold;
}
.style3 {
	color: #005AB5;
	font-weight: bold;
}
.style4 {color: #000000}
.style6 {color: #000000; font-weight: bold; }
.style7 {font-weight: bold}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="59%" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>
 
    <td width="74%" height="23" colspan="6" align="center" background="../KCM/zs.gif" class="style1 advise"><strong>查看部门</strong></td>
  </tr>
</table>
<table width="59%" height="103" align="center" cellpadding="0" cellspacing="0">
  <tr align="center" class="column">
    <td width="112" height="17" bgcolor="#FFFFFF"><div align="center" class="style4"><strong>部门序号</strong></div></td>
    <td width="196" height="17" bgcolor="#FFFFFF"><span class="style6">部门名称</span></td>
    <td width="184" height="17" bgcolor="#FFFFFF"><div align="left" class="style4 style7">
      <div align="center">大概工作描述</div>
    </div></td>
  </tr>
  <%
Collection coll=(Collection)request.getAttribute("msg");
if(coll==null){
%>
  <tr align="center">
    <td height="17" colspan="4" bgcolor="#FFFFFF" class="advise style3">没有添加部门</td>
  </tr>
  <%
}else{
Iterator it=coll.iterator();
while(it.hasNext()){
	Department dep=(Department)it.next();
%>
  <tr align="center">
    <td height="22" bgcolor="#FFFFFF"><div align="right"><%= dep.getId() %></div></td>
    <td height="22" bgcolor="#FFFFFF"><%= dep.getName() %></td>
    <td height="22"  bgcolor="#FFFFFF"><%= dep.getExplain() %></td>
  </tr>
  <%
	}
}
request.removeAttribute("msg");
%>
</table>
</body>
</html>
