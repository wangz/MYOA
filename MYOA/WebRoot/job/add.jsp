<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>职位增加</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function job(){
	if(document.form1.name.value==""){
		alert("请输入职位名称");
		document.form1.name.focus();
		return false;
	}
	if(document.form1.explain.value==""){
		alert("请输入职位描述");
		document.form1.explain.focus();
		return false;
	}
	return true;
}
</script>
<style type="text/css">
<!--
.style1 {
	color: #000000;
	font-size: 18px;
}
.style2 {
	font-family: "宋体";
	font-weight: bold;
}
.style3 {
	color: #0F2771;
	font-weight: bold;
}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<table width="49%" height="269" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
<form name="form1" id="form1" method="post" action="add" onsubmit="return job()">
  <tr>
    <td height="22" colspan="4" align="center" class=" style1 style2" background="../KCM/zs.gif" >职位增加</td>
  </tr>
  <tr>
    <td height="31" colspan="2" class="advise style3" ><div align="center"></div></td>
  </tr>
  <tr>
    <td width="150" height="30" align="center">职位名称:</td>
    <td width="327" align="center">
      <input name="name" type="text" size="22" maxlength="40" />
   </td>

  </tr>
  <tr>
    <td height="80" align="center">职位描述:</td>
    <td align="center">
      <textarea name="explain" rows="5"></textarea>
   </td>
  </tr>
  <tr>
    <td height="65" colspan="2" align="center"><input type="submit" name="Submit" value="添加" />
      &nbsp;&nbsp;&nbsp;
      <input type="button" name="Submit2" value="返回" onclick="javascript:history.back(-1);"/></td>
  </tr>
  <tr>
    <td height="18" colspan="2" align="center" valign="top">
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
