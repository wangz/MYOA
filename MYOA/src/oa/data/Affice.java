package oa.data;
import oa.sys.*;
/**
 ****************************************************
 *类名称：	Affice<br>
 *类功能：	公告（类型）<br>
 ****************************************************
*/
public class Affice {
	private int id; 
	private String title;
	private String time;
	private int emid;
	private String content;
	private String affix;
	

	public Affice() {
		super();
		id=0;
		title="";
		time=new Time().getYMD();
		emid=0;
		content="";
		affix="";
	}

	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setTime(String time){
		this.time=time;
	}
	public String getTime(){
		return time;
	}
	public void setEmid(int emid){
		this.emid=emid;
	}
	public int getEmid(){
		return emid;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}

	public String getAffix() {
		return affix;
	}

	public void setAffix(String affix) {
		this.affix = affix;
	}
}
