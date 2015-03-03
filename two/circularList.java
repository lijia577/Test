import java.util.*;

class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}

class circularList{
	//returns the beginning of the loop.
	public ListNode getLoopStart(ListNode head){
		ListNode a = head, b = head;
		do{	
			a = a.next; //speed = 1 
			b = b.next.next;
		}while(a!=b);
		
		//Now a==b;
		while(head!=a){
			head = head.next;
			a=a.next;
		}

		//now head == a
		return a;
	}

	public static void main(String args[]){
		ListNode o = new ListNode(0);
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		ListNode g = new ListNode(7);
		o.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = c;

		circularList ins=new circularList();
		ListNode res = ins.getLoopStart(o);
		System.out.println(res.data);

	}
	
}
