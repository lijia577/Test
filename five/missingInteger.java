import java.util.*;


//Given an arr, with elements 0,1,2..,n. However, one of the number in the sequence is missing. Find it.
class missingInteger{
	//given a integer n, return true if it's ith bit is set
	public static boolean fetch(int n, int i){
		int mask = 1<<i;
		return (n&mask)>0? true:false;
	}

	public static int find(int arr[], int size){
		int x1 = arr[0], x2 = 0;
		for(int i = 1; i< arr.length; i++){
			x1 = x1^ arr[i];  //taking XOR or all numbers in the arr.
		}
		for(int i = 1; i<=size;  i++){
			x2 = x2^i;     //taking XOR of all numbers from 0 to n, including n. 
		}
		return x1^x2; //taking XOR of two numbers 

	}

	public static void main(String args[]){
		int arr[] = {4,1,2,3,0};
		System.out.println(find(arr,arr.length));	
	}

}
