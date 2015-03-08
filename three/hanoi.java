import java.util.*;


class Tower{
	String name;
	Stack<Integer> pole;

	public Tower(String name){
		this.name = name;
		this.pole = new Stack<Integer>();
	}

}

class hanoi{
	//The following function solves the hanoi problem, with n be the number of disks on the src stack 
	//Think about the case for 3 disks. You are first move the top disk to the buffer zone. Then somehow, you move the rest two buttom to the destination
	//Finally, you move the tile on the buf zone to the destination. That's it.
	public void solve(Tower src, Tower buf, Tower des, int n){
		if(n==0) return;
		this.solve(src,des,buf,n-1);
		System.out.println("Move the disk from " + src.name + " to " + des.name);
		des.pole.push(src.pole.pop());
		this.solve(buf,src,des,n-1);
	}

	
	public static void main(String args[]){
		hanoi h = new hanoi();

		Tower a  = new Tower("A");
		Tower b  = new Tower("B");
		Tower c  = new Tower("C");

		a.pole.push(3);
		a.pole.push(2);
		a.pole.push(1);
		
		System.out.println(a);
		
		h.solve(a,b,c,3);
			
		System.out.println(c.pole.pop());
		System.out.println(c.pole.pop());
		System.out.println(c.pole.pop());
	}


}
