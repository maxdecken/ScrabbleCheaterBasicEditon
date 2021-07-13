import java.io.FileNotFoundException;
import java.util.HashSet;

public class ScrabbleCheater {
	
	public static void main(String[] args) {
		WordsParser p = new WordsParser();
<<<<<<< HEAD
		String filepath = "C:\\Users\\Wolfsmond\\Documents\\Studium\\Medieninformatik_Studium\\2.Sem\\Informatik2\\Labs\\Lab13\\lab13-repo\\ScrabbleCheaterBasicEditon\\7letterWords.txt";
		
		try {
			HashSet<String> str = p.parseNames(filepath);
			//System.out.println(str.size());
=======
		String filepath = "C:\\Users\\Wolfsmond\\Documents\\Studium\\Medieninformatik_Studium\\2.Sem\\Informatik2\\Labs\\Lab13\\lab13-repo\\7letterWords.txt";
		
		try {
			HashSet<String> str = p.parseNames(filepath);
			System.out.println(str.size());
>>>>>>> 8f0ee7e360297621d513266746737b5fcdec796d
			Dictionary cheater = new Dictionary();
			
			for (String s : str) {
				s = s.replaceAll("[0-9]","");
				cheater.addObject(s);
			}
		
			System.out.println(cheater.getStatus());
<<<<<<< HEAD
			System.out.println(cheater.getObject("rakestr"));
			//System.out.println(cheater.getObject("tofutti"));
=======
			System.out.println(cheater.getObject("piaffes"));
			System.out.println(cheater.getObject("tofutti"));
>>>>>>> 8f0ee7e360297621d513266746737b5fcdec796d
			System.out.println(cheater.getObject("rummies"));
			System.out.println(cheater.getObject("reverse"));//lots of permutations
			
			
		} catch(FileNotFoundException e) {
			System.out.println("There is no such file");
		}
		

	}
}
