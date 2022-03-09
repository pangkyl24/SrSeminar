import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.ArrayList;
/*
 * 15 people per section
 * 5 time slots - 6 rooms per time slot
 * no presenter more than 3 times
 */

public class SortSem{
	
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
		
		Organizer org = new Organizer(data);
		//System.out.println(org.getData());
		/*int[] pop = org.countPopularity();
		for(int i = 1; i < pop.length; i++){
			System.out.println(i + ": " + pop[i]);
		}
		System.out.println();*/
		
		
	}
		
}
