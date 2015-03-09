import java.util.*;

//Count the number of bit-flip required to convert a to b. e.g. a = 1011 b=0011. output = 1.

class countBit5{
	public static int getCount(int a, int b){
		int res = 0;
		int xor = a^b; //1000 in the above example.
		while(xor!=0){
			/* Method 1:	
			   res += xor&1;
			   xor = xor>>1;
			*/
			
			//method 2.
			res++;
			xor = xor&(xor-1); //clear the least significant bit in xor
		}
		return res;
	}

	public static void main(String args[]){
		System.out.println(getCount(31,14));//2
	}
}
