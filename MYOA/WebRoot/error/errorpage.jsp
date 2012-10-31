<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.data.*,java.util.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>员工查看</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function re(){
	parent.location.href='../index.jsp';
}
</script>
</head>
<body background="../image/back.gif">
<table width="780" height="380"  cellpadding="0" cellspacing="0" background="../image/error.jpg">
  
    <tr>
      <td height="150" align="center" class="title">
        <% 
	String msg=(String)session.getAttribute("error");
	if(msg!=null){
	out.print(msg);
	}
	session.removeAttribute("error");
%></td>
    </tr>
    <tr>
    <td height="27" align="right" ><span class="return" OnClick="re()"><img src="../image/more.gif" width="30" height="9" />返回&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
    </tr>
</table>
</body>
</html>
