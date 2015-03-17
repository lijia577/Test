import java.util.*;

//Replace all the space in a string with $:), assume there is enough buffer

public class replaceSpace{
	public void replace(char arr[]){
		//make sure you draw an example somewhere to get math and index right
		int al = arr.length; //get the actual length of array.
		int sl = 0; // store the length of non-trivial chars.
		int i, spaceCount = 0,adjlen =0; 
		for(i = 0; i<al; i++){
			if(arr[i]== ' ') spaceCount++;
			if(arr[i]!= '\u0000')sl++;
		}		
		//space*2 because the space itself have length 1 left there.
		adjlen = sl + spaceCount*2;
		arr[adjlen--] = '\u0000';//you fill the last adjlen to be \0
		sl--;//adjust sl from length to index of last char.
		while (sl>=0){ //sl could definitely >= 0. Your first char might be empty
			if(arr[sl]==' '){
				arr[adjlen--] = ')';
				arr[adjlen--] = ':';
				arr[adjlen--] = '$';
				sl--;
			}else{
				arr[adjlen--] = arr[sl--];
			}
		}
	}

	public static void main(String args[]){
		char arr[]= new char[20];
		int i;
		for (i = 0 ; i<arr.length-14; i++){
			if(i%3==0) arr[i] = ' ';
			else arr[i] = (char)(48+i);
		}
		arr[i-1]='\u0000';
		System.out.println(arr);
		System.out.println("-----");	
		replaceSpace a = new replaceSpace();
		a.replace(arr);
		System.out.println(arr);
	}
	
}
