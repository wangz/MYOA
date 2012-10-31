<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>部门增加</title>
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
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="49%" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="49%" height="23" colspan="6" align="center" background="../KCM/zs.gif" class="style1 advise"><strong>添加<strong>部门</strong></strong></td>
  </tr>
</table>
<table width="49%" height="211" align="center" cellpadding="0" cellspacing="0">
<form name="form1" id="form1" method="post" action="add" onsubmit="return dep()">
  <tr>

    <td width="177" height="48" align="center" bgcolor="#FFFFFF">部门名称:</td>
    <td width="308" align="center" bgcolor="#FFFFFF">
      <input name="name" type="text" size="22" maxlength="40" />
    </td>

  </tr>
  <tr>
    <td height="95" align="center" bgcolor="#FFFFFF">部门描述:</td>
    <td align="center" bgcolor="#FFFFFF"><div align="left">
      <textarea name="explain" cols="40" rows="5"></textarea>
    </div></td>
  </tr>
  <tr>
    <td height="30" colspan="2" align="center" bgcolor="#FFFFFF">
      <div align="center">
  <input type="submit" name="Submit" value="添加" />
&nbsp;&nbsp;&nbsp;
  <input type="reset" name="myreset" value="取消" />
      </div></td>
  </tr>
  <tr>
    <td colspan="2" align="center" valign="top">
    <span class="advise">
    <% 
		String daymsg=(String)session.getAttribute("depmsg");
		if(daymsg!=null){
			out.print(daymsg);
			session.removeAttribute("depmsg");
		}
%>

    </span>	&nbsp;</td>
  </tr>
</form>
</table>
</body>
</html>
