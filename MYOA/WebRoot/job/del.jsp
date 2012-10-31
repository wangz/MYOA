<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>职位删除</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />
<script src="../js/oa.js"></script>
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-weight: bold;
	font-family: "宋体";
	color: #000000;
}
.style2 {
	color: #0F2771;
	font-weight: bold;
}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="49%" height="316" align="center" cellpadding="0" cellspacing="0">
<form name="form" id="form" method="post" action="del">
  <tr>
    <td height="16" colspan="5" align="center" class="title style1" background="../KCM/zs.gif">职位删除</td>
  </tr>
<%
	Collection coll=(Collection)session.getAttribute("msg");
	if(coll==null){
%>
  <tr bgcolor="#FFFFFF">
    <td height="30" colspan="4" align="center" class="advise" ><span class="style2">没有职位信息</span></td>
  </tr>
  <tr align="right" bgcolor="#FFFFFF">
	<td height="50" colspan="5"><span class="return" onclick="javascript:history.go(-1);"><img src="../image/more.gif" width="30" height="9" />返回</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
<%
	}else{
%>
  <tr bgcolor="#FFFFFF">
    <td height="50" align="center" class="advise" >&nbsp;</td>
    <td height="50" colspan="2" class="advise" ><div align="center" class="style2">注意：请首先删除属于此职位下的所有员工信息</div></td>
    <td height="50" align="center" class="advise" >&nbsp;</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="48" align="center">&nbsp;</td>
    <td width="173" height="80" align="center">请选择要删除的职位名称:</td>
    <td width="206" height="80" align="center"><select name="id" >
<%
	Iterator it=coll.iterator();
	while(it.hasNext()){
		Job job=(Job)it.next();
%>
      <option value="<%= job.getId() %>"><%= job.getName() %></option>
      <%
		}
%>
    </select></td>
    <td width="61" align="center">&nbsp;</td>
  <tr bgcolor="#FFFFFF">
    <td height="50" colspan="4" align="center" class="advise"><input type="submit" name="Submit" value="删除" />
      &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" name="Submit2" value="返回" onclick="javascript:history.go(-1);"/></td>
  </tr>

<% 
		String delmsg=(String)request.getAttribute("delmsg");
		if(delmsg!=null){
%>	
    <td height="50" colspan="4" align="center" class="advise">&nbsp;<%= delmsg %></td>
<%
			session.removeAttribute("msg");
		}
	}
%>
	<td height="52"></tr>
 </form>
</table>
</body>
</html>
