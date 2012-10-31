<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>站内信发送</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function sendmessage(){
	if(document.form1.acceptid.value==""){
		alert("收信人不能为空");
		document.form1.title.focus();
		return false;
	}
	if(document.form1.title.value==""){
		alert("标题不能为空");
		document.form1.title.focus();
		return false;
	}
	if(document.form1.content.value==""){
		alert("请输入具体公告");		
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
<script src="../fckeditor/fckeditor.js"></script>
<table width="668" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="72%" height="23" colspan="6" align="center" background="../KCM/zs.gif" class="style1 advise"><strong>发送站内信</strong></td>
  </tr>
</table>
<table width="668" height="" align="center" cellpadding="0" cellspacing="0">
<form name="form1" id="form1" method="post" action="send" onsubmit="return sendmessage()">
  <tr>

    <td width="283" height="32" align="center" bgcolor="#FFFFFF"><span class="column">收信人序号:
      <input name="acceptid" type="text"  size="10" <% if(request.getParameter("acceptid")!=null) out.print("value="+request.getParameter("acceptid").toString());%> />
    </span></td>
    <!--单击回复后，自动将发信人的id号生成出来-->
	<td width="495" align="left" bgcolor="#FFFFFF"><span class="column">信件标题:
	  <input name="title" type="text" size="36" maxlength="40" />
	</span></td>
  </tr>
  <tr>

    <td height="145" colspan="2" align="center" bgcolor="#FFFFFF">    
     <script>
	var editor =new FCKeditor('content');
	editor.BasePath='../fckeditor/';
	editor.Height=365;
	editor.ToolbarSet='Basic';
	editor.Create();
	 </script>    </td>
    </tr>
  <tr>
   <td height="20" colspan="4" bgcolor="#FFFFFF">
      <div align="center">
        <input type="submit" name="Submit" value="发送" />
  &nbsp;&nbsp;&nbsp;
        <input type="reset" name="myreset" value="取消"/>
      </div></td>
    </tr>
  <tr>
    <td colspan="3" align="center" valign="top">
    <span class="advise">
    <% 
		String daymsg=(String)request.getAttribute("msg");
		if(daymsg!=null){
			out.print(daymsg);
			request.removeAttribute("msg");
		}
%>
    </span>	&nbsp;</td>
  </tr>
</form>
</table>
</body>
</html>
