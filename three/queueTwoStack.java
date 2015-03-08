import java.util.*;

//Implement a queue using two stacks, you need to support methods like push(). pop(), and isEmpty();
class queueTwoStack{
	int size;
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public queueTwoStack(){
		this.size = 0;
		this.s1 = new  Stack<Integer>();
		this.s2 = new  Stack<Integer>();
	}

	public void push(int value){
		this.s1.push(value);
		this.size++;
	}

	public int pop(){
		if(this.size ==0) return Integer.MIN_VALUE;
		while(!s1.empty()){
			s2.push(s1.pop());
		}
		int res = s2.pop();
		while(!s2.empty()){
			s1.push(s2.pop());
		}
		this.size--;
		return res;
	}

	public boolean empty(){
		return this.size==0;
	}
	
	public static void main(String args[]){
		queueTwoStack inst = new queueTwoStack();
		
		inst.push(1);
		inst.push(2 );
		inst.push(3);
		inst.push(4);
		inst.push(5);
		
		System.out.println(inst.pop());
		System.out.println(inst.pop());
		System.out.println(inst.pop());
		System.out.println(inst.pop());
		System.out.println(inst.pop());
		System.out.println(inst.pop());
		System.out.println(inst.pop());
		inst.push(10);
		System.out.println(inst.pop());

	}


}
