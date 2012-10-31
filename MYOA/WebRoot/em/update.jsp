<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<%@ page import="oa.sys.*,java.util.*,oa.data.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改和删除员工信息</title>


<link href="../css/work.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-family: "宋体";
	font-weight: bold;
}
.style8 {color: #000000; font-family: "宋体"; font-size: 14px; font-weight: bold; }
.style9 {
	color: #0F2771;
	font-weight: bold;
}
-->
</style>
<script language="JavaScript">
function del(){
	if(confirm("确认要删除此员工信息么？")==1)
	{
	return true;
	}
    else
    {
    return false;
    }
}

function change(){
	if(confirm("确认要修改此员工信息么？")==1)
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

 <td height="22" colspan="2" align="center">选择搜索条件</td>
 <td align="center" height="22">部门：</td>
 <td align="left">
 <select name="depid">
     <option value="0">所有</option>
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

  <td align="center" height="22">职位：</td>
 <td align="left">
 <select name="jobid">
 <option value="0">所有</option>
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

  <td align="center" height="22" >员工状态：</td>
 <td align="left">
 <select name="emsid">
 <option value="0">所有</option>
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
    <td height="22" colspan="11" align="center"  background="../KCM/zs.gif"><span class="style1">员工信息一览表</span></td>
  </tr>
  <tr align="center" class="column">
    <td height="26"><span class="style8">序号</span></td>
    <td><span class="style8">姓名</span></td>  
    <td><span class="style8">性别</span></td>          
    <td><span class="style8">职称</span></td>
    <td><span class="style8">部门</span></td>
    <td><span class="style8">职位</span></td>
    <td><span class="style8">状态</span></td>
    <td><span class="style8">修改</span></td>
    <td><span class="style8">删除</span></td>
  </tr>
<%
Collection coll=(Collection)request.getAttribute("msg");
if(coll==null){
%>
  <tr align="center">
    <td colspan="11" class="advise style9">没有找到员工信息</td>
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
		out.print("女");                //用这个来显示
	}else{
		out.print("男");
	}
%></td>
    <td><%= dep.getPost() %></td>
    <td><%= dep.getDepartment()%></td>
    <td><%= dep.getJob() %></td>
    <td><%= dep.getState() %></td><td>
    <a href="add?emid=<%=dep.getId()%>" OnClick="return change()"><font color="#33CCFF">修改</font></a></td>
   <td><a href="del?emid=<%=dep.getId()%>" OnClick="return del()"><font color="#33CCFF">删除</font></a></td>
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
    <td height="27" colspan="11"><span class="return" onClick="javascript:history.go(-1);">返回</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
</table>
</body>
</html>