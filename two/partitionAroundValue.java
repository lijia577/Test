import java.util.*;

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
		//The idea is to build two list, one small, one large. Finally, merge them.
		ListNode sh = null, lh = null, st = null, lt = null;	
		while(h!=null){
			if(h.data<value){
				if(sh == null){
					sh = h;
					st = sh;
				}else{
					st = h;
					st = st.next;
				}
			}else{
				if(lh == null){
					lh = h;
					lh.next = lt;
				}else{
					lt = h;
					lt.next = null;
					lt = lt.next;
				}
			}

			h = h.next;
		}
		//if the small list is empty, return the larget list.
		if(sh==null){
			return lh;
		}else{	
			//merget two list head to tail.
			st = lh;
			//this is very import, you need to clear up the tail of the large list to be null.
			
			//return the small list head.
			return sh;
		}
	}
	

	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(3);
		ListNode f = new ListNode(3);
		
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
