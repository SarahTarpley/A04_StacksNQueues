import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CharStack{
	String type;
	public List<Character> struct;
	String s;
	public int index = -1;
	
	// Construct with either LinkedList or ArrayList
	public CharStack(String type){
		this.type = type;
		if(this.type == "ArrayList") {
			struct = new ArrayList<Character>();
		}
		else if(this.type == "LinkedList") {
			struct = new LinkedList<Character>();
		}
	}

	public void Push(Character x) {
		this.struct.add(x);
		this.index ++;
	}
	
	public Character Pop() throws ArrayIndexOutOfBoundsException{
		if(this.index >= 0) {
			Character x = this.struct.get(this.index);
			this.struct.remove(this.index);
			this.index --;
			//System.out.println(this.isEmpty);
			return x;
		}
		else {
			throw new ArrayIndexOutOfBoundsException("There are no more elements to pop in the stack.");
		}
	}
	
	public Character Peek() {
		Character x = this.struct.get(this.index);
		return x;
	}
	
	public boolean isEmpty() {		
		return this.index < 0;
	}
	
	public int size() {
		return this.struct.size();
	}
	
	public static boolean isPalindrome(String s, String type) {
		// Use the mechanism of stack to reverse the order of the string
		s = s.replaceAll("[\\W|\\s|\\d]", "").toLowerCase();
		//System.out.println(s);
		CharStack reverse = new CharStack(type);
		for(Character c : s.toCharArray()) {
			reverse.Push(c);
		}
		
		for(int i = 0; i < s.length() && !reverse.isEmpty(); i++) {
				//System.out.println("letter: "+reverse.Peek());
				//System.out.println("string letter: "+s.charAt(i));
				if(!Character.valueOf(s.charAt(i)).equals(reverse.Pop())) {
					//System.out.println("Found a bad one: "+Character.valueOf(s.charAt(i)));
					return false;	
			}
		}
		// only make it this far if it hasn't returned with false
		return true;
	}
}
