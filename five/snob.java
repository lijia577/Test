import java.util.*;

class snob{

	public int snoob(int x){
		int rightOne = 0;
		int nextHigherOneBit = 0;
		int rightOnesPattern = 0;
	
		int next = 0;
		if(x!=0){
			//retrieves the right most one.
			rightOne = x&(-x);

			
			nextHigherOneBit = x+rightOne;
			
			rightOnesPattern = x^nextHigherOneBit;

			rightOnesPattern = (rightOnesPattern)/rightOne;
			rightOnesPattern = rightOnesPattern>>2;

			next = nextHigherOneBit|rightOnesPattern;
		}
		return next;

	}

	public static void main(String args[]){
		int x= 46;
		snob inst = new snob();
		System.out.println(inst.snoob(x));
	}

}
