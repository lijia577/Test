import java.util.*;

class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}

}

class deleteSingleNode{
	public void delete(ListNode head, ListNode m){
		while(head.next!=m){
		
			head = head.next;
		}
		head.next = head.next.next;
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

		deleteSingleNode inst = new deleteSingleNode();
		inst.delete(a,e);
		
		while(a!=null){
			System.out.println(a.data);
			a = a.next;
		}
	}
}
