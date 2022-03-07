import java.util.ArrayList;

public class Organizer{

	public int[] countPopularity(ArrayList<String[]> data){
		
		int[] popularityCount = new int[19];
		
		for(int i = 1; i < 70; i++){
			for(int j = 10; j < 15; j++){
				popularityCount[Integer.parseInt(data.get(i)[j])] ++;	
			}
		}
		return popularityCount;
		//Organizes an Array counting the amount of people who want to do each event
		//Index Number = Event Number
		
	}
	
	public ArrayList<ArrayList<String>> organizeData(ArrayList<String[]> data){
		
		ArrayList<ArrayList<String>> orgData = new ArrayList<ArrayList<String>>();
		for(int i = 1; i < 70; i++){
			orgData.add(new ArrayList<String>());
			orgData.get(i-1).add(data.get(i)[2] + " " + data.get(i)[3]);
			for(int j = 10; j < 15; j++){
				orgData.get(i-1).add(data.get(i)[j]);
			}
		}
		return orgData;
		
		
	}

}
