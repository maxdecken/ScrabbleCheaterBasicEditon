import java.io.FileNotFoundException;
import java.util.HashSet;

public class ScrabbleCheater {
	
	public static void main(String[] args) {
		WordsParser p = new WordsParser();
		String filepath = "C:\\Users\\Wolfsmond\\Documents\\Studium\\Medieninformatik_Studium\\2.Sem\\Informatik2\\Labs\\Lab13\\lab13-repo\\ScrabbleCheaterBasicEditon\\7letterWords.txt";
		
		try {
			HashSet<String> str = p.parseNames(filepath);
			//System.out.println(str.size());
			Dictionary cheater = new Dictionary();
			
			for (String s : str) {
				s = s.replaceAll("[0-9]","");
				cheater.addObject(s);
			}
		
			System.out.println(cheater.getStatus());
			System.out.println(cheater.getObject("rakestr"));
			//System.out.println(cheater.getObject("tofutti"));
			System.out.println(cheater.getObject("rummies"));
			System.out.println(cheater.getObject("reverse"));//lots of permutations
			
			
		} catch(FileNotFoundException e) {
			System.out.println("There is no such file");
		}
		

	}
}
