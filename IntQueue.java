import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntQueue{
	Integer limit;
	String type;
	public List<Integer> struct;
	public int index = -1;
	
	public IntQueue(String type, Integer limit) {
		this.type = type;
		this.limit = limit;
		
		if(type == "ArrayList") {
			struct = new ArrayList<Integer>();
		}
		if(type == "LinkedList") {
			struct = new LinkedList<Integer>();
		}
	}
	
	public void enQueue(Integer x) {
		this.struct.add(x);
		index ++;
	}
	
	public int deQueue() throws ArrayIndexOutOfBoundsException{
		if(this.index >= 0) {
			Integer last = this.struct.get(0);
			this.struct.remove(0);
			index --;
			return last;			
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Nothing left to dequeue.");
		}

	}
	
	public boolean isEmpty() {
		return index < 0;
	}
	
	public boolean isFull() {
		return index+1 == limit;
	}
	
	public int size() {
		return this.struct.size();
	}
}
