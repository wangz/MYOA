<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<%	Db db=new Db(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>短信息</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />

<style type="text/css">
<!--
.style1 {
	color: #000000;
	font-size: 16px;
	font-family: "宋体";
	font-weight: bold;
}
.style8 {font-family: "宋体"; color: #000000; font-size: 14px; font-weight: bold; }
.style9 {
	color: #003366;
	font-weight: bold;
}
-->
</style>
<script language="javascript">
function del(){
	if(confirm("确认要删除此公告么？")==1)
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
<table width="668" height="152" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr >
    <td height="20" colspan="5" align="center" class="sytle1 " background="../KCM/zs.gif">站内信息</td>
  </tr>
  <tr align="center" class="column">
    <td width="145" height="21"><span class="style8">发送人</span></td>
    <td width="194" height="21"><span class="style8">站内信标题</span></td>
    <td width="194" height="21"><span class="style8">发送时间</span></td>
    <td width="127"><span class="style8">接收人</span></td>
    <td width="118"><span class="style8">删除</span></td>
  </tr>
<%
	Collection coll=(Collection)request.getAttribute("msg");
	Str str=new Str();
	if(coll==null){	
%>
  <tr align="center">
    <td height="21" colspan="5" class="advise"><span class="style9">没有短消息</span></td>
  </tr>
<%
	}else{
		Iterator it=coll.iterator();
		while(it.hasNext()){
			Message dep=(Message)it.next();
%>
  <tr align="center">
    <td><%=db.IdtoName(dep.getSender())%></td>
    <td><%= dep.getTitle()%></td>
    <td><%= dep.getTime().substring(0,19)%>&nbsp;</td>
    <td><%=db.IdtoName(dep.getAccepter())%></td>
    <td><a href="del?messageid=<%=dep.getId()%>" onclick="return del()"><img src="../image/empty.gif" width="20" height="20" border="0" /></a>
</td>
  </tr>
<%
		}
	}
	request.removeAttribute("msg");
%>
  <tr align="right" bgcolor="#ECF1FF">
    <td height="27" colspan="5"><span class="return" onclick="javascript:history.go(-1);"><img src="../image/more.gif" width="30" height="9" />返回</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
</body>
</html>
