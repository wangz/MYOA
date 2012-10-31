<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<%  Db db=new Db();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>站内信</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--
.style1 {font-size: 16px}
.style2 {
	color: #0060BF;
	font-weight: bold;
}
.style3 {color: #CA0000}
.style4 {color: #000000}
-->
</style>
<script language="JavaScript">
function del(){
	if(confirm("确认要删除此信件么？")==1)
	{
	return true;
	}
    else
    {
    return false;
    }
}
</script>
</head>
<body bgcolor="#ECF1FF">
<table width="668" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="83%" height="23" colspan="6" align="center" background="../KCM/zs.gif" class="style1 advise"><strong>查看站内信</strong></td>
  </tr>
</table>
<table width="668" height="75" align="center" cellpadding="0" cellspacing="0">
  <tr align="center" class="column">

    <td width="105" height="25" bgcolor="#FFFFFF"><span class="style4">发送人</span></td>
    <td width="144" height="25" bgcolor="#FFFFFF"><span class="style4">消息标题</span></td>
    <td width="143" height="25" bgcolor="#FFFFFF"><span class="style4">发送时间</span></td>
    <td width="96" bgcolor="#FFFFFF"><span class="style4">删除</span></td>
    <td width="54" bgcolor="#FFFFFF"><span class="style4">新消息</span></td>
  </tr>
<%
	Collection coll=(Collection)request.getAttribute("msg");
	Str str=new Str();
	if(coll==null){	
%>
  <tr align="center">

    <td height="27" colspan="6" bgcolor="#FFFFFF" class="advise style2">没有短消息</td>
  </tr>
<%
	}else{
		Iterator it=coll.iterator();
		while(it.hasNext()){
			Message dep=(Message)it.next();
%>
  <tr align="center">

    <td height="20" bgcolor="#FFFFFF"><%=db.IdtoName(dep.getSender())%></td>
    <td height="20" bgcolor="#FFFFFF"><a href="read?messageid=<%=dep.getId()%>"><%= dep.getTitle()%></a></td>
    <td height="20" bgcolor="#FFFFFF"><%= dep.getTime().substring(0,19)%>&nbsp;</td>
    <td height="20" bgcolor="#FFFFFF"><a href="del?messageid=<%=dep.getId()%>" OnClick="return del()"><img src="../image/empty.gif" width="20" height="20" border="0" /></a></td>
    <td height="20" bgcolor="#FFFFFF">
<%
	if(dep.getNews()!=0){
		out.print("已读");
	}else{
		out.print("未读");
	}
%>	</td>
  </tr>
<%
		}
	}
	request.removeAttribute("msg");
%>
</table>
</body>
</html>
