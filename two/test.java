import java.util.*;

class ListNode {
	int data;
	ListNode next;

	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}

class test{
	public void reverse(ListNode a){
		ListNode res = null;
		reverse(a);
	}
	public void reverseHelper(ListNode h, ListNode res){
		if(h.next == null){
			res = h;
			return;
		}
		reverseHelper(h.next,res);
		h.next = null;
		res.next = h;	
			
	}

	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		//ListNode c = new ListNode(3);
		a.next =b ;
		//b.next =c ;

		ListNode res = null;
		test inst = new test();
		inst.reverseHelper(a,res);
	
		while(res!=null){
			System.out.println(res.data);
			res = res.next;
		}
	}

}
