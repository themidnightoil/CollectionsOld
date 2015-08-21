import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException{
		String path = "C:\\Users\\dshum\\workspace1\\Collections\\TheRaven.txt";
		WordCount wc  = new WordCount(path);
		wc.show_alpha_ordered_wordCount();
		
	}

}
