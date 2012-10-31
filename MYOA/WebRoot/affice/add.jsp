<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>公告增加</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function affice(){
	if(document.form1.title.value==""){
		alert("标题不能为空");
		document.form1.title.focus();
		return false;
	}
	if(document.form1.content.value==null){
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
<table width="90%" height="25" align="center" cellpadding="0" cellspacing="0">
  <tr>

    <td width="100%" height="24" colspan="6" align="center" background="../KCM/zs.gif" class="advise style1">发布公告</td>
  </tr>
</table>
<table width="90%" height="95%" align="center" cellpadding="0" cellspacing="0">
<form name="form1" id="form1" method="post" action="add" ENCTYPE="multipart/form-data"  onsubmit="return affice()">
  <tr>

    <td width="124" height="35" align="center" bgcolor="#FFFFFF">公告标题:</td>
    <td width="437" align="center" bgcolor="#FFFFFF"><div align="left">
      <input name="title" type="text" size="40" maxlength="40" />
    </div></td>
    </tr>
  <tr>
    <td height="145" colspan="2" align="center" bgcolor="#FFFFFF">sha <%-- <td align="center" bgcolor="#FFFFFF"><div align="left">
     <textarea name="content" cols="60" rows="10"></textarea>--%>
     <script>
	var editor =new FCKeditor('content');
	editor.BasePath='../fckeditor/';
	editor.Height=365;
	editor.ToolbarSet='Default';
	editor.Create();
	 </script>    </td>
    </tr>
    
    <tr>
      <td height="21" align="center">附件：<input type="file" name="FILE1" /></td>
    
    
      <td height="21" colspan="3" align="center"><input type="submit" name="Submit" value="发布" />
&nbsp;&nbsp;&nbsp;
      <input type="reset" name="myreset" value="取消"/></td>
    </tr>
 
  <tr>
    <td colspan="2" align="center" valign="top">
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
