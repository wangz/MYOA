<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>设置权限</title>
    <link href="../css/work.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function setlimit(){
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

	return true;
}
</script>	
  
  </head>
  
  <body bgcolor="#ECF1FF">
  <form name="form1" id="form1" method="post" action="setlimit" onsubmit="return setlimit()">
<table width="49%" height="370" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
<tr>
    <td width="778" height="22" align="center" background="../KCM/zs.gif" bgcolor="#FFFFFF" class="title style1" >员工权限设定</td>
  </tr>
  <tr>
    <td height="50" align="center"  >请输入要设定的员工id序号</td>
  </tr>
  <tr>
    <td height="50" align="center"  ><input type="text" name="id" />
      </td>
    </tr>
	<tr>
    <td height="50" align="center"  >请选择此员工的权限</td>
  </tr> 
	<tr>
	<td height="50" align="center"><select name="limit">
	<option value=0>普通用户</option>
	<option value=1>公告发布者</option>
	</select>
	</td>
	<tr>
	<td height="50" align="center"  ><input type="submit" value="设定" ></td>
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
    <td height="40" bgcolor="#ECF1FF"><span class="return" onClick="javascript:history.back(-1);"><img src="../image/more.gif" width="30" height="9" />返回</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
	
</table>
</form>
  </body>
</html>
