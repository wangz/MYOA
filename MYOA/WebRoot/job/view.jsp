<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>职位查看</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-weight: bold;
	color: #000000;
	font-family: "宋体";
}
.style8 {color: #000000; font-size: 14px; font-family: "宋体"; font-weight: bold; }
.style9 {color: #000000}
.style11 {color: #0000FF}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="49%" height="127" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr >
    <td height="23" colspan="3" align="center" class="title style1" background="../KCM/zs.gif">职位信息一览表</td>
  </tr>
  <tr align="center" class="column">
    <td width="98" height="32"><span class="style8">职位序号</span></td>
    <td width="207" height="32"><span class="style8">职位名称</span></td>
    <td width="175" height="32"><span class="style8">大概工作描述</span></td>
  </tr>
  <%
Collection coll=(Collection)request.getAttribute("msg");
if(coll==null){
%>
  <tr align="center">
    <td height="30" colspan="3" class="advise style9">没有添加职位</td>
  </tr>
  <%
}else{
Iterator it=coll.iterator();
while(it.hasNext()){
	Job job=(Job)it.next();
%>
  <tr align="center">
    <td height="36"><%= job.getId() %></td>
    <td height="36"><%= job.getName() %></td>
    <td height="36"  align="center"><%= job.getExplain() %></td>
  </tr>
  <%
	}
}
request.removeAttribute("msg");
%>
</table>
<div align="center">
  <table width="49%"  border="0" cellspacing="0" cellpadding="0">
    <tr>
      <th scope="col"><div align="right"><span class="return" onclick="javascript:history.go(-1);"><img src="../image/more.gif" width="30" height="9" /><span class="style11">返回</span></span> </div></th>
    </tr>
  </table>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</div>
</body>
</html>
