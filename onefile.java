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

	//check if linked list is palindrome recursively.
	public boolean isPalindromeR(ListNode head){
		if(head ==null) return true;
                //This is a way to split head into head and tail really.
                ListNode node = this.isPalindromeR(head, head); //if everything matches, node is the last node of the palindrome.
                if(node == null) return false;
                return true;
        }

        //This recursion stack has the same height with the number of nodes in the linked list. Loved it!!      
        private ListNode isPalindromeR(ListNode left, ListNode right){
       		//these ensures that right reaches to the end of list. yet, left = firstNode. 
                if(right == null) return left;

                // the recursion itself helps you to shift RIGHT to left direction. 
                // returning LEFT help you shift LEFT to right direction. It also indicates if anything was wrong.
           
                left = this.isPalindromeR(left, right.next);
                if(left != null){
                        if(left.data==right.data){
                                //matched! then go to next layer of `parenthesis. 
                                // You need to test the condition for the single node list. 
                                if(left.next!=null) left = left.next;
                                return left;
                        }
                }
   		//You will reach here only if mismatch happens in prev recursion or now. 
                return null;
         }


	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(1);	
		a.next = b;
		b.next = c;
		c.next = d;
		//d.next = e;
		PalindromeList inst = new PalindromeList();	
		System.out.println(inst.isPalindromeR(a));

	}
	
}
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
class SimpleThreads {

    // Display a message, preceded by
    // the name of the current thread
    static void threadMessage(String message) {
        String threadName =
            Thread.currentThread().getName();
        System.out.format("%s: %s%n",
                          threadName,
                          message);
    }

    private static class MessageLoop implements Runnable {
        public void run() {
            String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
            };
            try {
                for (int i = 0;
                     i < importantInfo.length;
                     i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        // Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 60 * 60;

        // If command line argument
        // present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);//this is the time you want wait to execute the next line. If no arguments 
            if ( ((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
    }
}
class ThreadDemo implements Runnable {

   public void run() {
   
      Thread t = Thread.currentThread();
      System.out.print(t.getName());
      //checks if this thread is alive
      System.out.println(", status = " + t.isAlive());
   }

   public static void main(String args[]) throws Exception {
   
      Thread t = new Thread(new ThreadDemo());
      // this will call run() function
      t.start();
      // waits for this thread to die
      t.join();
      Thread.sleep(4000);
      System.out.print(t.getName());
      //checks if this thread is alive
      System.out.println(", status = " + t.isAlive());
   }
}
