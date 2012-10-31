<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>职位修改</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function job(){
	if(document.form1.name.value==""){
		alert("请输入职位名称");
		document.form1.name.focus();
		return false;
	}
	if(document.form1.explain.value==""){
		alert("请输入职位描述");
		document.form1.explain.focus();
		return false;
	}
	return true;
}
</script>
<style type="text/css">
<!--
.style1 {
	color: #000000;
	font-family: "宋体";
	font-weight: bold;
	font-size: 16px;
}
.style2 {
	color: #0F2771;
	font-weight: bold;
}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="550" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
<form name="form" id="form" method="post" action="select">
  <tr>
    <td height="24" colspan="5" align="center" class=" style1" background="../KCM/zs.gif">职位修改</td>
  </tr>
<%
	Collection coll=(Collection)session.getAttribute("msg");
	if(coll==null){
%>
  <tr>
    <td height="26" colspan="5" align="center" class="advise style2" >没有职位信息</td>
  </tr>
  <tr align="right">
	<td height="35" colspan="5"><span class="return" onclick="javascript:document.location='job.htm';">返回</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
<%
	}else{
%>
  <tr>
   
    <td height="74" align="center">请选择要修改的职位名称:</td>
    <td width="173" align="center"><select name="id" onchange="">
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
    <td width="102" align="center"><input type="submit" name="Submit" value="GO!" /></td>
  
  </tr>
<% 
		String selmsg=(String)request.getAttribute("selmsg");
		if(selmsg!=null){
%>	
  <tr>
    <td height="18" colspan="5" align="center" class="advise">&nbsp;<%= selmsg %>	</td>
	</tr>
<%
			session.removeAttribute("selmsg");
		}
%>
 </form>
<% 
	}
	Collection coll2=(Collection)request.getAttribute("msg2");
	if(coll2!=null){
		Iterator it2=coll2.iterator();
		while(it2.hasNext()){
			Job job2=(Job)it2.next();
%>
<form name="form1" id="form1" method="post" action="change" onsubmit="return job()">
 <tr>

    <td width="205" height="34" align="center">职位名称:</td>
    <td height="34" colspan="2" align="center"><input name="name" type="text" size="22" maxlength="40"  value="<%= job2.getName() %>"/></td>

 </tr>
  <tr>
    <td height="80" align="center">职位描述:</td>
    <td height="80" colspan="2" align="center"><textarea name="explain" rows="5"><%= job2.getExplain() %></textarea></td>
    </tr>
  <tr>
    <td height="55" colspan="3" align="center">
	<input type="hidden" name="id" value="<%= job2.getId() %>">
    <input type="submit" name="Submit2" value="修改" />
	  &nbsp;&nbsp;&nbsp;
      <input type="button" name="Submit2" value="返回" onclick="javascript:history.back(-1);"/></td>
	   </td>
    </tr>
<% 
			}
		}
		request.removeAttribute("msg2");
%>

 </form>
</table>
</body>
</html>
