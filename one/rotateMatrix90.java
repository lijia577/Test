import java.util.*;

class rotateMatrix{
	public void rotate(int m[][], int N){
		int layer, start, end, i,tmp;
		for(layer=0; layer<N/2; layer++){
			start = layer;
			end = N-1-layer;
			for( i = start; i< end ; i++){
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
