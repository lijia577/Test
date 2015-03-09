import java.util.*;

class swapOddEvenBit{
	public static int swap(int a){
		//        10101010...         01010101...    
		return (a&0xAAAAAAAA)>>1|(a&0x55555555)<<1;
//use mask to keep the even, rigth shift | masked odds, left shift. Of course, use or operation to add them up.     
	}

	public static void main(String args[]){
		System.out.println(swap(11));//7
	}
}
