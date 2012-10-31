package oa.data;

/**
 ****************************************************
 *类名称：	Department<br>
 *类功能：	部门（类型）<br>
 ****************************************************
*/
public class Department {
	private int id;
	private String name;
	private String explain;
	

	public Department() {
		super();
		id=0;
		name="";
		explain="";
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
	public void setExplain(String explain){
		this.explain=explain;
	}
	public String getExplain(){
		return explain;
	}
}
