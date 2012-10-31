<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>部门删除</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script src="../js/oa.js"></script>
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-weight: bold;
}
.style2 {
	color: #005EBB;
	font-weight: bold;
}
.style3 {color: #CA0000}
.style4 {
	color: #FF0000;
	font-weight: bold;
}
.style5 {color: #0F2771}
-->
</style>
</head>
<body  bgcolor="#ECF1FF">
<table width="49%" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="73%" height="23" colspan="6" align="center" background="../KCM/zs.gif" class="style1 advise"><strong>删除<strong>部门</strong></strong></td>
  </tr>
</table>
<table width="49%" height="185" align="center" cellpadding="0" cellspacing="0">
<form name="form" id="form" method="post" action="del">
<%
	Collection coll=(Collection)session.getAttribute("msg");
	if(coll==null){
%>
  <tr> 
    <td height="13" colspan="3" align="center" bgcolor="#FFFFFF" class="advise style2" >没有部门信息</td>
  </tr>
<%
	}else{
%>
  <tr>
    <td height="20" colspan="2" bgcolor="#FFFFFF" class="advise style3" ><div align="center" class="style4 style5">注意：请首先删除属于此部门的所有员工信息</div></td>
    </tr>
  <tr>
    <td width="318" height="22" align="center" bgcolor="#FFFFFF">请选择要删除的部门名称:</td>
    <td width="174" height="22" align="center" bgcolor="#FFFFFF">
        <div align="left">
            <select name="id" >
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
        </div></td>
    <tr>
    <td height="20" colspan="3" align="center" bgcolor="#FFFFFF" class="advise"><input type="submit" name="Submit" value="删除" />
      &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" name="Submit2" value="查看" onclick="javascript:document.location='../department/view?flag=view';"/></td>
  </tr>
  <tr>
<% 
		String delmsg=(String)request.getAttribute("delmsg");
		if(delmsg!=null){
%>	
    <td height="21" colspan="3" align="center" class="advise">&nbsp;<%= delmsg %></td>
<%
			session.removeAttribute("msg");
		}
	}
%>
	</tr>
 </form>

</table>
</body>
</html>
