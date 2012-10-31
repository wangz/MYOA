package oa.sys;
import java.util.*;
import java.util.TimeZone;
import java.text.*;
/**
 ****************************************************
 *�����ƣ�	Time<br>
 *�๦�ܣ�	ʱ�����<br>
 ****************************************************
 */
public class Time {
	private Date time,timem;
	private String strtime;
	private SimpleDateFormat format;
	private SimpleDateFormat format1;
	/**
	 * ��ʼ��
	 */
	public Time() {
		time=new Date();
		strtime="";
		format=null;
		//format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		//format1.setTimeZone(TimeZone.getTimeZone("GMT+8"));//����ʱ�� Ϊ������
	}
	/***************************************************
	*�������ƣ�	getYear()<br>
	*�������ܣ�	ȡ�����<br>	
	****************************************************/
	public int getYear(){
		format=new SimpleDateFormat("yyyy",Locale.getDefault());
		
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*�������ƣ�	getMonth()<br>
	*�������ܣ�	ȡ���·�<br>
	*����ֵ��	int<br>
	****************************************************/
	public int getMonth(){
		format=new SimpleDateFormat("MM",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*�������ƣ�	getSunr()<br>
	*�������ܣ�	ȡ���շ�<br>		  
	****************************************************/
	public int getSun(){
		format=new SimpleDateFormat("dd",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	
	/***************************************************
	*�������ƣ�	getHour()<br>
	*�������ܣ�	ȡ��Сʱ<br>		  
	****************************************************/
	public int getHour(){
		format=new SimpleDateFormat("HH",Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*�������ƣ�	getMinu()<br>
	*�������ܣ�	ȡ�÷���<br>		  
	****************************************************/
	public int getMinu(){
		format=new SimpleDateFormat("mm",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*�������ƣ�	getSecond()<br>
	*�������ܣ�	ȡ������<br>		  
	****************************************************/
	public int getSecond(){
		format=new SimpleDateFormat("ss",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*�������ƣ�	getYMD()<br>
	*�������ܣ�	ȡ����-��-��<br>		  
	****************************************************/
	public String getYMD(){
		format=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
		strtime=format.format(time);
		return strtime;
	}
	/***************************************************
	*�������ƣ�	getHMS()<br>
	*�������ܣ�	ȡ��ʱ:��:��<br>			  
	****************************************************/
	public String getHMS(){
		format=new SimpleDateFormat("HH:mm:ss",Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		strtime=format.format(time);
		return strtime;
	}
	/***************************************************
	*�������ƣ�	getYMDHMS()<br>
	*�������ܣ�	ȡ����-��-�� ʱ:��:��<br>		  
	****************************************************/
	public String getYMDHMS(){
		format=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss",Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		strtime=format.format(time);
		return strtime;
	}
	/***************************************************
	*�������ƣ�	getMinH<br>
	*�������ܣ�	��Сʱ���,�����ʱ������ڵ�ʱ��<br>	  
	****************************************************/
	public int getMinH(String in){
		format = new SimpleDateFormat ("HH:mm:ss", Locale.getDefault());
		format1=new SimpleDateFormat("HH",Locale.getDefault());
		try {
			timem=format.parse(in);
			strtime=format1.format(timem);
			System.err.print(strtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	return Integer.parseInt(strtime)-this.getHour();
	}
	/***************************************************
	*�������ƣ�	getMinM<br>
	*�������ܣ�	����Ӳ�,�����ʱ������ڵ�ʱ��<br>		  
	****************************************************/
	public int getMinM(String in){
		format = new SimpleDateFormat ("HH:mm:ss", Locale.getDefault());
		format1=new SimpleDateFormat("mm",Locale.getDefault());
		try {
			timem=format.parse(in);
			strtime=format1.format(timem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	return Integer.parseInt(strtime)-this.getMinu();
	}
	/***************************************************
	*�������ƣ�	getMinS<br>
	*�������ܣ�	�����,�����ʱ������ڵ�ʱ��<br>	  
	****************************************************/
	public int getMinS(String in){
		format = new SimpleDateFormat ("HH:mm:ss", Locale.getDefault());
		format1=new SimpleDateFormat("ss",Locale.getDefault());
		try {
			timem=format.parse(in);
			strtime=format1.format(timem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	return Integer.parseInt(strtime)-this.getSecond();
	}
	public static void main(String[] args) {
		Time tim=new Time();
		tim.getYMDHMS();
		System.out.print(tim.getYMDHMS()); 
		}
	
}