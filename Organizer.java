import java.util.ArrayList;

public class Organizer{
	
	ArrayList<Person> peopleList = new ArrayList<Person>();
	int[] prio = new int[19];
	int[] firstPrio = new int[19];
	ArrayList<ArrayList<Integer>> semTable = new ArrayList<ArrayList<Integer>>(); // Timeslot x Seminar #
	ArrayList<Speaker> speakerList = new ArrayList<Speaker>();
	
	public Organizer(ArrayList<String[]> data){
		
		//Get People  +  Preferences
		for(int i = 1; i < 70; i++){
			
			peopleList.add(new Person(data.get(i)[2] + " " + data.get(i)[3], 
									  Integer.parseInt(data.get(i)[10]),
									  Integer.parseInt(data.get(i)[11]),
									  Integer.parseInt(data.get(i)[12]),
									  Integer.parseInt(data.get(i)[13]),
									  Integer.parseInt(data.get(i)[14])));
			
		}
		
		//System.out.println(peopleList);
		
		//Get Speakers  +  Seminars
		/* for(int i = 1; i < 19; i++){
			
			
		} */ //Work in Progress
		
	}
	
	public void setPrio(){
		
		prio = new int[19];
		firstPrio = new int[19];
		
		for( Person person : peopleList ){
			
			for(int i = 0; i < person.getPrefs().size(); i++){
				prio[person.getPrefs().get(i)] ++;
			}
			firstPrio[person.getPrefs().get(0)] ++;
			
		}
		
	}
	
	
	
}
