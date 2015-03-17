import java.util.*;
/*
Returns true if the function contains a duplicate. Assume ASCII char set. 
*/
class detectDuplicates{
	public void p(String s){
		System.out.println(s);
	}
	public void p(int num){
		System.out.println(num);
	}
	public boolean checkDup(String str){
		//Using pigeon-hole principle
		if(str.length()>256) return true;
		//set a boolean marker to test if we have met this char before
		boolean marker[] = new boolean[256];
		for(int i = 0 ; i<str.length(); i++){
			//get the number representation of the char at location i
			int num = (int)str.charAt(i);
			if(marker[num]==true){
				return true;
			}
			marker[num] = true;
		}
		//No dups found at the end
		return false;
	}
	
	//The following only works for a-z charset!!
	public boolean checkDup2(String str){
		//use a long as an array. It has 64 bits. But it is signed. 
		long a = 0; 
		//long is 64 bit long in java. So it's enough for 256 charset. 
		for(int i=0; i<str.length(); i++){
			int num = str.charAt(i)-'a';
			//use bit test to see if at location num the value is 1. 
			//You should use '>0' below, why? 
			if((a&(1<<num))>0){
				return true;
			}
			//use bit set to set the location num to have value 1
			a = a|(1<<num);
		}	
		return false;
	}

	public boolean checkDup3(String str){
		//use a long as an array. It has 64 bits. But it is signed. 
		BitSet a = new BitSet(256);
		for(int i=0; i<str.length(); i++){
			int num = str.charAt(i);
			if(a.get(num)){
				return true;
			}
			a.set(num);
		}	
		return false;
	}
	public static void main(String[] args){
		detectDuplicates a = new detectDuplicates();
		String str1 = "1234567890qwertyuioasdfghjkzxcvbnm";
		String str2 = "";
		String str3 = "zxcvbnmdsfghjkertyuio";
		String str4 = "12345678123456";
		String str5 = "xdfghjsd5r4zx";	
		
		if (a.checkDup3(str1)==true){
			System.out.println("There exist dup");
		}else{
			System.out.println("No dup");
		}
		if (a.checkDup3(str2)==true){
			System.out.println("There exist dup");
		}else{
			System.out.println("No dup");
		}
		if (a.checkDup3(str3)==true){
			System.out.println("There exist dup");
		}else{
			System.out.println("No dup");
		}
		if (a.checkDup3(str4)==true){
			System.out.println("There exist dup");
		}else{
			System.out.println("No dup");
		}
		if (a.checkDup3(str5)==true){
			System.out.println("There exist dup");
		}else{
			System.out.println("No dup");
		}
	}

}
