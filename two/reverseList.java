import java.util.*;

class ListNode {
	int data;
	ListNode next;

	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}

class reverseList{
	//this is how you can reverse a List recursively. 
	public ListNode reverse(ListNode a){
		//base case a is null
		if(a==null) return null;
		//base case a is single element
		if(a.next ==null) return a;
		
		//recursion case: the reverse of n element list, is the reverse of 2nd element, followed by first element

		//this is list[1:]
		ListNode second = a.next;
		//the head is being returned with this.reverse()
		ListNode secondHead = this.reverse(second);
		//because now second is the tail
		second.next = a;
		//you need the following to avoid loop.
		a.next = null;
			
		return secondHead;
	}

	/* An iterative way to reverse a linked list.
	   The algorithm: 
 		Use h to iterate from start to end. The first time, set h.next to null. The next times,
		set h.next to the previous node in the list. You will need two more variables prev and nxt 
		because the links are cutted along the way. But besides that, as long as you had the algorithm
		you will be fine. 	
	*/
		public ListNode iReverse(ListNode h){
		if(h==null) return h;
		//ListNode pv for prevNode in the original list, nxt for next node.
		ListNode pv = null, nxt = h.next;
		while(nxt!=null){
			//set the h.next to the previous node
			h.next = pv;
			pv = h; //update pv
			h = nxt; //update h
			nxt = h.next; //update nxt 
		}	
		//a little touch up on the last iteration. The last node should point to the prev pv.
		h.next = pv;
		return h;
	}

	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		a.next =b ;
		b.next =c ;

		reverseList inst = new reverseList();
		ListNode res = inst.iReverse(a);
	
		while(res!=null){
			System.out.println(res.data);
			res = res.next;
		}
	}

}
