import java.util.*;
/*
 *  Remove duplicates from an unsorted linked list
 */
class ListNode {  
    int data;  
    ListNode next;  

    ListNode(int data) {  
        this.data = data; 
	this.next = null;   
    }  
}

public class removeDup {
	//Remove duplicates in this list using a hashtable.
	// Algorithm: init the hashtable. Keep a prev node. Use head to iterate through the list. In each loop, check if the cur node.data is
	// in the table or not. If not, then you go on. head = head->next. prev = head. table book keeping.  If yes. Then you do 
	//head = head.next. and you do  prev.next = head.next. Don't update prev in this case because you may get several duplicates in a row. 
	public void remove(ListNode head){
		Hashtable<Integer,Boolean> t = new Hashtable<Integer, Boolean>();
		ListNode prev = null;
		while(head!=null){
			if (t.containsKey(head.data)){
				prev.next = head.next;
				head = head.next;
			}else{
				t.put(head.data,true);
				prev = head;
				head = head.next;	
			}

		}
	}
	
	/*
	Removes dups in a linked list without using any kind of buffers. The algorithm:
	Use cur node to iterate through the array. For every step in the iteration process. Use a runner node. To go and remove the dups with 
	respect to the cur at that moment. 
	*/
	public void remove2(ListNode head){
		while(head!=null){
			ListNode runner = head;
			while(runner.next!=null){
				if(runner.next.data==head.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
				
			}
			head = head.next;
		}
	}

	public static void main (String args[]){
		ListNode a= new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c ;
		c.next = d ;
		d.next = e;
		
		System.out.println("---------");
		removeDup inst = new removeDup();	
		inst.remove2(a);
		
		while(a!=null){
			System.out.print(a.data);
			a = a.next;
		}

	}   
}









