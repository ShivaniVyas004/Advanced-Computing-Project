package searche;

import java.io.*;
import java.util.*;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class DictionaryCheck {

	public Hashtable<String, Value> dictionary() throws IOException{
	
		LinkedHashSet<String> lhSet=new LinkedHashSet<String>();
		ArrayList<String> aldup = new ArrayList<>();
		String line;
		ArrayList<Value> al = new ArrayList<>();

		Hashtable<String, Value> hashtable=new Hashtable<String, Value>();
		//FileOutputStream f = new FileOutputStream("file.txt");
		 File folder = new File("D:/MAC/Advanced Computing Concepts/Languages/W3C Web Pages/Text");
		 
		 for (File file : folder.listFiles()) {
		
			//File in=new File("./100_text/"+fileName.replace(".htm", ".txt"));
		//File in=new File("./100_text/"+fileList.get(0).replace(".htm", ".txt"));
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			 while ((line = br.readLine())!=null) {
	        	 
				 StringTokenizer str = new StringTokenizer(line,",.:;<>/?[)({}]+-*&%=#@^'!|_$`~");
	     			
	    			
	    			while(str.hasMoreTokens())
	    			{
	    				
	    				
	    				
	    				
	    				//System.out.println(str.nextToken());
	    				String str1 = str.nextToken().toLowerCase().replaceAll("\"","");
	    				String str2[]=str1.split(" ");
	    				
	    				for(int i=0;i<str2.length;i++){
	    		//			lhSet.add(str2[i]);
	    			//		aldup.add(str2[i]);
	    					
	    					if(!hashtable.containsKey(str2[i])){
	    						Value value=new Value();
	    						ArrayList<String> arrayList=new ArrayList<String>();
	    						int numberOfTimes=1;
	    						arrayList.add(file.getName());
	    						value.setNumberOfTimes(numberOfTimes);
	    						value.setPageName(arrayList);
	    						hashtable.put(str2[i], value);
	    					}
	    					else{

	    						Value value=hashtable.get(str2[i]);
	    						ArrayList<String> arrayList=value.getPageName();
	    						if(!arrayList.contains(file.getName()))
	    							arrayList.add(file.getName());
	    						//System.out.println(str2[i]);
	    						//System.out.println(value.getNunbetOFTimes()+"     "+value.getPagename());
	    						value.setNumberOfTimes(value.getNumberOfTimes()+1);
	    						value.setPageName(arrayList);
	    						hashtable.put(str2[i], value);	
	    					}
	    				}
	    			      }
	         }
	         }
		 
			//System.out.println(treeSet);
			/* for(String display : lhSet)
			 {
				al.add(display);
				 // System.out.println(display);
			 } 
			 Collections.sort(al); */
			 
			
			 
			/* File file = new File("DataDictionary2.txt");  
			 FileOutputStream fis = new FileOutputStream(file);  
			 PrintStream out = new PrintStream(fis);  
			 System.setOut(out); 
			 for(String display1 : al)
			 {
				 System.out.println(display1);
				// System.setOut(new PrintStream(f));
			 } */
			 
		
	return hashtable;
	}
	
	
	public void write(ArrayList<String> aldup) throws FileNotFoundException{
		 File filedup = new File("DataDictionarydup.txt");  
		 FileOutputStream fos = new FileOutputStream(filedup);  
		 PrintStream ps = new PrintStream(fos);  
		 System.setOut(ps); 
		 
		 for(String alprint : aldup)
		 {
			 System.out.println(alprint);
		 }
	
	}
	
	
	
	
	
	
}

