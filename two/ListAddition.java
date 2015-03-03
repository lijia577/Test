import java.util.*;

class ListNode{
	int data;
	ListNode next;

	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}
/*
Use a head and tail variable in a singly linked list. Keep the head fixed but keep moving the tails for appending items.
*/
class ListAddition{
	public ListNode add(ListNode a, ListNode b){
		int carry = 0;
		ListNode tail = null;   //start with null tail and head
		ListNode head  = null;
		
		while(a!=null || b!=null){ //this takes care of how one list is longer than the other. 
			int tmp = carry;    //tmp value starts with carry
			if(a!=null){
				tmp += a.data;   //add a.data into tmp along the way.
			}
			if(b!=null){
				tmp += b.data;	 //add b.data into tmp 
			}
			carry = tmp/10; //get the carry for the next round. 
			tmp = tmp%10;   // tmp value must be smaller than 10
			if(head==null){ //happens only once at beginning where the head list has not been filled in yet.
				head = new ListNode(tmp);
				tail = head;
			}else{
				tail.next = new ListNode(tmp); //append at the end of tail.
				tail = tail.next;		//adjust the position of tail.
			}
			a = a.next;
			b = b.next;
		}
		//check if there are any final carry. 
		if(carry>0){
			tail.next = new ListNode(carry);
			tail = tail.next;	
		}
		return head;
	}

	public static void main(String args[]){
		ListNode a = new ListNode(9);
		ListNode b = new ListNode(9);
		a.next = b;

		ListNode c = new ListNode(9);
		ListNode d = new ListNode(9);
		c.next = d;
	
		ListAddition inst = new ListAddition();
		ListNode res = inst.add(a,c);
		
		while(res!=null){
			System.out.println(res.data);
			res = res.next;
		}	
	}
}
