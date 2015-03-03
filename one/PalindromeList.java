import java.util.*;

/* There are 3 ways to determine if a linked list is a palindrome or not. First create reverse copy and compare
 * Second, use a stack.
 * Third, uses recursion. 
 *
 */

class ListNode{
	int data; 
	ListNode next;
	
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}


class PalindromeList{
	//Using a stack. use two runner to find the middle of the list. 
	public boolean isPalindrome(ListNode h){
		//corner case handling. Makes your life easier.
		if(h==null ||h.next==null) return true;
		//init stack and runner a and b at the head.
		Stack<Integer> s = new Stack<Integer>();
		ListNode a =h, b= h;
		
		//speed of a is 1, speed of b is 2. Behold the condition!! test b.next first
		while(b.next!=null && b.next.next!=null){
			a = a.next;
			b = b.next.next;	
		}	
		
		// !! Depend on the list, you may need to pop the middle node. 
		boolean odd;
		if(b.next!=null)odd = false;  //case len(list) is even
		else odd = true; //case len(list) is odd 
		
		//push into stack
		while(h!=a.next){
			s.push(h.data);
			h = h.next;
		}
		//You need to pop the middle if the len(list) is odd.
		if(odd) s.pop();
	
		//pop and compare, behold the test condtion!!
		while(h!=null && s.empty()==false){
			int tmp = s.pop();
			if(tmp!=h.data) return false;
			h =h.next;
		}
		
		//return, behold the test codition!!!
		if(s.empty()&& h==null) return true;
		else return false;
	}
	
	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(2);	
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		PalindromeList inst = new PalindromeList();	
		System.out.println(inst.isPalindrome(a));

	}
	
}
