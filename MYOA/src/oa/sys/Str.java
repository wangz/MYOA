package oa.sys;
/**
 ****************************************************
 *�����ƣ�	Str<br>
 *�๦�ܣ�	�ַ���ת������<br>
 ****************************************************
 */
public class Str {

	public Str() {
		super();
	}

	/***************************************************
	*�������ƣ�chStr()<br>
	*�������ܣ����������ַ���<br>
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
	*�������ƣ�inStr()<br>
	*�������ܣ�������һ��ת��,���ʱ��ֹsql����<br>
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
	*�������ƣ�outStr()<br>
	*�������ܣ����������ת��,����ʱ��ֹException<br>
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
