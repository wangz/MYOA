<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title></title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
function login1()
         {
		
        var id=document.form1.id.value;
        var password=document.form1.password.value;   
               
         if(id==""||password=="")
         {         
         alert("��������д!");
         return false;
         }           
         return true;
         
}
</script>
<style type="text/css">
<!--
body {
	margin-right: -40px;
	margin-bottom: -20px;
}
.style3 {color: #0F2771; font-weight: bold; }
.style4 {font-weight: bold}
-->
</style></head>
<body>
      <form name="form1" id="form1" method="post" action="em" onSubmit="return login1()">
<table width="102%" height="100%" border="0"  cellpadding="0" cellspacing="0" background="../image/back.gif"class="top2">

    <tr>
      <td width="451" height="246" rowspan="7">&nbsp;</td>
      <td height="153" colspan="3" >&nbsp;</td>
      <td width="70" rowspan="7" >&nbsp;</td>
    </tr>
    <tr>
      <td height="11" colspan="3" align="center" > </td>
    </tr>
    <tr>
      <td height="21" colspan="3" align="center" ><span class="style3">Ա����¼</span></td>
    </tr>
    <tr>
      <td width="20" align="center" >&nbsp;</td>
      <td width="65" height="21" align="center" ><div align="center" class="style3">Ա����:</div></td>
      <td width="178" height="21" align="center" ><div align="left">
        <input type="text" name="id" />
      </div></td>
    </tr>
    <tr>
      <td align="center" >&nbsp;</td>
      <td height="21" align="center" ><div align="center" class="style3">��&nbsp;&nbsp;��:</div></td>
      <td height="21" align="center" class="style4" ><div align="left">
        <input type="password" name="password" />
      </div></td>
    </tr>
    <tr>
      <td height="23" colspan="3" align="center" class="style4" >
	  <input type="submit" name="tijiao" value="�ύ">
&nbsp;
      <input type="reset" name="Submit2" value="����" /></td>
    </tr>
   
    <tr>
      <td height="21" colspan="3" class="style4" >&nbsp;</td>
    </tr>
  
</table>
 </form>
</body>
</html>