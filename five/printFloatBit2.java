import java.util.*;

//Output the bit representation of a float number between (0,1). For example, 0.75 = 0.5*1 + 0.25*1 + 0.125* 0 +.... So, 0.75=11, similarily, 0.625 = 101
class printFloatBit{
	private double num;
	
	public printFloatBit(double  n){
		this.num = n;
	}

	//This is a very counter-intuitive way to do this. if you have 0.625, then do 0.625*2, = 1.25 .Check 1.25 >1, append 1. You got 0.25 now, 0.25*2 = 0.5 < 1; append 0. You got 0.5 now, *2 = 1>=1,
	//Append 1 now, you got 0 now, exit.
	public String print(){
		if(this.num>1 || this.num<0) return "Error";
		
		StringBuilder res = new StringBuilder();
		while(this.num>0){
			if(res.length()>32) return "Error!";
	
			double t = this.num*2;
			if(t>=1){	
				res.append(1);
				t = t-1;
			}else{
				res.append(0);
			}
			this.num = t;
		}
		return res.toString();
	}	

	public static void main(String args[]){
		printFloatBit ins = new printFloatBit(0.625);
		
		System.out.println(ins.print());

	}

}
