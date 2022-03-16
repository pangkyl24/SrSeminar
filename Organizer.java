/*import java.util.ArrayList;

public class Organizer{

	private ArrayList<ArrayList<String>> data;
	private ArrayList<ArrayList<String>> baseData;
	private ArrayList<String[]> csvData;
	
	public Organizer(ArrayList<String[]> data){
		
		csvData = data; //Keep original CSV data with all information
		
		this.data = new ArrayList<ArrayList<String>>();
		for(int i = 1; i < 70; i++){
			this.data.add(new ArrayList<String>());
			this.data.get(i-1).add(data.get(i)[2] + " " + data.get(i)[3]);
			for(int j = 10; j < 15; j++){
				this.data.get(i-1).add(data.get(i)[j]);
			}
		} //Create 2D ArrayList with the Data we want to work with - Person Name, Pref 1, Pref 2, Pref 3, Pref 4, Pref 5
		
		baseData = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < this.data.size(); i++){
			baseData.add(this.data.get(i));
		}
		System.out.println(baseData);
		//Create Copy of the ArrayList above to keep. One will be mutated, one will not.
		
	}
	
	public ArrayList<ArrayList<String>> getData(){
		return data;
	}
	
	
	/*public int[] countPopularity(ArrayList<String[]> data){
		//Organizes an Array counting the amount of people who want to do each event
		//Index Number = Event Number
		
		int[] popularityCount = new int[19];
		
		for(int i = 1; i < 70; i++){
			for(int j = 10; j < 15; j++){
				popularityCount[Integer.parseInt(data.get(i)[j])] ++;	
			}
		}
		return popularityCount;
		
		
	}*/
	public int[] countPopularity(){
		int[] popularityCount = new int[19];
		for(int i = 0; i < data.size(); i++){
			for(int j = 1; j < 6; j++){
				popularityCount[Integer.parseInt(data.get(i).get(j))] ++;
			}
			
		}
		return popularityCount;
		
	}
	
	/*public ArrayList<ArrayList<String>> organizeData(ArrayList<String[]> data){
		
		ArrayList<ArrayList<String>> orgData = new ArrayList<ArrayList<String>>();
		for(int i = 1; i < 70; i++){
			orgData.add(new ArrayList<String>());
			orgData.get(i-1).add(data.get(i)[2] + " " + data.get(i)[3]);
			for(int j = 10; j < 15; j++){
				orgData.get(i-1).add(data.get(i)[j]);
			}
		}
		return orgData;
		
	}*/
	
	public int searchTopNum(int[] list){
		
		int largest = 1;
		for(int i = 2; i < list.length; i++){
			if (list[largest] < list[i]){
				largest = i;
			}
		}
		return largest;
		
		
	}

}*/

import java.util.ArrayList;

public class Organizer{
	
	ArrayList<Person> peopleList = new ArrayList<Person>();
	
	public Organizer(ArrayList<String[]> data){
		
		for(int i = 1; i < 70; i++){
			
			peopleList.add(new Person(data.get(i)[2] + " " + data.get(i)[3], 
									  Integer.parseInt(data.get(i)[10]),
									  Integer.parseInt(data.get(i)[11]),
									  Integer.parseInt(data.get(i)[12]),
									  Integer.parseInt(data.get(i)[13]),
									  Integer.parseInt(data.get(i)[14])));
			
		}
		
		System.out.println(peopleList);
		
	}
	
}

