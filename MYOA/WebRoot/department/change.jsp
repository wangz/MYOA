<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>部门修改</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function dep(){
	if(document.form1.name.value==""){
		alert("请输入部门名称");
		document.form1.name.focus();
		return false;
	}
	if(document.form1.explain.value==""){
		alert("请输入部门描述");
		document.form1.explain.focus();
		return false;
	}
	return true;
}
</script>
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-weight: bold;
}
.style2 {
	color: #006CD9;
	font-weight: bold;
}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="49%" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="49%" height="23" colspan="6" align="center" background="../KCM/zs.gif" class="style1 advise"><strong>修改<strong>部门</strong></strong></td>
  </tr>
</table>
<table width="49%" height="241" align="center" cellpadding="0" cellspacing="0">
<form name="form" id="form" method="post" action="select">
<%
	Collection coll=(Collection)session.getAttribute("msg");
	if(coll==null){
%>
  <tr>
    <td height="37" colspan="4" align="center" bgcolor="#FFFFFF" class="advise style2" >没有部门信息</td>
  </tr>
<%
	}else{
%>
  <tr>
    <td align="center" bgcolor="#FFFFFF"><div align="center">选择修改:</div></td>
    <td width="143" height="43" align="center" bgcolor="#FFFFFF">
      <select name="id" onchange="">
    <%
	Iterator it=coll.iterator();
	while(it.hasNext()){
		Department dep=(Department)it.next();
%>
          <option value="<%= dep.getId() %>"><%= dep.getName() %></option>
          <%
		}
%>
      </select>
  </td>
    <td width="140" align="center" bgcolor="#FFFFFF">
      <input type="submit" name="Submit" value="GO!" />
  </td>
    </tr>
</form>
<% 
	}
	Collection coll2=(Collection)request.getAttribute("msg2");
	if(coll2!=null){
		Iterator it2=coll2.iterator();
		while(it2.hasNext()){
			Department dep2=(Department)it2.next();
%>
<form name="form1" id="form1" method="post" action="change" onsubmit="return dep()">
 <tr>
    <td width="209" align="center" bgcolor="#FFFFFF"><div align="center">部门名称:</div></td>
    <td colspan="2" align="center" bgcolor="#FFFFFF"><div align="left">
      <input name="name" type="text" size="22" maxlength="40"  value="<%= dep2.getName() %>"/>
    </div></td>
    </tr>
  <tr>
    <td align="center" bgcolor="#FFFFFF"><div align="center">部门描述:</div></td>
    <td height="80" colspan="2" align="center" bgcolor="#FFFFFF"><div align="left">
      <textarea name="explain" cols="40" rows="5"><%= dep2.getExplain() %></textarea>
</div></td>
    </tr>
  <tr>
    <td colspan="3" align="center" bgcolor="#FFFFFF">
	  <input type="hidden" name="id" value="<%= dep2.getId() %>">
    <input type="submit" name="Submit2" value="修改" />
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" name="myreset" value="取消"></td>
    </tr>
<% 
			}
		}
		request.removeAttribute("msg2");
%>

 </form>
</table>
<% 
String selmsg=(String)request.getAttribute("selmsg");
		if(selmsg!=null){
		%>
		<table align="center">
		<tr>
    <td colspan="4" align="center" bgcolor="#FFFFFF" class="advise">&nbsp;<%= selmsg %>	</td>

	</tr>
	</table>
		<% session.removeAttribute("selmsg");
		} %>
 
</body>
</html>
