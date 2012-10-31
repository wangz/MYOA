package oa.sys;
/**
 ****************************************************
 *类名称：	Str<br>
 *类功能：	字符串转换操作<br>
 ****************************************************
 */
public class Str {

	public Str() {
		super();
	}

	/***************************************************
	*函数名称：chStr()<br>
	*函数功能：返回中文字符串<br>
	****************************************************/
	public String chStr(String str){
		if(str==null){
			str="";
		}else{
			try{
				str=(new String(str.getBytes("iso-8859-1"),"GB2312")).trim();
			}catch(Exception e){
				System.out.println("chStr");
				System.out.println(e.getMessage());
			}
		}
		return str;
	}
	public String unicodeStr(String str){
		if(str==null){
			str="";
		}else{
			try{
				str=(new String(str.getBytes("GB2312"),"iso-8859-1")).trim();
			}catch(Exception e){
				System.out.println("chStr");
				System.out.println(e.getMessage());
			}
		}
		return str;
	}
	/***************************************************
	*函数名称：inStr()<br>
	*函数功能：做编码一次转换,入库时防止sql攻击<br>
	****************************************************/
	public String inStr(String str){
		if(str==null){
			str="";
		}else{
			try{
				str=str.replace('\'',(char)1).trim();
			}catch(Exception e){
				System.out.println("inStr");
				System.out.println(e.getMessage());
			}
		}
		return str;
	}

	/***************************************************
	*函数名称：outStr()<br>
	*函数功能：做编码二次转换,出库时防止Exception<br>
	****************************************************/
	public String outStr(String str){
		if(str==null){
			str="";
		}else{
			try{
				str=str.replace((char)1,'\'').trim();
			}catch(Exception e){
				System.out.println("outStr");
				System.out.println(e.getMessage());
			}
		}
		return str;
	}

}
