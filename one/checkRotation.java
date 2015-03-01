import java.util.*;

class checkRotation{
	public boolean check(String s1, String s2){
		return false;
	}

	public boolean isSubstring(String trg, String src){
		//substring must be smaller than trg. 
		if(src.length()>trg.length()) return false;
		int i = 0, j =0, pi =0 ;
		while(i<trg.length()){
			char c1 = trg.charAt(i);
			char c2 = src.charAt(j);
			System.out.println("Compare " + c1 +" , " +  c2 + " i: " + i);
			pi = i;
			while(c1 == c2){
				System.out.println("C1 and C2 are the same ");   
				if(src.length()-j==1) return true;
				pi++;
				j++;
				if(pi>trg.length()) return false;
				c1 = trg.charAt(pi);
				c2 = trg.charAt(j);
				System.out.println("In loop " + c1 + " , " + c2);
			}
			System.out.println("They are not the same");
			i++;
			j = 0;
		}
		return false;
	}

	public static void main(String args[]){
		checkRotation inst = new checkRotation();
		System.out.println(inst.isSubstring("ABC","BC"));
		System.out.println(inst.isSubstring("helloworld","l"));
		System.out.println(inst.isSubstring("helloworld","hello"));
		System.out.println(inst.isSubstring("helloworld","world"));
		System.out.println(inst.isSubstring("helloworld","le"));
		
	}

}
