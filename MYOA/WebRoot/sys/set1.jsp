<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Ա�������趨</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function set1(){
	if(document.form1.id.value==""){
		alert("��Ų���Ϊ��");
		document.form1.id.focus();
		return false;
	}
	if(isNaN(document.form1.id.value)){
		alert("��������ȷ���");
		document.form1.id.focus();
		return false;
	}
	if(document.form1.id.value.indexOf(".")!=-1){
		alert("��������ȷ���");
		document.form1.id.focus();
		return false;
	}
	if(document.form1.password.value==""){
		alert("������Ա������");
		document.form1.password.focus();
		return false;
	}
	return true;
}
</script>
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-family: "����";
	font-weight: bold;
	color: #000000;
}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="49%" height="370" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
<form name="form1" id="form1" method="post" action="set1" onsubmit="return set1()">
  <tr>
    <td width="778" height="22" align="center" background="../KCM/zs.gif" bgcolor="#FFFFFF" class="title style1" >Ա�������趨</td>
  </tr>
  <tr>
    <td height="50" align="center"  >������Ҫ�趨��Ա��id���</td>
  </tr>
  <tr>
    <td height="50" align="center"  ><input type="text" name="id" />
      </td>
    </tr>
  <tr>
    <td height="50" align="center" >������Ҫ�趨��Ա������</td>
  </tr>
  <tr>
    <td height="50" align="center" ><input type="text" name="password" />
      </td>
  </tr>
  <tr align="right">
    <td height="40" align="center"><input type="submit" name="Submit2" value="�趨" /></td>
  </tr>
  <tr align="right">
    <td height="40" align="center" class="advise">
<%
	String msg=(String)request.getAttribute("msg");
		if(msg!=null){
			out.print(msg);
		}
		request.removeAttribute("msg");
%>
	&nbsp;</td>
  </tr>
  <tr>
  <tr align="right">
    <td height="40" bgcolor="#ECF1FF"><span class="return" onclick="javascript:history.back(-1);"><img src="../image/more.gif" width="30" height="9" />����</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
 
</form>
</table>
</body>
</html>

