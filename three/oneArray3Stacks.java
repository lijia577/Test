import java.util.*;
/*
This one is not conceptually hard but requires you to carefully design and proceed
*/
class myStack{
	int capacity;
	int size;
	int i1;
	int i2;
	int i3;
	int a[];
	
	public myStack(int initSize){
		this.capacity =initSize;
		this.size = 0;
		this.i1 = 0;
		this.i2 = initSize/3;
		this.i3 = initSize-1;
		this.a = new int[initSize];
	}

	public boolean isEmpty(int index){
		if(index ==1){
			return this.i1==0;
		}else if(index == 2){
			return this.i2== this.capacity/3;
		}else if(index == 3){
			return this.i3 == this.capacity-1;
		}else{
			System.out.println("Index not valid exception");
			return false;
		}
	}

	public void capacityCheck(){
		if(this.i1+1==this.i2 || this.i2+1==this.i3){
			int newSize = this.capacity*2;
			int tmp[] = new int[newSize];
			int i = 0, start = 0;
			for(i = 0; i<=this.i1; i++){
				tmp[start++] = this.a[i];
			}
			this.i1 = start-1;

			start = newSize/3;
			for(i=this.capacity/3; i<=this.i2; i++){
				tmp[start++] = this.a[i];
			}
			this.i2 = start-1;
	
			start = newSize-1;
			for(i = this.capacity -1; i>=this.i3; i--){
				tmp[start--] = this.a[i];
			}
			this.i3 = start+1;
	
			this.capacity = newSize;		
			this.a = tmp;
		}
	}

	public void push (int index, int value){
		this.capacityCheck();
		if(index == 1){
			this.a[i1++] = value;
		}else if(index ==2){
			this.a[i2++] = value;
		}else if(index ==3){
			this.a[i3--] = value;
		}else{
			System.out.println("Index not valid exception");
		}
		this.size++;
	}

	public int pop(int index){
		if(this.isEmpty(index))	{
			System.out.println("Index not valid exception");
			return -999;
		}
		this.size--;
		if(index == 1){
			return this.a[--this.i1];
		}else if(index ==2){
			return this.a[--this.i2];
		}else if(index ==3){
			return this.a[++this.i3];
		}else{
			System.out.println("Index not valid exception");
			return -999;
		}
	}

	public void print(){
		for(int i = 0; i<this.capacity; i++){
			System.out.print(this.a[i]+ " ");
		}
		System.out.println("");
	}
}

class OneArray3Stacks{
	public static void main(String args[]){
		myStack a = new myStack(8);
		a.print();
		a.push(1,5);
		a.print();
		a.push(1,4);
		a.print();
		a.push(2,3);
		a.print();
		a.print();
		a.push(3,8);
		a.push(3,8);
		a.push(3,8);
		a.push(3,8);
		a.push(3,8);
		a.push(3,8);
	
	
		System.out.println(a.pop(1));
		System.out.println(a.pop(1));
		a.push(1,5);
		a.push(1,5);
		a.push(1,5);
		a.print();

	}

}
