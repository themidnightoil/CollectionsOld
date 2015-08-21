import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordCount {
	private BufferedReader text;
	private HashMap<String,Integer> wordCount = new HashMap<String,Integer>();
	
	
	public WordCount(String path) throws FileNotFoundException{
		//commits file's text to memory
		FileReader read = new FileReader(path);
		text = new BufferedReader(read);
		createWordCount();
	}//End Constructor
	
	
	private String[] line_sanitize(String s){
		//Sanitize Strings of none alphanumeric character
		return  (s.replaceAll("\\W", " ").toLowerCase()).split("\\s+");
	}//end line_sanitize
	
	
	
	private void createWordCount()   {
		String line;
		
		try {
			while((line = text.readLine())!=null){
				for(String word : line_sanitize(line)){
					if(!wordCount.containsKey(word)){
						wordCount.put(word, 1);
					}else{
						wordCount.put(word,wordCount.get(word)+1);
					}
					
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//There's a random String with no key at the beginning of the hash and this code removes it.
		Set s = wordCount.entrySet();
		Iterator it = s.iterator();
		it.next();
		it.remove();
	}//End CreateWordCount()
	
	public void showWordCount(){
		//Plain Show of Word Count
		
		for(Map.Entry<String, Integer>entry: wordCount.entrySet()){
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key+" : " + val);
			
			
		}
		
	}//End ShowWordCount()
	
	
	
	public void show_alpha_ordered_wordCount(){
		//Two arrays one holds the 	
	

		for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {

			for(Map.Entry<String, Integer>entry: wordCount.entrySet()){
				String key = entry.getKey();
				Integer val = entry.getValue();
			
				
				if(alphabet == key.charAt(0)){
					System.out.println(key + " : " + val);
					
				}
				
			}
		}
		
		
	

		
		
	}//End show_alpha_ordered_wordCount()

	
	public void show_numerucal_ordered_wordCount(){
		//Two arrays one holds the 	


	}


	
}//End WordCount Class
