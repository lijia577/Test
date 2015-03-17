import java.util.*;
//Given a list and a node, move all the elements smaller than the node before the node, move all the elements >= the node after it. 
class ListNode{
	int data;
	ListNode next;
		
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}

}

class partitionAroundValue{
	public ListNode partition(ListNode h, int value){
		if(h==null) return null;
		
		//The idea is to build two list, one small, one large. Finally, merge them.
		ListNode sh = null, lh = null, st = null, lt = null;	
		
		while(h!=null){
			if(h.data<value){
				//if the small list is empty.head and tail of small list should pointing to the same head. 
				if(sh == null){
					sh = h;
					st = h;
				//if the small lsit is not empty. tail.next should point to h. But also adjust tail at the same time. 
				}else{
					st.next = h;
					st = st.next;
				}
			//the process of large list is the same.
			}else{
				if(lh == null){
					lh = h;
					lt = h;
				}else{
					lt.next = h;
					lt = lt.next;
				}
			}
			h = h.next;
		}
		//if the small list is empty, return the larget list.
		if(st==null){
			return lh;
		//if the large list empty, return the small list. 
		}else if(lt==null){
			return sh;
		//if both small and large exist, merge them together and return 
		}else{	
			//merget two list head to tail.
			st.next = lh;
			//this is very import, you need to clear up the tail of the large list to be null.
			lt.next = null;
			//return the small list head.
			return sh;
		}
	}
	

	public static void main(String args[]){
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(5);
		ListNode e = new ListNode(7);
		ListNode f = new ListNode(1);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;


		partitionAroundValue inst = new partitionAroundValue();
		ListNode res = inst.partition(a,4);

		while(res!=null){
			System.out.println(res.data);
			res = res.next;
		}
	}

}
