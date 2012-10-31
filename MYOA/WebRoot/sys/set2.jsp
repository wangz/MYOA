<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>员工修改密码</title>
<script language="JavaScript">
function set2(){
	if(document.form1.password.value==""){
		alert("原密码不能为空");
		document.form1.password.focus();
		return false;
	}
	if(document.form1.passwordnew1.value==""){
		alert("新密码不能为空");
		document.form1.passwordnew1.focus();
		return false;
	}

	if(document.form1.passwordnew1.value!=document.form1.passwordnew2.value){
		alert("两次密码输入不一致");
		document.form1.passwordnew1.focus();
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
<form name="form1" id="form1" method="post" action="set2" onsubmit="return set2()">
<table width="49%" height="365" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
<tr>
    <td width="778" height="22" align="center" background="../KCM/zs.gif" bgcolor="#FFFFFF" class="title style1" >员工密码修改</td>
  </tr>
  <tr>
    <td height="50" align="center"  >请输入您的原密码:</td>
  </tr>
  <tr>
    <td height="50" align="center"  ><input type="password" name="password" />
      </td>
    </tr>
  <tr>
    <td height="50" align="center" >请输入您的新密码</td>
  </tr>
  <tr>
    <td height="50" align="center"  ><input type="password" name="passwordnew1" />
      </td>
    </tr>
	 <tr>
    <td height="50" align="center" >请再次输入您的新密码：</td>
  </tr>
  <tr>
    <td height="50" align="center"  ><input type="password" name="passwordnew2" />
      </td>
    </tr>
	<tr align="right">
    <td height="40" align="center"><input type="submit" name="Submit2" value="提交" />
      <label>
      <input type="reset" name="Submit" value="重置">
      </label></td>
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
    <td height="30" bgcolor="#ECF1FF"><span class="return" onclick="javascript:history.back(-1);"><img src="../image/more.gif" width="30" height="9" />返回</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>

</table>
</form>
  </body>
</html>
