import java.util.*;
/*
I have solved this before but I still find it difficult to get the indices right and everthing. Of course you can't remember the code.
But the approach will help. 

1. Draw a 6x6 matrix and fill in number 1-6 on every row. 
2. Assume that you rotate layer by layer, then you can write out:
	N = 6  
	layer = 0:   start [0,    ==> layer
		     end      5)  ==> N-1
	
	layer = 1:   start [1,    ==> layer
		     end      4)  ==> N-1-layer
	
	layer = 2:   start [2,    ==> layer
		     end      3)  ==> N-1-layer
	
	Now you've figured the range of layer[0,N/2], within each layer, start = layer, end = N-1-layer

3. Of course you have to run for start to end on each layer. Use i as your iterator. Figure out how does the rotation work.
	First, you choose  layer =1 , start = 1, i =2, end = 4. So your first spot you have is point(1,2). You might be able to guess most 
		of the relationships correct. 
	Then,  you choose layer 2, start = 2, i = 2, end =3. You will see that some of the indices relationship was wrong. 
		
	Finally, modify the rotation step.	

*/
class rotateMatrix{
	public void rotate(int m[][], int N){
		int layer, start, end, i,tmp;
		//from step 2 above.
		for(layer=0; layer<N/2; layer++){
			start = layer; //from step 2
			end = N-1-layer; //from step 2 
			for( i = start; i< end ; i++){
				//from step 3. Make sure that you double check the relationships. 
				tmp                   = m[start][i];
				m[start][i]           = m[i][end];
				m[i][end]             = m[end][end-i+start];
				m[end][end-i+start]   = m[end-i+start][start];
				m[end-i+start][start] = tmp;
			}
		}
	}
	
	public static void main(String args[]){
		int a[][]={{1,2,3,4},
			     {5,6,7,8},
			     {9,10,11,12},
		             {13,14,15,16}};
		
		rotateMatrix ins = new rotateMatrix();
		ins.rotate(a,4);
		int i = 0, j = 0;
		for(i=0;i<4; i++){
			for(j=0;j<4;j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}	
			
		
}
