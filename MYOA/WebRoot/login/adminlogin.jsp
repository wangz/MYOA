<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>top</title>
<link href="../css/word.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-color: #ECF1FF;
	margin:0px;
}
</style>
<SCRIPT language=javascript>
function show(obj,maxg,obj2)
{
  if(obj.style.pixelWidth<maxg)
  {
    obj.style.pixelWidth+=maxg/10;
    if(obj.style.pixelWidth==maxg/10)
	  obj.style.display='block';
	myObj=obj;
	mymaxg=maxg;
	myObj2=obj2;
	setTimeout('show(myObj,mymaxg,myObj2)','5');
  }
}
function hide(obj,maxg,obj2)
{
  if(obj.style.pixelWidth>0)
  {
    if(obj.style.pixelWidth==maxg/5)
	  obj.style.display='none';
    obj.style.pixelWidth-=maxg/5;
	myObj=obj;
	mymaxg=maxg
	myObj2=obj2;
	setTimeout('hide(myObj,mymaxg,myObj2)','5');
  }
  else
    if(whichContinue)
	  whichContinue.click();
}
function chang(obj,maxg,obj2)
{
  if(obj.style.pixelWidth)
  {
    hide(obj,maxg,obj2);
	nopen='';
	whichcontinue='';
  }
  else
    if(nopen)
	{
	  whichContinue=obj2;
      nopen.click();
	}
	else
	{
	  show(obj,maxg,obj2);
	  nopen=obj2;
	  whichContinue='';
	}
}
</SCRIPT>
       <SCRIPT language=javascript>
  var nopen="";
  var whichContinue='';
      </SCRIPT>
</head>
<body>
<table width="100%" height="107"  border="0"  cellpadding="0" cellspacing="0" bordercolor="#FFFFFF">
  <tr bgcolor="#FFFFFF"> 
    <td width="778" height="107" colspan="5" background="../KCM/title.gif" bgcolor="#FFFFFF" >&nbsp;</td> 
  </tr> 
</table>
<table width="100%" height="21" align="center"  cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr valign="bottom" bgcolor="#B7CAF9" class="top2"> 
      
      <td width="101" align="center" valign="middle" id="menu_affice1" onClick="chang(menu_affice,300,menu_affice1)"><a href="#"class="style5">公告管理</a></td>     
	<td width="101" align="center" valign="middle" id="message" onClick="chang(menu_message,300,message)"><a href="../message/view" target="mainFrame" class="style5">站内信管理</a></td> 
    <td width="101" align="center" valign="middle" id="menu_depart1" onClick="chang(menu_depart,300,menu_depart1)"><a href="#"  class="style5">部门管理</a></td>
    <td width="101" align="center" valign="middle" id="menu_position1" onclick="chang(menu_position,400,menu_position1);" ><a href="#"  class="style5">职位管理</a></td>
          <td width="101" align="center" valign="middle"  id="menu_em1" onClick="chang(menu_em,300,menu_em1)"><a href="#" class="style5">员工管理</a></td>
     <td width="101" align="center" valign="middle" id="menu_sys1" onclick="chang(menu_sys,400,menu_sys1);" ><a href="#"  class="style5">系统管理</a></td> 
     <td width="101" height="17" align="center" valign="middle" ><a href="../sign/signstate.jsp" target="mainFrame" class="style1 style5">安全退出</a> </td>
  </tr> 
</table>
<Div id="menu_affice" style="display:none;width:0px;height:20px;">
  <table width="200" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
   <tr><td width="15%" height="24" >&nbsp;</td>
       <td><a href="../affice/view?flag=view" target="mainFrame" class="top3">查看以前公告</a>|</td>
	   <td><a href="../affice/view?flag=del" target="mainFrame" class="top3">删除公告</a></td>
  </tr>
</table>
</div>

<Div id="menu_depart" style="display:none;width:0px;height:20px">
  <table width="300px" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
   <tr><td width="10%" height="24" >&nbsp;</td>
       <td class="style5"><a href="../department/add.jsp" target="mainFrame" class="top3">添加部门</a>|</td>
	   <td><a href="../department/view?flag=change" target="mainFrame" class="top3">修改部门</a>|</td>
	   <td><a href="../department/view?flag=view" target="mainFrame" class="top3">查看部门</a>|</td>
	   <td ><a href="../department/view?flag=del" target="mainFrame" class="top3">删除部门</a></td>
  </tr>
</table>
</Div>
<Div id="menu_position" style="display:none;width:0px;height:20px;">
  <table width="400" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
   <tr><td width="10%" height="24" >&nbsp;</td>
       <td  class="style5 style6"><a href="../job/add.jsp" target="mainFrame" class="top3">添加职位信息</a>|</td>
	   <td><a href="../job/view?flag=change" target="mainFrame" class="top3">修改职位信息</a>|</td>
	   <td ><a href="../job/view?flag=view" target="mainFrame" class="top3">查看职位信息</a>|</td>
	   <td ><a href="../job/view?flag=del" target="mainFrame" class="top3">删除职位信息</a></td>
  </tr>
</table>
</Div>
<Div id="menu_em" style="display:none;width:0px;height:40px;">
  <table width="300" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
   <tr><td width="5%" height="24" >&nbsp;</td>
       <td class="style5"><a href="../em/view?flag=update" target="mainFrame" class="top3">更新员工信息</a>|</td>
	   <td ><a href="../em/view?flag=view" target="mainFrame" class="top3">浏览员工信息</a>|</td>
	   <td><a href="../em/add?emid=0" target="mainFrame" class="top3">添加员工信息</a></td>
  </tr>
</table>
</Div>
<Div id="menu_sys" style="display:none;width:0px;height:40px;">
  <table width="350" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
   <tr><td width="10%" height="24" >&nbsp;</td>
       <td class="style5"><a href="../sys/set1.jsp" target="mainFrame" class="top3">员工密码设定</a>|</td>
	   <td ><a href="../sys/setlimit.jsp" target="mainFrame" class="top3">员工权限设定</a>|</td>
	   <td ><a href="../sys/view" target="mainFrame" class="top3">查看当前公告发布者名单</a></td>
  </tr>
</table>
</Div>


<Div id="menu_departmentinfo" style="display:none;width:0px;height:40px;" >
  <table width="300" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
   <tr><td width="10%" height="24" >&nbsp;</td>
       <td width="8%" class="style5 style6"><a href="../job/view?flag=view" target="mainFrame" class="top3">查看职位信息</a>|</td>
	   <td width="8%"><a href="../department/view?flag=view"  target="mainFrame" class="top3" >查看部门信息</a>|</td>
  </tr>
</table>
</Div>

<Div id="temp" style="display:none;width:0px;height:0px;">
</Div>
</body>
</html>

