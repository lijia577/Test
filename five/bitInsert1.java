import java.util.*;

//Given a 32 bits number, and i, and j, and a number that can be contained in i,j for example:
// Input = 1000 0000 , num = 101, i = 2, j = 4, output: 1001 0100 
// we assume that i<=j, num can be fit into the range [i,j]


class bitInsert1{
	private int a;
	
	public bitInsert1(int num){
		this.a =num; 
	}

	public void paste(int i, int j, int num){
		//clear the bits from i to j.
		this.clearBits(i,j);
		
		//set the bits starting from i.
		int mask = num<<i;
		
		this.a = this.a|mask;	
	}
	

	private void clearBits(int i, int j){
		//without ~,  this is 111 for the example you have above. ~ flips all bits. And shift it 
		int mask = ~(((int)Math.pow(2,(j-i)+1)-1)<<i);
		this.a = this.a & mask;
	}

	public void print(){
		System.out.println(this.a);
	}
	
	
	private boolean test(int n){
		int mask = 1<<n;
		return ((this.a&mask)>0)? true:false;
	}

	// How to output a number in bits? Simply test each bits and output accordingly. 
	public void printBit(){
		for(int i = 31; i>=0; i--){
			if(this.test(i))System.out.print(1);
			else System.out.print(0);		
		}	
		System.out.println("");
	}

	public static void main(String args[]){
		bitInsert1 ins = new bitInsert1(45);
		ins.printBit();
		ins.paste(2,4,5);
		ins.printBit();
		ins.print(); //53	
	}

}
