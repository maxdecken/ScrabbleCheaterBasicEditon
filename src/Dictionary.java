import java.util.ArrayList;

public class Dictionary implements HashTable<String> {

	final int HASH_MULTIPLIER = 31;
	private Node[] hashTable;
	
	
	public static void main(String[] args) {
		Dictionary d = new Dictionary();
		String test = "Hallo";
		String s = d.generatePermutation(test);
		System.out.println(s);
		
		d.addObject("Hallo1");
		d.addObject("1ahllo");
		d.addObject("hLL1ao");
		System.out.println(d.getObject("Hallo1"));
	}
	public Dictionary() {
		hashTable = new Node[100];
	}
	
	@Override
	public long generateHashCode(String object) {
		object = generatePermutation(object);
		long h = 0;
		for (int i = 0; i < object.length(); i++) {
		   h = HASH_MULTIPLIER * h + object.charAt(i);
		}
		return h;
	}
	@Override
	public void addObject(String data) {
		long i = generateHashCode(data);
		int countChain = 0;
		Node newNode = new Node(data);
		if(hashTable[(int)(i% hashTable.length)] == null) {
			hashTable[(int)(i% hashTable.length)] = newNode;
		} 
		else {
			Node n = hashTable[(int)(i% hashTable.length)];
			countChain = countChain +1;
			while(n.next != null) {
				n = n.next;
				countChain = countChain +1;
			}
			n.next = newNode;
			newNode.previous = n;
		}
		if(countChain > 15) {
			resizeHashTable();
		}
		
	}
	
	private void resizeHashTable() {
		Node[] newArray = new Node[hashTable.length*2];
		Node[] oldArray = hashTable;
		hashTable = newArray;
			for(int a = 0; a < oldArray.length; a++) {
			Node n = oldArray[a];
			while (n != null) {
				addObject(n.data);
				n = n.next;
			}
		}
	}
	
	@Override
	public String getObject(String word) {
		long i = generateHashCode(word);
		ArrayList<String> result = new ArrayList<>();
		if(hashTable[(int)(i % hashTable.length)] != null) {
			Node n = hashTable[(int)(i % hashTable.length)];
			if(n.next == null) result.add(n.data);
			while (n != null) {
				result.add(n.data);
				n = n.next;
			}
			
<<<<<<< HEAD
			int foundCount = 0;
			String permutations = "";
			String toReturn ="[";
			for(String s : result) {
				toReturn = toReturn + s + "; ";
				//basically checking if "isPermutation" is true
				if(generatePermutation(s).equals(generatePermutation(word))){
					foundCount++;
					permutations = permutations + "  " + s;
				}
			}
			toReturn = "There are " + foundCount + " permutations of the letter combination " + word + ": \n" + permutations + "\n" + toReturn +"] \n";
			return toReturn;
=======
			String toReturn ="[";
			for(String s : result) {
				toReturn = toReturn + s + "; ";
			}
			return toReturn +"]";
>>>>>>> 8f0ee7e360297621d513266746737b5fcdec796d
		}else {
			return "Nothing found!";
		}
	}
	
	@Override
	public void removeObject(String nodeData) {
		long i = generateHashCode(nodeData);
		boolean found = false;
		Node n = hashTable[(int)(i % hashTable.length)];
		while (!found) {
			if(n.data.equals(nodeData)) {
				n.previous.next = n.next;
				n.next.previous = n.previous;
				found = true;
			}else {
				n = n.next;
			}
		}
	}
	
	private String generatePermutation(String s) {
		String result = "";
		s = s.toLowerCase();
		String[] letters = s.split("");
		
		for(int i = 0; i<letters.length; i++)   //Holds each element
        {  
            for (int j = i+1; j<letters.length; j++)  //Check for remaining elements 
            {  
               //compares each elements of the array to all the remaining elements  
               if(letters[i].compareTo(letters[j])>0)   
               {  
                   //swapping array elements  
                   String temp = letters[i];  
                   letters[i] = letters[j];  
                   letters[j] = temp;  
                }  
             }  
          }
		
		for(int z = 0; z<letters.length; z++) {
			result = result + letters[z];
		}

		return result;
	}
	
	public String getStatus() {
		String status = "Status: \n";
		status = status + "Size of hashTable: " + hashTable.length + "\n";
<<<<<<< HEAD
		status = status + "Amount of words: " + getAmountOfElements() + "\n";
		status = status + "Longest chain: " + getLongestChain() + "\n";
		return status;
	}
	
	public int getAmountOfElements() {
		int count = 0;
		
		for(int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				Node n = hashTable[i];
				while(n != null) {
					n = n.next;
					count++;
				}
			}
		}
		
		return count;
	}
	
=======
		status = status + "Longest chain: " + getLongestChain();
		return status;
	}
	
>>>>>>> 8f0ee7e360297621d513266746737b5fcdec796d
	private int getLongestChain() {
		int longest = 0;
		for(int i = 0; i < hashTable.length; i++) {
			int current = 0;
			if(hashTable[i] != null) {
				Node n = hashTable[i];
				while(n != null) {
					n = n.next;
					current = current +1;
				}
			}
			if(current > longest) longest = current;
		}
		return longest;
	}
	
	public class Node{
		String data;
		Node previous;
		Node next;
		
		public Node(String data) {
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}

}
