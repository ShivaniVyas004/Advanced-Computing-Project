package searche;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.io.*;

public class Meaning {
	
	
	static Hashtable<String, String> meaningHash=new Hashtable<>();	
	
	public Meaning() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("Words.txt"));
		
		String line;
		while((line = br.readLine())!=null)
		{
		
			String ar[]=line.split("->");
			
			meaningHash.put(ar[0].trim().toLowerCase(), ar[1].trim());
			
		
		}
	}
	
	
	public static String editDistanceCall(String word){
		
		Set set = meaningHash.entrySet();
	      // Get an iterator
	      Iterator i = set.iterator();

		int editDistance=101;
	      int editDistance2=101;
	      String wordKey="";
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         
	        
	         editDistance=Sequences.editDistance(word, me.getKey().toString());
	         if(editDistance2 > editDistance){
	        	 editDistance2=editDistance;
	        	 wordKey=me.getKey().toString();
	         }
		
		
		

		
	      }
	      return wordKey;
	}
	
	
	public void display(String word){
		if(meaningHash.containsKey(word)){
			System.out.println("Meaning of word "+word+" is :"+meaningHash.get(word));
		}
		else{
			String correctWord=editDistanceCall(word);
			System.out.println("*Did you mean? "+ correctWord);
			System.out.println("Meaning of word "+correctWord+" is :"+meaningHash.get(correctWord));
		}
		System.out.println();
		System.out.println();
//			System.out.println("Word not found.....");
	}

}
