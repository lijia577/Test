import java.util.*;

//implement a set of stacks supporting push, pop and popAt(index), where popAt will re-adjust the stack afterwards.
class stackSet{
	ArrayList<Stack<Integer>> stacksets;
	int pos; //current position
	int maxSize;
	
	public stackSet(int maxSize){
		this.stacksets = new ArrayList<Stack<Integer>>();
		this.pos = 0;
		this.maxSize = maxSize;
	}

	public boolean empty(){
		return this.stacksets.size()==0;
	}

	//returns the end index of the arraylist
	private int endindex(){
		return this.stacksets.size()-1;
	}

	private Stack<Integer> stackAt(int index){
		return this.stacksets.get(index);
	}

	// *** The push method	
	public void push(int value){
		//this.pos always pointing to empty space
		if(this.empty() || this.pos==this.maxSize){
			Stack<Integer> s = new Stack<Integer>();
			s.push(value);
			this.stacksets.add(s);
			this.pos = 0;
		}else{
			Stack<Integer> tmp= this.stackAt(this.endindex());
			tmp.push(value);
			this.stacksets.set(this.endindex(),tmp);
		}	
		this.pos++;	
	}

	// *** The pop method	
	public int pop(){
		if(this.empty()){
			System.out.println("the stack set is empty!");
			return Integer.MAX_VALUE;
		}
		
		Stack<Integer> tmp = this.stackAt(this.endindex());
		int res = tmp.pop();
		this.pos--;
		if(this.pos==0){
			//remove the last stack
			this.pos = this.maxSize;
			this.stacksets.remove(this.endindex());
		}
		return res;
	}

	// *** The popAt method 
	public int popAt(int index){
		if(index > this.endindex()){
			System.out.println("You cannot pop at index "+ index + " out of range");
			return Integer.MAX_VALUE;
		}
	
		//get the pep result first. 
		int res;
		if(index == this.endindex()){
			return this.pop();
		}else{
			Stack<Integer> t = this.stackAt(index);
			res = t.pop();
			this.stacksets.set(index,t);
		}
	
		//now the stack at 'index' have one vacancy there, we move around all others to fill it in. Rollover system. 
		int i = index+1;
		while(i<=this.endindex()){
			Stack<Integer> tmp = this.stackAt(i-1); //the stack with a vacancy
			Stack<Integer> next = this.stackAt(i);  //the next stack of the above stack
			Stack<Integer> holder = new Stack<Integer>(); //tmp holder 
			while(!next.empty()){     //pop all stuff from next to get the buttom
				holder.push(next.pop());
			}	
			tmp.push(holder.pop()); //remember the buttom.
			this.stacksets.set(i-1,tmp); //set the tmp stack now. 
			if(holder.empty()){
				// holder is empty only when we are at the end of the stack sets. This means the last stack contains only one element. 
				this.stacksets.remove(this.endindex()); //remove the last stack since it is empty one. 
				this.pos = this.maxSize;
				return res;
			}else{
				while(!holder.empty()){  //we pull all rest elements in the holder and then proceeds.
					next.push(holder.pop());
				}
				this.stacksets.set(i,next);//set in the arrayList after modifying. 
			}
			i++; 
		}
		this.pos--; //unless you are at the last stack with only one stack case, you need to adjust this.pos-- 
		return res;
	}

	public static void main(String args[]){
		stackSet s = new stackSet(3);
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(0);


		System.out.println(s.popAt(0));
		System.out.println(s.popAt(0));
		System.out.println(s.popAt(1));
		System.out.println(s.popAt(2));
		System.out.println(s.popAt(2));
		System.out.println(s.popAt(1));
		System.out.println(s.popAt(1));
		System.out.println(s.popAt(1));
		
	
	}
}
	
