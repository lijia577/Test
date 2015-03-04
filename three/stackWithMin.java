import java.util.*;

/*
Design a stack with push pop and a min method operates at complexity O(1)
The idea, use two stack. One normal, the other to keep track of min.
*/


class stackWithMin extends Stack<Integer>{
	Stack<Integer> s2;
	
	public stackWithMin(){
		this.s2 = new Stack<Integer>();
	}	
	
	public void push(int a){
		super.push(a);
		if(s2.empty()) s2.push(a);
		else{
		//You must have <= !!!!
			if(a<=s2.peek()){
				s2.push(a);
			}
		}
	}

	public Integer pop(){
		int res = super.pop();
		if(res==s2.peek()){
			s2.pop();
		}
		return new Integer(res);
	}

	public int min(){
		return s2.empty()?Integer.MAX_VALUE:s2.peek();
	}
	

	public static void main(String args[]){
		stackWithMin a = new stackWithMin();
		a.push(2);
		a.push(7);
		a.push(2);
		a.push(4);
		a.push(9);
		a.push(8);

		System.out.println(a.min());
		System.out.println(a.pop());
	
		System.out.println(a.min());
		System.out.println(a.pop());
	
		System.out.println(a.min());
		System.out.println(a.pop());
	
		System.out.println(a.min());
		System.out.println(a.pop());
	
		System.out.println(a.min());
		System.out.println(a.pop());
		
		System.out.println(a.min());
		System.out.println(a.pop());
	}
}
