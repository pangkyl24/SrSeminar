import java.util.ArrayList;

public class Organizer{
	
	//Var Setup
	ArrayList<Person> peopleList = new ArrayList<Person>();
	int[] prio = new int[19];
	int[] firstPrio = new int[19];
	ArrayList<ArrayList<Integer>> semTable = new ArrayList<ArrayList<Integer>>(); // Timeslot x Seminar #
	ArrayList<Speaker> speakerList = new ArrayList<Speaker>();
	
	public Organizer(ArrayList<String[]> data){
		
		//Get People  +  Preferences
		for(int i = 1; i < 70; i++){
			
			//Add each person in CSV as a Person Class
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
	
	public void setPrio(){ //Determines the Popularity of every Seminar
		
		prio = new int[19];
		firstPrio = new int[19];
		
		for( Person person : peopleList ){ //Looping over PeopleList
			
			for(int i = 0; i < person.getPrefs().size(); i++){
				if(person.getPrefs().size() > 0){
					prio[person.getPrefs().get(i)] ++;
				}
				prio[person.getPrefs().get(i)] ++;
			}
			if(person.getPrefs().size() > 0){
				
				firstPrio[person.getPrefs().get(0)] ++;
			
			}
						
		}
		
		//Test Method
		//System.out.println();
		//System.out.print("Prio: ");
		//for(int i = 0; i < 19; i++){
		//	System.out.print(prio[i] + " ");
		//}
		//System.out.println();
		//System.out.print("firstPrio: ");
		//for(int i = 0; i < 19; i++){
		//	System.out.print(firstPrio[i] + " ");
		//}
		//System.out.println();
	}
	
	//public int SpeakerOfSem(int num){
	//}
	public void setTimeSlot(){
		
		if(semTable.size() == 0){
			semTable.add(new ArrayList<Integer>());
		}
		else if (semTable.get(semTable.size()-1).size() == 6){
			semTable.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < semTable.get(semTable.size()-1).size(); i++){
			firstPrio[semTable.get(semTable.size()-1).get(i)] = 0;
			prio[semTable.get(semTable.size()-1).get(i)] = 0;
		}
		//System.out.println("Removed Discrepancies");
		//Creates the "next" timeslot and removes any possibility for any lectures be put in the timeslot that shouldnt be there
		
		while (true){ //Find largest in firstPrio + >15 in prio
			
			int max = 0;
			for(int i = 0; i < 19; i++){
				if (firstPrio[i] > firstPrio[max]){
					max = i;
				}
				else if (firstPrio[i] == firstPrio[max] && prio[i] > prio[max]){
					max = i;
				} //Max is set through firstPrio, and if they are equal, the one with the highest general popularity is set as the new max
			}
			
			if (prio[max] >= 15){ //If the general popularity of the chosen event is > 15, then that event is set.
				//System.out.println("Max Set: " + max);
				semTable.get(semTable.size()-1).add(max);
				break;
			}
			/*
			else if (firstPrio[max] == 0){ //if first pick priority of the set Max value is 0
				int priomax = 0;
				for(int i = 0; i < 19; i++){
					if (prio[i] > prio[priomax]){
						priomax = i;
					}
					else if (prio[i] == prio[priomax] && firstPrio[i] > firstPrio[priomax]){
						priomax = i;
					} //priomax is set to the value with the highest overall popularity
				}
				semTable.get(semTable.size()-1).add(max);
				break;
			}
			else{
				firstPrio[max] = 0;
			}*/
			else{ //if general popularity isnt > 15, the pick goes to the next largest
				int priomax = 0;
				for(int i = 0; i < 19; i++){
					if(prio[i] > prio[priomax]){
						priomax = i;
					}
					else if(prio[i] == prio[priomax] && firstPrio[i] > firstPrio[priomax]){
						priomax = i;
					}
				}
				//System.out.println("Priomax Set: " + priomax);
				semTable.get(semTable.size()-1).add(priomax);
				break;
				
				
			}
			
			
			
		}
		
		//Test Method
		//System.out.println(semTable);
	}
	
	public void fillPeople(){
		
		//local vars
		int eventNum = semTable.get(semTable.size()-1).get(semTable.get(semTable.size()-1).size()-1);
		int counter = 0; //if ==15 break loop
		
		/*for(int i = 0; i < peopleList.size(); i++){
			
			for(int j = 0; j < peopleList.get(i).getPrefs().size(); j++){
				
				if(peopleList.get(i).getPrefs().get(j) == eventNum){
					
					peopleList.get(i).addEvent(eventNum);
					peopleList.get(i).removeEvent(eventNum);
					peopleList.add(peopleList.get(i));
					peopleList.remove(i);
					if(counter == 15){
						break;
					}
					
				}
			}
		}*/
		
		/*System.out.println(peopleList.size());
		System.out.println(eventNum);
		for(int i = 0; i < peopleList.size(); i++){
			
			System.out.println(i + " " + peopleList.get(i));
			System.out.println(peopleList.get(i).getPrefs());
			System.out.println(peopleList.get(i).getPrefs().get(0));
			System.out.println(peopleList.get(i).getPrefs().get(0) == eventNum);
			
		}
		
		peopleList.get(0).addEvent(eventNum);
		peopleList.get(0).removeEvent(15);
		
		System.out.println(peopleList.get(0));
		System.out.println(peopleList.get(0).getEvents());
		
		
		peopleList.add(peopleList.get(0));
		peopleList.remove(0);
		
		System.out.println(peopleList);*/
		
		
		
		for(int i = 0; i < peopleList.size(); i++){
			
			//Goes through the People in PeopleList to see whose first choice is the same as eventNum, then moves them to the back of the list
			if(peopleList.get(i).getPrefs().size() > 0 && peopleList.get(i).getPrefs().get(0) == eventNum){
				
				peopleList.get(i).addEvent(eventNum);
				
				peopleList.get(i).removeEvent(eventNum);
				//System.out.println(peopleList.get(i) + ": " + peopleList.get(i).getEvents() + ": " + i); //Test
				
				//peopleList.add(peopleList.get(i));
				//peopleList.remove(i);
				
				counter++;
				if(counter == 15){
					//System.out.println("Done1");
					return;
				}
			}
		}
			
		
		if(counter == 15){
			//System.out.println("Done2");
			return;
		}
		
		for(int i = 0; i < peopleList.size(); i++){
			
			for(int j = 0; j < peopleList.get(i).getPrefs().size(); j++){
				
				//Goes though the People in PeopleList too see who has a choice that is the same as eventNum, then moves them to the back of the list
				if(peopleList.get(i).getPrefs().get(j) == eventNum){
					
					peopleList.get(i).addEvent(eventNum);
					
					peopleList.get(i).removeEvent(eventNum);
					//System.out.println(peopleList.get(i) + ": " + peopleList.get(i).getEvents()); //Test
					//peopleList.add(peopleList.get(i));
					//peopleList.remove(i);
					
					counter++;
					if(counter == 15){
						//System.out.println("Done3");
						return;
					}
					
				}
				
			}
			
		}
		//System.out.println("Done4");
		
	}
			
			
	
	
	public void printSeminars(){
		
		System.out.println("People Schedules: ");
		for(int i = 0; i < peopleList.size(); i++){
			System.out.println(peopleList.get(i).getName() + ": " + peopleList.get(i).getEvents());
		}
		System.out.println();
		System.out.println("Seminar Schedule: ");
		System.out.println(semTable);
		
		
		
		
	}
	public void displayTest(){
		System.out.println(peopleList);
		System.out.println("\n\n\n");
		for(int i = 0; i < 19; i++){
			System.out.print(prio[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < 19; i++){
			System.out.print(firstPrio[i] + " ");
		}
		System.out.println();
		
		System.out.println(semTable);
	}
		
}




