<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�޸ĺ�ɾ��Ա����Ϣ</title>


<link href="../css/work.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-family: "����";
	font-weight: bold;
}
.style8 {color: #000000; font-family: "����"; font-size: 14px; font-weight: bold; }
.style9 {
	color: #0F2771;
	font-weight: bold;
}
-->
</style>
<script language="JavaScript">
function del(){
	if(confirm("ȷ��Ҫɾ����Ա����Ϣô��")==1)
	{
	return true;
	}
    else
    {
    return false;
    }
}

function change(){
	if(confirm("ȷ��Ҫ�޸Ĵ�Ա����Ϣô��")==1)
	{
	return true;
	}
    else
    {
    return false;
    }
}
</script>
  </head>
  
  <body bgcolor="#ECF1FF">
<table width="668" height="157" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
<%! int depid=0,jobid=0,stateid=0; %>
 <%
   if(request.getAttribute("depid")!=null&&request.getAttribute("jobid")!=null&&request.getAttribute("stateid")!=null)
    {
     depid=Integer.parseInt(request.getAttribute("depid").toString());
     jobid=Integer.parseInt(request.getAttribute("jobid").toString());
     stateid=Integer.parseInt(request.getAttribute("stateid").toString());
    }
    
    
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
 <form name="forms" id="forms" method="post" action="select?flag=update" >
 <tr>

 <td height="22" colspan="2" align="center">ѡ����������</td>
 <td align="center" height="22">���ţ�</td>
 <td align="left">
 <select name="depid">
     <option value="0">����</option>
<%
	Iterator itd=colld.iterator();
	while(itd.hasNext()){
		Department dep=(Department)itd.next();
%>
      <option value="<%= dep.getId() %>" <%if(depid!=0&&depid==dep.getId()) out.print("selected"); %>><%= dep.getName() %></option>
<%
		}
%>
    </select></td>

  <td align="center" height="22">ְλ��</td>
 <td align="left">
 <select name="jobid">
 <option value="0">����</option>
<%
	Iterator itj=collj.iterator();
	while(itj.hasNext()){
		Job dep=(Job)itj.next();
%>
      <option value="<%= dep.getId() %>" <%if(jobid!=0&&jobid==dep.getId()) out.print("selected"); %>><%= dep.getName() %></option>
<%
		}
%>
    </select></td>

  <td align="center" height="22" >Ա��״̬��</td>
 <td align="left">
 <select name="emsid">
 <option value="0">����</option>
<%
	Iterator ite=colle.iterator();
	while(ite.hasNext()){
		Emstate dep=(Emstate)ite.next();
%>
      <option value="<%= dep.getId() %>" <%if(stateid!=0&&stateid==dep.getId()) out.print("selected"); %>><%= dep.getName() %></option>
<%
		}
%>
    </select></td>
	<td><input type="submit" value="GO-&gt;" /></td>
	 
 </tr>
 </form>
 <%} %>
  
  <tr>
    <td height="22" colspan="11" align="center"  background="../KCM/zs.gif"><span class="style1">Ա����Ϣһ����</span></td>
  </tr>
  <tr align="center" class="column">
    <td height="26"><span class="style8">���</span></td>
    <td><span class="style8">����</span></td>  
    <td><span class="style8">�Ա�</span></td>          
    <td><span class="style8">ְ��</span></td>
    <td><span class="style8">����</span></td>
    <td><span class="style8">ְλ</span></td>
    <td><span class="style8">״̬</span></td>
    <td><span class="style8">�޸�</span></td>
    <td><span class="style8">ɾ��</span></td>
  </tr>
<%
Collection coll=(Collection)request.getAttribute("msg");
if(coll==null){
%>
  <tr align="center">
    <td colspan="11" class="advise style9">û���ҵ�Ա����Ϣ</td>
  </tr>
  <%
}else{
Iterator it=coll.iterator();
while(it.hasNext()){
	Eminfo dep=(Eminfo)it.next();
%>
  <tr align="center" height="22">
    <td><%= dep.getId() %></td>
    <td><%= dep.getName() %></td>
    <td>
<% 
	if(dep.getSex()==0){
		out.print("Ů");                //���������ʾ
	}else{
		out.print("��");
	}
%></td>
    <td><%= dep.getPost() %></td>
    <td><%= dep.getDepartment()%></td>
    <td><%= dep.getJob() %></td>
    <td><%= dep.getState() %></td><td>
    <a href="add?emid=<%=dep.getId()%>" OnClick="return change()"><font color="#33CCFF">�޸�</font></a></td>
   <td><a href="del?emid=<%=dep.getId()%>" OnClick="return del()"><font color="#33CCFF">ɾ��</font></a></td>
  </tr>
  <%
	}
}
request.removeAttribute("msg");
%>
<%
   String msg1=(String)request.getAttribute("msg1");
   if(msg1!=null)
   {
 %>
<%=msg1 %>
<%
    }
    request.removeAttribute("msg1");
 %> 
  <tr align="right" bgcolor="#ECF1FF">
    <td height="27" colspan="11"><span class="return" onClick="javascript:history.go(-1);">����</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
</body>
</html>