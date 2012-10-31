package oa.data;
import oa.sys.*;

public class Eminfo {
	private int id;
	private String name;
	private int sex;
	private String birthday;
	private String learn;
	private String post;
	private String deid;
	private String jobid;
	private String tel;
	private String addr;
	private String stateid;
	private int limit;
	
	/**
	 * 员工信息
	 */
	public Eminfo() {
		super();
		id=0;
		name="";
		sex=0;
		birthday=new Time().getYMD();
		learn="";
		post="";
		deid="";
		jobid="";
		tel="";
		addr="";
		stateid="";
		limit=0;
	}

	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setSex(int sex){
		this.sex=sex;
	}
	public int getSex(){
		return sex;
	}
	public void setBirthday(String birthday){
		this.birthday=birthday;
	}
	public String getBirthday(){
		return birthday;
	}
	public void setLearn(String learn){
		this.learn=learn;
	}
	public String getLearn(){
		return learn;
	}
	public void setPost(String post){
		this.post=post;
	}
	public String getPost(){
		return post;
	}
	public void setDepartment(String deid){
		this.deid=deid;
	}
	public String getDepartment(){
		return deid;
	}
	public void setJob(String jobid){
		this.jobid=jobid;
	}
	public String getJob(){
		return jobid;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	public String getTel(){
		return tel;
	}
	public void setAddr(String addr){
		this.addr=addr;
	}
	public String getAddr(){
		return addr;
	}
	public void setState(String stateid){
		this.stateid=stateid;
	}
	public String getState(){
		return stateid;
	}
	public void setLimit(int limit){
		this.limit=limit;
	}
	public int getLimit(){
		return limit;
	}
	
}
