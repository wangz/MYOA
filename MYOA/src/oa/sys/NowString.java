package oa.sys;

import java.util.Date; 
import java.util.TimeZone;
import java.text.SimpleDateFormat;


public class NowString { 
   public static void main(String[] args) {  
	    
   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
   df.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
	 //Date d=new Date();
	 
	  //System.out.println(d);
   } 
} 

