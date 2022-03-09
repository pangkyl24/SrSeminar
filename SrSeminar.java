/*
 * 15 people per section
 * 5 time slots - 6 rooms per time slot
 * no presenter more than 3 times
 */
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.ArrayList;


public class SrSeminar{
	
	public static void main(String[] args){
		
		ArrayList<String[]> data = new ArrayList<String[]>();	
		String line = "";
		String splitBy = ",";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/pangkyl24/Desktop/SrSem/SrSeminar_RawData.csv"));
			while((line = br.readLine()) != null){
				
				data.add(line.split(splitBy));
				
			}
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//^Import everything into ArrayList<String[]> data
		
		/*for(int i = 1; i < 70; i++){
			
			System.out.print(people.get(i)[2] + " " + people.get(i)[3] + ": ");
			for(int j = 10; j < 15; j++){
				System.out.print(people.get(i)[j]);
				if (j!=14){
					System.out.print(", ");
				}
			}
			System.out.println("");
			
			
		}*/
		Organizer test = new Organizer();
		int[] pop = test.countPopularity(data);
		for(int i = 1; i < pop.length; i++){
			System.out.println(i + ": " + pop[i]);
		}
		System.out.println();
		//System.out.println(test.countPopularity(data)[14]);
		ArrayList<ArrayList<String>> newData = test.organizeData(data);
		System.out.println(newData);
		
		int largest = test.searchTopNum(pop);
		System.out.println("Most Popular Event: " + largest);
		
		
		
		
	}
	
}
