import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.ArrayList;

public class SrSeminar{
	
	public static void main(String[] args){
		
		ArrayList<String[]> people = new ArrayList<String[]>();	
		String line = "";
		String splitBy = ",";
		try {
			
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/pangkyl24/Desktop/SrSem/SrSeminar_RawData.csv"));
			while((line = br.readLine()) != null){
				
				people.add(line.split(splitBy));
				
			}
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		System.out.println(people.get(1)[0]);
		
		
	}
	
}
