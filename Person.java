import java.util.ArrayList;

public class Person{
	
	private String name;
	private ArrayList<int> prefsI;
	private ArrayList<String> prefsS;
	private ArrayList<int> events;
	
	public Person(String name){
		this.name = name;
	}
	public ArrayList<int> getPrefsI(){
		return prefsI;
	}
	public ArrayList<String> getPrefsS(){
		return prefsS;
	}
	public ArrayList<int> getEvents(){
		returnEvents;
	}
	
	public void addEvent(int event){
		events.add(event);
	}
	public void addPrefsI(int event){
		prefsI.add(event);
	}
	public void addPrefsS(String event){
		prefsS.add(event);
	}
	
	public String toString(){
		String ret = name + ": ";
		for(int i = 0; i < prefsI.size(); i++){
			ret = ret + prefsI.get(i) + " ";
		}
		return ret;
		
	}
	


}
