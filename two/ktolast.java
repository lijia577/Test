import java.util.*;

class ListNode{
	int data;
	ListNode next;
	
	ListNode(int data){
		this.data = data;
		this.next = null;
	}
}


public class ktolast{
	public ListNode kthLast(ListNode head, int k){
		ListNode p = head;
		for(int i = k; i>0; i--){
			if(p==null) return null;
			p = p.next;
		}

		while(p!=null){
			p= p.next;
			head = head.next;
		}
		return head;
	}

	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		ktolast inst = new ktolast();
		System.out.println(inst.kthLast(a,2).data);
		System.out.println(inst.kthLast(a,3).data);
		System.out.println(inst.kthLast(a,4).data);
	}

}
