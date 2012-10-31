<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<%  Db db=new Db();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>部门查看</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	color: #010000;
	font-weight: bold;
}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="80%" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="94%" height="24" colspan="6" align="center" background="../KCM/zs.gif" class="advise style1">公告信息</td>
  </tr>
</table>
<table width="80%" height="48%" align="center" cellpadding="0" cellspacing="0">
  <tr align="center" class="column">

    <td width="20%" height="37" bgcolor="#FFFFFF"><strong>发布人</strong></td>
    <td width="40%" height="37" bgcolor="#FFFFFF"><strong>公告标题</strong></td>
    <td width="25%" height="37" bgcolor="#FFFFFF"><strong>发布时间</strong></td>
    <td width="15%" height="37" bgcolor="#FFFFFF"><strong>附件</strong></td>
   <%-- <td width="231" bgcolor="#FFFFFF"><strong>具体公告</strong></td>--%> 
  </tr>
  <%
	Collection coll=(Collection)request.getAttribute("msg");
	if(coll==null){	
%>
  <tr align="center" bgcolor="#ECF1FF">
    <td height="45" colspan="6" class="advise"><strong>没有添加公告</strong></td>
  </tr>
  <%
	}else{
		Iterator it=coll.iterator();//用Collection对象的iterator()方法获得
		while(it.hasNext()){
			Affice dep=(Affice)it.next();
%>
  <tr align="center"  >

    <td height="33" bgcolor="#FFFFFF"><div align="center"><%=db.IdtoName(dep.getEmid())%></div></td>
    <td height="33" bgcolor="#FFFFFF"><div align="center"><a href="read?afficeid=<%=dep.getId()%>"><%= dep.getTitle()%></a></div></td>
    <td height="33" bgcolor="#FFFFFF"><div align="center"><%= dep.getTime().substring(0,10)%>&nbsp;</div></td>
     <td height="33" bgcolor="#FFFFFF"><div align="center"><%= dep.getAffix() %></div></td>  
    
  </tr>
  <%
		}
	}
	request.removeAttribute("msg");//移除request对象中所带的属性
%>
</table>
</body>
</html>
