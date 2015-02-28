import java.util.*;
//Reverse a c style string. 
class reverseString{
	public String reverse(String s){
		int m = 0;
		int n = s.length()-1;
		StringBuilder ss = new StringBuilder(s);
		while(m!=n){
			ss.setCharAt(m,s.charAt(n));
			ss.setCharAt(n,s.charAt(m));
			m++;
			n--;
		}
		//System.out.println(ss);
		return ss.toString();
	}

	public static void main(String args[]){
		reverseString a = new reverseString();
		String res = a.reverse("123456789");
		System.out.println(res);
	}

}
