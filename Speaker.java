import java.util.ArrayList;

public class Speaker{
	
	private String name;
	private ArrayList<String> semsName = new ArrayList<String>();
	private ArrayList<Integer> semsNum = new ArrayList<Integer>();

	public Speaker(String name){
		this.name = name;
	}
	
	public void addSeminar(String semName, int semNum){
		
		this.semsName.add(semName);
		this.semsNum.add(semNum);
		
	}
	
	public ArrayList<String> getSemsName(){
		return semsName;
	}
	public ArrayList<Integer> getSemsNum(){
		return semsNum;
	}
	
	public String toString(){
		return name + ": " + semsNum;
	}

}
