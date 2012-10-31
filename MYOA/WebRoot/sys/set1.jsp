<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>员工密码设定</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function set1(){
	if(document.form1.id.value==""){
		alert("序号不能为空");
		document.form1.id.focus();
		return false;
	}
	if(isNaN(document.form1.id.value)){
		alert("请输入正确序号");
		document.form1.id.focus();
		return false;
	}
	if(document.form1.id.value.indexOf(".")!=-1){
		alert("请输入正确序号");
		document.form1.id.focus();
		return false;
	}
	if(document.form1.password.value==""){
		alert("请输入员工密码");
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
	font-family: "宋体";
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
    <td width="778" height="22" align="center" background="../KCM/zs.gif" bgcolor="#FFFFFF" class="title style1" >员工密码设定</td>
  </tr>
  <tr>
    <td height="50" align="center"  >请输入要设定的员工id序号</td>
  </tr>
  <tr>
    <td height="50" align="center"  ><input type="text" name="id" />
      </td>
    </tr>
  <tr>
    <td height="50" align="center" >请输入要设定的员工密码</td>
  </tr>
  <tr>
    <td height="50" align="center" ><input type="text" name="password" />
      </td>
  </tr>
  <tr align="right">
    <td height="40" align="center"><input type="submit" name="Submit2" value="设定" /></td>
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
    <td height="40" bgcolor="#ECF1FF"><span class="return" onclick="javascript:history.back(-1);"><img src="../image/more.gif" width="30" height="9" />返回</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
 
</form>
</table>
</body>
</html>

