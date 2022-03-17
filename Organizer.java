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
	
	//public int SpeakerOfSem(int num){
	//}
	public void setTimeSlot(){
		
		if (semTable.get(semTable.size()-1).size() == 6){
			semTable.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < semTable.get(semTable.size()-1).size(); i++){
			firstPrio[semTable.get(semTable.size()-1).get(i)] = 0;
			prio[semTable.get(semTable.size()-1).get(i)] = 0;
		}
		
		while (true){ //Find largest in firstPrio + >15 in prio
			
			int max = 0;
			for(int i = 0; i < 19; i++){
				if (firstPrio[i] > firstPrio[max]){
					max = i;
				}
				else if (firstPrio[i] == firstPrio[max] && prio[i] > prio[max]){
					max = i;
				}
			}
			if (prio[max] >= 15){
				semTable.get(semTable.size()-1).add(max);
				break;
			}
			else if (firstPrio[max] == 0){
				int priomax = 0
				for(int i = 0; i < 19; i++){
					if (prio[i] > prio[priomax]){
						priomax = i;
					}
					else if (prio[i] == prio[priomax] && firstPrio[i] > firstPrio[priomax]){
						priomax = i;
					}
				}
				semTable.get(semTable.size()-1).add(max);
				break;
			}
			else{
				firstPrio[max] = 0;
			}
			
			
			
		}
	}
	
	public void fillPeople(){
		
		int eventNum = semTable.get(semTable.size()-1).get(semTable.size()-1);
		int counter = 0; //if ==15 break loop
		for(int i = 0; i < peopleList.size(); i++){
			for(int j = 0; j < peopleList.get(i).getPrefs().size()){
				if(peopleList.get(i).getPrefs().get(j) == eventNum){
					peopleList.get(i).addEvent(eventNum);
					peopleList.get(i).removeEvent(eventNum);
					if(counter == 15){
						break;
					}
					}
				}
			}
			
		}
		
	}
	
	
	
}
