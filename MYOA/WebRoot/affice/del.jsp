<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<%  Db db=new Db();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>����ɾ��</title>
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
<script language="JavaScript">
function del(){
	if(confirm("ȷ��Ҫɾ���˹���ô��")==1)
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
<table width="56%" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="94%" height="24" colspan="6" align="center" background="../KCM/zs.gif" class="advise style1">������Ϣ</td>
  </tr>
</table>
<table width="56%" height="48%" align="center" cellpadding="0" cellspacing="0">
  <tr align="center" class="column">

    <td width="77" height="37" bgcolor="#FFFFFF"><strong>������</strong></td>
    <td width="98" height="37" bgcolor="#FFFFFF"><strong>�������</strong></td>
    <td width="95" height="37" bgcolor="#FFFFFF"><strong>����ʱ��</strong></td>
    <td width="74" bgcolor="#FFFFFF"><strong>ɾ��</strong></td>
  </tr>
  <%
	Collection coll=(Collection)request.getAttribute("msg");
	if(coll==null){	
%>
  <tr align="center" bgcolor="#ECF1FF">
    <td height="45" colspan="6" class="advise"><strong>û����ӹ���</strong></td>
  </tr>
  <%
	}else{
		Iterator it=coll.iterator();//��Collection�����iterator()�������
		while(it.hasNext()){
			Affice dep=(Affice)it.next();
%>
  <tr align="center"  >

    <td height="33" bgcolor="#FFFFFF"><div align="center"><%=db.IdtoName(dep.getEmid())%></div></td>
    <td height="33" bgcolor="#FFFFFF"><div align="center"><%= dep.getTitle()%></div></td>
    <td height="33" bgcolor="#FFFFFF"><div align="center"><%= dep.getTime().substring(0,10)%>&nbsp;</div></td>
    <td height="33" bgcolor="#FFFFFF"><a href="del?afficeid=<%=dep.getId()%>" OnClick="return del()"><img src="../image/empty.gif" width="20" height="20" border="0" /></a></td>
  </tr>
  <%
		}
	}
	request.removeAttribute("msg");//�Ƴ�request����������������
%>
</table>
</body>
</html>
