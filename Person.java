import java.util.ArrayList;

public class Person{
	
	private String name;
	private ArrayList<Integer> prefs = new ArrayList<Integer>();
	private ArrayList<Integer> events = new ArrayList<Integer>();
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(String name, int p1, int p2, int p3, int p4, int p5){
		this.name = name;
		prefs.add(p1);
		prefs.add(p2);
		prefs.add(p3);
		prefs.add(p4);
		prefs.add(p5);
		
	}
	
	
	public ArrayList<Integer> getPrefs(){
		return prefs;
	}
	public ArrayList<Integer> getEvents(){
		return events;
	}
	
	public void addEvent(int event){
		events.add(event);
	}
	public void addPrefsI(int event){
		prefs.add(event);
	}
	public void removeEvent(int event){
		prefs.remove(event);
	}
	
	public String toString(){
		return name + ": " + prefs;
		
	}
	


}
