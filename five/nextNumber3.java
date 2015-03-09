import java.util.*;


//Given a integer n, return the next larger number with the same 1 bits. For example, 5 = 101. Then next larger number is 6 = 110, 
//Similarily, return the next smaller number with the same 1bits. e.g. 5 = 101, 3=011;
class nextNumber3{
	int num;

	public nextNumber3(int num){
		this.num = num;
	}	

	//return true if n pos is 1. 
	private boolean test(int n){
		int mask = 1<<n;
		return (this.num&mask)>0? true: false;
	}	

	//get the first occurance of 1 in the bit, starting from the least significant bit
	private int getM(){
		int i = 0;
		while(!this.test(i)) i++;
		return i;
	}

	private void clear(int n){
		int mask = ~(1<<n);
		this.num = this.num&mask;
	}

	private void set(int n){
		int mask = 1<<n;
		this.num = this.num|mask;
	}

	public int getNextLarge(){
		if(this.num==0) return Integer.MAX_VALUE;
		
		int m = this.getM();
		System.out.println("m " + m);
		//if pos m+1 is not a 1. 
		if(!this.test(m+1)){
			System.out.println("after m here");
			//clear the m bit
			this.clear(m); 
			//set the m+1 bit.
			this.set(m+1); 
		}else{
		
			int x = m+1;
			while(this.test(x)){
				x++;
				if(x>7){return Integer.MAX_VALUE;}//we are out of bound here
			}
			//now x is pointing to a zero. 
			//clear m+1
			this.clear(x-1);
			//set the bit at nth position to be 1
			this.set(x);
		 	
			//now you need to shift m to a zero spot as right as possible.
			if(m!=0){
				while(m<x-1){
					this.clear(m);
					int y = m-1;
					while(y>=0 && this.test(y)==false){
						y--;
					}
					y++;	
					this.set(y);
					m++;
				}
			}

		}
		return this.num;
	}
	
	public int getNextSmall(){
		if(this.num<=3) return Integer.MAX_VALUE;
		
		int m = this.getM(); //first occurance of 1.
		if(m>0){ //simple case
			this.clear(m);
			this.set(m-1);
		}else{
			//after you got the first m, you need to find a zero, then another 1. 
			int n = m+1;
			while(this.test(n)){
				n++;
				m++;
				if(n>7) return Integer.MAX_VALUE;
			}
			//now at pos n, it must be a 0. At pos m, it must be a 1.
			//means this is a zero
			while(!this.test(n)){
				n++;
				if(n>7) return Integer.MAX_VALUE;
			}
			//now at pos n, this must be a one. 
		
			this.clear(n);
			this.set(n-1);

			if(n-2==m){
			// m and n are adjacent to each other. 
				return this.num;
			}else{
				//you are trying to make the remaining 1s one the right of the center 0 to be as large as possible. Shift them
				while(m>=0){
					this.clear(m--);
					this.set(n-2);
					n--;
				}
			}
		}
		return this.num;
	}
	
	public static void main(String args[]){
		nextNumber3 ins= new nextNumber3(6);
		System.out.println(ins.getNextLarge());	
		ins = new nextNumber3(11);
		System.out.println(ins.getNextLarge());
		ins = new nextNumber3(23);
		System.out.println(ins.getNextLarge());
		ins = new nextNumber3(24);
		System.out.println(ins.getNextLarge());
		ins = new nextNumber3(46);
		System.out.println(ins.getNextLarge());
		ins = new nextNumber3(44);
		System.out.println(ins.getNextLarge());

		System.out.println("--------------------");

		ins = new nextNumber3(5);
		System.out.println(ins.getNextSmall());	
		ins = new nextNumber3( 9);
		System.out.println(ins.getNextSmall());
		ins = new nextNumber3(13);
		System.out.println(ins.getNextSmall());
		ins = new nextNumber3(27);
		System.out.println(ins.getNextSmall());
		ins = new nextNumber3(33);
		System.out.println(ins.getNextSmall());
		ins = new nextNumber3(51);
		System.out.println(ins.getNextSmall());
		ins = new nextNumber3(49);
		System.out.println(ins.getNextSmall());
		ins = new nextNumber3(23);
		System.out.println(ins.getNextSmall());
		
		
	}


} 


