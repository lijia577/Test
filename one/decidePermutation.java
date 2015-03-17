import java.util.*;

class decidePermutation{
	public boolean isPerm(String a, String b){
		int la = a.length();
		int lb = b.length();
		//if length a and length b is not the same, this is not permu
		if(la != lb) return false;
		//else we sort both string and check 1 after 1
		char arr1[] = a.toCharArray();
		char arr2[] = b.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i = 0; i<lb; i++){
			if (arr1[i]!=arr2[i]) return false;
		}
		return true;
	}
	
	//Implement a lookup array, use char as index and save the number of letters in it. Then use to check if the second array has the save letter. If a,b have same length but not anagram. You will get lookup array item < 0 eventually. 
	public boolean isPerm2(String a, String b){
		int la = a.length();
		int lb = b.length();
		if(la != lb) return false;
		// we assume the char set is ASCII and use this to remember
		int arr[] = new int[256];
		for(int i = 0; i<a.length(); i++){
			int tmp = a.charAt(i)-0;
			System.out.println(tmp);
			arr[tmp]++;
		}		
		for(int i = 0; i<b.length(); i++){
			int tmp = a.charAt(i)-0;
			arr[tmp]--;
			if(arr[tmp]==-1) return false;
		}
		return true;
		
	}
		

	public static void main(String args[]){
		decidePermutation x = new decidePermutation();
		System.out.println(x.isPerm2("mwerty","ytrewq"));	
		System.out.println(x.isPerm2("abc","cab"));
		System.out.println(x.isPerm2("cabr","burn"));
	}
	
}
