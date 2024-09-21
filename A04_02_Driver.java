import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class A04_02_Driver {
	
	public static void testStack(String type, String word){
		CharStack Stk = new CharStack(type);
		char[] collection = word.toCharArray();
		//char[] collection = {'w','o','r','d'};
		System.out.println("Generating stack from character collection: '" + String.valueOf(collection) + "'...");
		for(Character c : collection) {
			Stk.Push(c);
		}
		
		CharStack.isPalindrome(String.valueOf(collection), type);
		
		System.out.println("\nIs it a palindrome? Let's see..." + CharStack.isPalindrome(String.valueOf(collection), type) + " !\n");
		
		System.out.println("Peeking at the top of the stack...");
		System.out.println(Stk.Peek());
		
		System.out.println("Length: " + Stk.size());
		System.out.println("Is it empty? : " + Stk.isEmpty());
		
		System.out.println("Popping one at a time...");
		

		for(int i = 0; i < collection.length; i++) {
			//System.out.println(String.valueOf(i));
			//System.out.println(c);
			System.out.println(Stk.Pop());
		}
		System.out.println("NOW it should be empty... : " + Stk.isEmpty());

		System.out.println("What happens if we try to pop too many?");
		try {
			Stk.Pop();
			System.out.println("For some reason it worked?");
		}
		catch(Exception e){
			System.out.println("Turns out we have an error...");
			System.out.println(e);
		}
	}
	
	public static void fillQueue(IntQueue Q, int limit){
		int[] numsToQueue = IntStream.range(1, limit+1).toArray();
		System.out.println("The queue will look like this: " + Arrays.toString(numsToQueue));
		for(Integer n : numsToQueue) {
			Q.enQueue(n);
		}

	}
	
	public static void testQueue(String type, Integer limit) {
		IntQueue Q = new IntQueue("ArrayList", limit);
		System.out.println("Starting a queue with a capcity of: "+String.valueOf(limit));
		fillQueue(Q, limit);
		System.out.println("Is it full? Let's see..." + Q.isFull() + " !");
		System.out.println("OK, let's move the line along now...");
		for(int i = 0; i < limit; i++) {
			System.out.println(String.valueOf(Q.deQueue()));
		}
		
		System.out.println("Is it empty? Let's see... " + Q.isEmpty() + " !");
	}
	
	public static void Task7(int limit) {
		IntQueue Q = new IntQueue("LinkedList", limit);
		fillQueue(Q, limit);
		
		Stack<Integer> C = new Stack<Integer>();
		
		for(int X = 0; X < limit; X++) {
			C.push(Q.deQueue());
		}
		for(int X = 0; X < limit; X++) {
			Q.enQueue(C.pop());;
		}
		
		System.out.println("Ok, now Q is reversed..." + Q.struct.toString());
	}
	
	public static void Task8(Integer N) {
		System.out.println("We are going to reverse the order of the Integer provided: " + String.valueOf(N));
		LinkedList<Integer> LL = new LinkedList<>();
		Integer tenth;
		while(N > 0) {
			tenth = N % 10;
			LL.add(tenth);
			N = (N - tenth) / 10;
		}
		System.out.println("Here's what we get: " + LL.toString());
	}

	public static void main(String[] args){
		testStack("ArrayList", "Madam, I'm Adam");
		testStack("LinkedList", "not a palindrome");
		System.out.println("\n\nOK, let's test queues now...\n");
		testQueue("ArrayList", 10);
		testQueue("LinkedList", 5);
		System.out.println("\n\nTime for a game of reversal...\n");
		Task7(7);
		Task8(2349);
	}
}
