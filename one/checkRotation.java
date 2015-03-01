import java.util.*;

class checkRotation{
	//check if s1 is a rotation of s2. for example. waterbottle is a rotation of bottlewater.
	public boolean check(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false; //their length has to match to be rotation.
		}

		String tmp = s2 + s2;
		if(this.isSubstring(tmp,s1)){
			return true;
		}else{
		return false;
		}
	}

	public boolean isSubstring(String str, String sub){
		//substring must be smaller than trg. 
		if(sub.length()>str.length()) return false;
		//if the substring is null. Just return true.
		if(sub.length()==0) return true;

		//i is index for str. j is for the substring. pi is aliase of i when in the substring checking loop
		int i = 0, j =0, pi =0 ;
		
		//You don't need to go all the way till the end.
		while(i<(str.length()-sub.length()+1)){
			char c1 = str.charAt(i);
			char c2 = sub.charAt(j);
			pi = i;

			while(c1 == c2){
				//check if the substring match is complete
				if(j==sub.length()-1) return true;
				
				//increment the sub process: ++pi. pi will never out of bound b/c the first while loop condition.
				c1 = str.charAt(++pi);
				c2 = sub.charAt(++j);
			}
			i++; //subprocess and i are separate world. you increment i.
			j = 0; //reset j.
		}
		return false;
	}




	public static void main(String args[]){
		checkRotation inst = new checkRotation();
		/*System.out.println(inst.isSubstring1("ABCDEF","DEF"));
		System.out.println(inst.isSubstring1("ABCDEF","ABCDEF"));
		System.out.println(inst.isSubstring1("ABC",""));
		System.out.println(inst.isSubstring1("ABCDEFG","CDE"));
		System.out.println(inst.isSubstring1("ABCDEFG","BCDEF"));
		System.out.println(inst.isSubstring1("AC","A"));
		System.out.println(inst.isSubstring1("AB","B"));
		
		System.out.println("-------------------");
		System.out.println(inst.isSubstring1("ABC","CCC"));
		System.out.println(inst.isSubstring1("ABC","AC"));
		System.out.println(inst.isSubstring1("ABC","ABDFC"));
		System.out.println(inst.isSubstring1("ABCDEFG","ABD"));
		System.out.println(inst.isSubstring1("ABCDEFG","FGE"));
		System.out.println(inst.isSubstring1("","ABDFC"));
		System.out.println(inst.isSubstring1("ADFDFDSBC","ASDFEFEBC"));
		System.out.println(inst.isSubstring1("ADFBC","ABC"));
		System.out.println(inst.isSubstring1("ABC","M"));
		System.out.println(inst.isSubstring1("helloworld","lE"));
		System.out.println(inst.isSubstring1("helloworld","hello0"));
		System.out.println(inst.isSubstring1("helloworld","Sworld"));
		System.out.println(inst.isSubstring1("helloworld","le"));
	
*/
		System.out.println("-------------------");
		System.out.println(inst.check("waterbottle","bottlewater"));
		System.out.println(inst.check("toshiba","batoshi"));
		System.out.println(inst.check("helloworld","ldhellowor"));
		
		System.out.println(inst.check("watedrbottle","bottlewater"));
		System.out.println(inst.check("waterbolett","bottlewater"));
		System.out.println(inst.check("watedfdrbotdftle","bottlewater"));
		
				
	}

}
