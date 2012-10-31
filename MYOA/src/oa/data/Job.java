package oa.data;

/**
 ****************************************************
 *类名称：	Job<br>
 *类功能：	职位（类型）<br>
 ****************************************************
*/
public class Job {
	private String explain;
	private int id;
	private String name;

	
	
	public Job() {
		super();
		id=0;
		name="";
		explain="";
	}

	public String getExplain(){
		return explain;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public void setExplain(String explain){
		this.explain=explain;
	}
	
	public void setId(int id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
}
