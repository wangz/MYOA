package oa.data;

/**
 ****************************************************
 *�����ƣ�	Department<br>
 *�๦�ܣ�	���ţ����ͣ�<br>
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
