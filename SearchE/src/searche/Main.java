
package searche;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import org.apache.lucene.queryParser.ParseException;

public class Main {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		
		
		
		//reading files from directory
	/*	ReadFiles readFiles=new ReadFiles();
		ArrayList<String> fileList=readFiles.readingDirectory();
				
		
		// converting the html to text
		JsoupConvertor jso1upConvertor=new JsoupConvertor();
		jsoupConvertor.convert(fileList); */

		DictionaryCheck dictionaryCheck=new DictionaryCheck();
		Hashtable<String, Value> hashtable=dictionaryCheck.dictionary(); 
		//dictionaryCheck.write(aldup);
	
		Scanner scanner=new Scanner(System.in);
		System.out.println("***** Welcome to search engine *****\n ");

		String exit="";
		while(!exit.equals("exit")){
			System.out.println("Enter Your Choice:");
			System.out.println("1. Find the meaning of a word");
			System.out.println("2. Listing links from the URL");
			System.out.println("3. Indexing and Searching");
			System.out.println("4. Check for mis-spelled words");
			System.out.println("5. Find Homophones for a word");
			System.out.println("6. Quit ! ");
			int val=scanner.nextInt();
			
			switch(val){
			case 1:
				Meaning meaning=new Meaning();
				System.out.println("Please enter the word you want to search");
				String nul = scanner.nextLine();
				String word=scanner.nextLine();
				meaning.display(word);
				break;
				
			case 2:
				ListLinks l = new ListLinks();
		        l.links();
				break;
				
			case 3:
				IndexandSearch i = new IndexandSearch();
				i.indexs();
				break;
				
			case 4:
				SpellChecker sc = new SpellChecker();
			    sc.spell();
			    break;
			    
			case 5:
				Homophones m = new Homophones();
			    System.out.println("Please Enter a Word to Find Homophone(s):");
			    String n4 = scanner.nextLine();
			    String word3 = scanner.nextLine();
			    m.displayHomophones(word3);
			    break;
			    
			case 6:
				exit="exit";
				System.out.println("Bye Bye!!!");
				break;
			}
			
			
						}
		scanner.close();
	}

	private static void print(String string, String url) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
