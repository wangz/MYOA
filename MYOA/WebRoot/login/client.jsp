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
	setTimeout('hide(myObj,mymaxg,myObj2)','5'); //setTimeout���Ƴ�һ��������ִ��
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
<table width="100%" height="23" align="center"  cellpadding="0" cellspacing="1"  style="height: 23px;">
  <tr valign="bottom" bgcolor="#B7CAF9" class="top3" >
    
    <td width="81" align="center" valign="middle" id="temp2" onClick="parent.mainFrame.location.href='../affice/view?flag=view';chang(menu_affice,300,temp2)"><a href="#" class="style4">�������</a></td>
    <td width="81" align="center" valign="middle" id="menu_depart1" ><a href="../department/view?flag=view" class="style4" target="mainFrame" >���Ų鿴</a></td>
    <td width="81" align="center" valign="middle" id="message" onClick="chang(menu_message,300,message)"><a href="#" class="style4">վ����</a></td>
    <td width="71" align="center" valign="middle" id="menu_position1" ><a href="../job/view?flag=view" target="mainFrame"  class="style4">ְλ�鿴</a></td>
    <td width="81" align="center" valign="middle"  id="menu_em1"><a href="../em/view?flag=view" target="mainFrame" class="style5">Ա����Ϣ�鿴</a></td>
    <td width="81" align="center" valign="middle" id="menu_sys1" onclick="" ><a href="../sys/set2.jsp"  class="style4" target="mainFrame">�����޸�</a></td>
  <td width="81" align="center" valign="middle" ><a href="../sign/signstate.jsp" target="mainFrame" class="style4">��ȫ�˳�</a></td>
  </tr>
</table>

<Div id="menu_depart" style="display:none;width:0px;height:20px">
  <table width="300px" border="0" cellpadding="0" cellspacing="0" background="file:///C|/Documents and Settings/qiantai/����/MYOA/KCM/m.gif">
   <tr><td width="10%" height="24" >&nbsp;</td>
	   <td><a href="../department/view?flag=view" target="mainFrame" class="top3">�鿴����</a>|</td>
  </tr>
</table>
</Div>


<Div id="menu_affice" style="display:none;width:0px;height:20px;">
  <table width="200" border="0" cellpadding="0" cellspacing="0" background="">
   <tr><td width="15%" height="24" >&nbsp;</td>
       <td><a href="../affice/view?flag=view" target="mainFrame" class="top3">�鿴��ǰ����</a>|</td>
	   <td><a href="../affice/judge" target="mainFrame" class="top3">�������¹���</a></td>
  </tr>
</table>
</div>

<Div id="menu_message" style="display:none;width:0px;height:20px;">
  <table width="200" border="0" cellpadding="0" cellspacing="0" background="">
   <tr><td width="15%" height="24" >&nbsp;</td>
       <td><a href="../message/view" target="mainFrame" class="top3">�鿴�ҵ�վ����</a>|</td>
	   <td><a href="../message/send.jsp" target="mainFrame" class="top3">����վ����</a></td>
  </tr>
</table>
</div>

<Div id="menu_position" style="display:none;width:0px;height:20px;">
  <table width="400" border="0" cellpadding="0" cellspacing="0" background="file:///C|/Documents and Settings/qiantai/����/MYOA/KCM/m.gif">
   <tr><td width="10%" height="24" >&nbsp;</td>
	   <td ><a href="../job/view?flag=view" target="mainFrame" class="top3">�鿴ְλ��Ϣ</a>|</td>
  </tr>
</table>

<Div id="menu_sys" style="display:none;width:0px;height:40px;">
  <table width="200" border="0" cellpadding="0" cellspacing="0" background="KCM/m.gif">
   <tr><td width="10%" height="24" >&nbsp;</td>
       <td class="style5"><a href="../sys/set.jsp" target="mainFrame" class="top3">Ա�������趨</a>|</td>
  </tr>
</table>
</Div>




</body>
</html>

