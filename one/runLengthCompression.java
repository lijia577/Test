import java.util.*;
//This is to do a run length compression. However, return the original string is longer after compression. 
//If you are not allowed to StringBuilder, you can use char array. Which is the same thing.
class runLengthCompression{
	public String compress(String s){
		//String is immutable so you should use StringBuilder.
		StringBuilder res = new StringBuilder();
		int i=0;
		char tmp;
		int sum;
		while(i< s.length()){
			tmp = s.charAt(i);
			res.append(tmp);//string builder can append strs or chars at the end. It is mutable. 
			sum = 1;
			//check if out of bound and next is the same with tmp
			while(i+1<s.length()&&s.charAt(i+1)==tmp){
				sum++;
				i++;
			}
			//after comparison you need to proceed. 
		        i++;
			res.append(sum);
		}
		
		if(res.length() > s.length()) return s;
		else return res.toString();
	}
	
	
	//This is run length without using string builder. This version uses a char array instead. 	
	public String compress2(String s){
		//First you need to decide if it is desirable to compress because size might increase after compression
		int size = canCompress(s);
		System.out.println(size); 
		if(this.canCompress(s)<0) return s;
		
		//this is the char arr you use to save result.
		char arr[] = new char[size];
		//Use i to track position in s. Use pos to track arr index. 
		int i=0,pos = 0;
		while(i<s.length()){
			char cur = s.charAt(i);
			int count =1;
			while( i+1<s.length() && s.charAt(i+1)==cur){
				count++;
				i++;
			}
			//now you got a char 'x' and its count, append to res char array.
			arr[pos++]=cur;
			//convert a number into a string. 
			String t = String.valueOf(count);
			for( char x: t.toCharArray()){
				arr[pos++] = x;
			}
			//you need to increase i to advance!!.	
			i++;
		}
		//pad the end of the string symbol at the end of the array. 
		return new String(arr);
	}

	public int canCompress(String s){
		int total = 0, count = 0, i = 0;
		while(i<s.length()){
			char tmp = s.charAt(i);
			count = 1;
			while(((i+1)<s.length()) && (s.charAt(i+1)==tmp)){
				count++;
				i++;
			}
			i++;
			total += (1+this.getDigit(count));
		}
		if(s.length()<=total){
			return -1;
		}
		return total;
	}

	private int getDigit(int num)
		return String.valueOf(num).length();
	}

	public static void main(String args[]){
		runLengthCompression a = new runLengthCompression();
		String res  = a.compress2("aabbaaaabbbb");
		System.out.println(res);
		res = a.compress2("1234567");
		System.out.println(res);
	}
}
