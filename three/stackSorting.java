import java.util.*;

//Use one additonal stack to sort a stack s in ascending order, the number at the top is the smallest. 
class stackSorting{
	public Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> t = new Stack<Integer>();
		
		while(!s.empty()){
			if(t.empty()||t.peek()<=s.peek()) t.push(s.pop()); //everything is okay so far the original stack is in order
			
			//things went wrong, push back.
			int tmp = s.pop();
			
			//if the tmp is smaller than t.peek(), keep moving from t to s. Draw a graph and see.
			while(!t.empty()&&tmp<t.peek()) s.push(t.pop());
			
			t.push(tmp);
		}

		return t;	
	}

	public static void main(String args[]){
		stackSorting inst = new stackSorting();
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(4);
		s.push(5);
		s.push(3);
		s.push(2);
		
	
		System.out.println(inst.sort(s));
	}

}
