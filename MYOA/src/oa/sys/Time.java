package oa.sys;
import java.util.*;
import java.util.TimeZone;
import java.text.*;
/**
 ****************************************************
 *类名称：	Time<br>
 *类功能：	时间操作<br>
 ****************************************************
 */
public class Time {
	private Date time,timem;
	private String strtime;
	private SimpleDateFormat format;
	private SimpleDateFormat format1;
	/**
	 * 初始化
	 */
	public Time() {
		time=new Date();
		strtime="";
		format=null;
		//format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		//format1.setTimeZone(TimeZone.getTimeZone("GMT+8"));//设置时区 为东八区
	}
	/***************************************************
	*函数名称：	getYear()<br>
	*函数功能：	取得年份<br>	
	****************************************************/
	public int getYear(){
		format=new SimpleDateFormat("yyyy",Locale.getDefault());
		
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*函数名称：	getMonth()<br>
	*函数功能：	取得月份<br>
	*返回值：	int<br>
	****************************************************/
	public int getMonth(){
		format=new SimpleDateFormat("MM",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*函数名称：	getSunr()<br>
	*函数功能：	取得日份<br>		  
	****************************************************/
	public int getSun(){
		format=new SimpleDateFormat("dd",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	
	/***************************************************
	*函数名称：	getHour()<br>
	*函数功能：	取得小时<br>		  
	****************************************************/
	public int getHour(){
		format=new SimpleDateFormat("HH",Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*函数名称：	getMinu()<br>
	*函数功能：	取得分钟<br>		  
	****************************************************/
	public int getMinu(){
		format=new SimpleDateFormat("mm",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*函数名称：	getSecond()<br>
	*函数功能：	取得秒数<br>		  
	****************************************************/
	public int getSecond(){
		format=new SimpleDateFormat("ss",Locale.getDefault());
		strtime=format.format(time);
		return Integer.parseInt(strtime);
	}
	/***************************************************
	*函数名称：	getYMD()<br>
	*函数功能：	取得年-月-日<br>		  
	****************************************************/
	public String getYMD(){
		format=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
		strtime=format.format(time);
		return strtime;
	}
	/***************************************************
	*函数名称：	getHMS()<br>
	*函数功能：	取得时:分:秒<br>			  
	****************************************************/
	public String getHMS(){
		format=new SimpleDateFormat("HH:mm:ss",Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		strtime=format.format(time);
		return strtime;
	}
	/***************************************************
	*函数名称：	getYMDHMS()<br>
	*函数功能：	取得年-月-日 时:分:秒<br>		  
	****************************************************/
	public String getYMDHMS(){
		format=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss",Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		strtime=format.format(time);
		return strtime;
	}
	/***************************************************
	*函数名称：	getMinH<br>
	*函数功能：	获小时间差,输入的时间减现在的时间<br>	  
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
	*函数名称：	getMinM<br>
	*函数功能：	获分钟差,输入的时间减现在的时间<br>		  
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
	*函数名称：	getMinS<br>
	*函数功能：	获秒差,输入的时间减现在的时间<br>	  
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