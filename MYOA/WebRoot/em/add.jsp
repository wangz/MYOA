<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Ա����Ϣ����</title>
<link href="../css/work.css" rel="stylesheet" type="text/css" />

<script language="JavaScript">
function add(){
	if(document.form1.name.value==""){
		alert("������Ա������");
		return false;
	}
	if(document.form1.birthday.value==""){
		alert("������Ա����������");
		return false;
	}else if(document.form1.birthday.value.indexOf("-")==-1){
		alert("����д���ڸ�ʽ");				
		document.form1.birthday.focus();
		return false;
	}
	if(document.form1.learn.value==""){
		alert("������Ա��ѧ��");
		return false;
	}
	if(document.form1.post.value==""){
		alert("������Ա��ְ��");
		return false;
	}
	if(document.form1.tel.value==""){
		alert("������Ա���绰");
		return false;
	}
	if(document.form1.addr.value==""){
		alert("������Ա����ַ");
		return false;
	}
	return true;
}
</script>

<style type="text/css">
<!--
.style1 {
	color: #000000;
	font-family: "����";
	font-size: 16px;
	font-weight: bold;
}
-->
</style>
</head>
<body bgcolor="#ECF1FF">
<form name="form1" id="form1" method="post" action="save" onsubmit="return add()">
<table width="688" height="424" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">

<%
	Collection colld=(Collection)session.getAttribute("msgd");
	Collection collj=(Collection)session.getAttribute("msgj");
	Collection colle=(Collection)session.getAttribute("msge");
	if(colld==null){
		out.print("colld");
	}else if(collj==null){
		out.print("colld");
	}else if(colld==null){
		out.print("colld");
	}else{
%>
  <tr >
    <td height="21" colspan="4" align="center" class="title style1" background="../KCM/zs.gif">Ա����Ϣ����</td>
  </tr>
  <tr>

    <td width="328" align="center"> ��&nbsp;&nbsp;&nbsp;&nbsp;����</td>
    <td width="358" align="left"><input name="name" type="text" maxlength="40" /></td>

  </tr>
  <tr>
    <td align="center">��&nbsp;&nbsp;&nbsp;&nbsp;��</td>
    <td align="left">
      <input name="sex" type="radio" value="1" checked />
  ��
      <input type="radio" name="sex" value="0" />
  Ů    </td>
  </tr>
  <tr>
    <td align="center"> �������ڣ�</td>
    <td align="left"><input name="birthday" type="text" maxlength="11" />
      ��-��-��</td>
  </tr>
  <tr>
    <td align="center">ѧ&nbsp;&nbsp;&nbsp;&nbsp;���� </td>
    <td align="left"><input name="learn" type="text" size="20" maxlength="20" /></td>
  </tr>
  <tr>
    <td align="center"> ְ&nbsp;&nbsp;&nbsp;&nbsp;�ƣ� </td>
    <td align="left"><input name="post" type="text" size="20" maxlength="20" /></td>
  </tr>
  <tr>
    <td align="center"> ��&nbsp;&nbsp;&nbsp;&nbsp;�ţ� </td>
    <td align="left"><select name="depid">
<%
	Iterator itd=colld.iterator();
	while(itd.hasNext()){
		Department dep=(Department)itd.next();
%>
      <option value="<%= dep.getId() %>"><%= dep.getName() %></option>
<%
		}
%>
    </select></td>
  </tr>
  <tr>
    <td align="center"> ְ&nbsp;&nbsp;&nbsp;&nbsp;λ�� </td>
    <td align="left"><select name="jobid">
<%
	Iterator itj=collj.iterator();
	while(itj.hasNext()){
		Job dep=(Job)itj.next();
%>
      <option value="<%= dep.getId() %>"><%= dep.getName() %></option>
<%
		}
%>
    </select></td>
  </tr>
  <tr>
    <td align="center"> ��&nbsp;&nbsp;&nbsp;&nbsp;���� </td>
    <td align="left"><input name="tel" type="text" maxlength="40" /></td>
  </tr>
  <tr>
    <td align="center"> �����ַ�� </td>
    <td height="27" align="left"><input name="addr" type="text" size="50" maxlength="200" /></td>
  </tr>
  <tr>
    <td align="center"> Ա��״̬��</td>
    <td align="left"><select name="emsid">
<%
	Iterator ite=colle.iterator();
	while(ite.hasNext()){
		Emstate dep=(Emstate)ite.next();
%>
      <option value="<%= dep.getId() %>"><%= dep.getName() %></option>
<%
		}
%>
    </select></td>
  </tr>
 <% 
		String msg=(String)request.getAttribute("msg");
		if(msg!=null){
			out.print(msg);
			request.removeAttribute("msg");
		}
%>
  <tr>
    <td colspan="2" align="center"><input type="submit" name="Submit" value="���" />
&nbsp;&nbsp;
<input type="reset" name="Submit2" value="����" />
&nbsp;&nbsp;
<input type="button" name="Submit22" value="����" onclick="javascript:history.back(-1);"/></td>
  </tr>

<%
	}
%>
</form>
</table>
</body>
</html>
