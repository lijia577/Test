import java.util.*;

//How to get, set, clear a bit. 

class basicBitMan{
	int a;

	public basicBitMan(int data){
		this.a = data;
	}

	public void set(int n){
		int tmp = 1<<n;
		this.a = this.a|tmp;
	}
	
	public void get(int n){
		int mask = 1<<n;
		if((this.a&mask)>0){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
	}

	public void clear(int n){
		int mask = ~(1<<n);
		this.a = this.a&mask;
	}
	
	public void print(){
		System.out.println(this.a);
	}
	
	public static void main(String args[]){
		basicBitMan inst = new basicBitMan(26);
		inst.set(2);
		inst.set(0);
		inst.print(); //31
	
		inst.get(0); //1
		inst.get(1);  //1
		inst.get(2);  //1
		
		inst.clear(3);
		inst.print(); //23
		inst.clear(1); 
		inst.print();//21	
	}
}
