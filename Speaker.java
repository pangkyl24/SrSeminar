import java.util.ArrayList;

public class Speaker{
	
	//var setup
	private String name;
	private ArrayList<String> semsName = new ArrayList<String>();
	private ArrayList<Integer> semsNum = new ArrayList<Integer>();
	
	//CONTRUCTOR
	public Speaker(String name){
		this.name = name;
	}
	
	//Adding a seminar
	public void addSeminar(String semName, int semNum){
		
		this.semsName.add(semName);
		this.semsNum.add(semNum);
		
	}
	
	//Returning vars
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
