import java.util.*;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class ListNode{
	TreeNode data;
	ListNode next;

	public ListNode(TreeNode  data){
		this.data = data;
		this.next = null;
	}
}

class List{
	ListNode head;
	ListNode tail;	
	
	public List(){
		this.head = null;
		this.tail = null;
	}

	public void append(ListNode n){
		if(this.head==null){
			this.head = n;
			this.tail = n;
		}else{
			this.tail.next = n;
			this.tail = this.tail.next;
		}
	}

	public void print(){
		ListNode h = this.head;
		while(h!=null){
			System.out.print(h.data.data+ " ");
			h = h.next;
		}
		System.out.println("");
	}
}


class createLevelLinkedList{
	public ArrayList<List> createList(TreeNode root){
		if(root==null) return null;
		//init the queue
		ArrayList<TreeNode> q = new ArrayList<TreeNode>();
		//store the res
		ArrayList<List> res = new ArrayList<List>();
		//A dummy node to tell you when a level ends.
		TreeNode dummy = null;
		
		q.add(root);
		q.add(dummy);
		
		List cur = new List();
		
		while(q.size()>0){
			TreeNode tmp = q.remove(0);
			if(tmp!=dummy){
				cur.append(new ListNode(tmp));
				if(tmp.left!=null) q.add(tmp.left);
				if(tmp.right!=null) q.add(tmp.right);
			//reached the end of one level
			}else{	
				//add the List into res 
				res.add(cur);
				//wipe out the cur list. 
				cur = new List();
				//If dummy is not at the end of the queue q, add dummy in again.
				if(q.size()>0) q.add(dummy);
			}
		}
		return res;
	}
	
	public static void main(String args[]){
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);

		a.left = b;
		a.right = c;

		b.left = d;
		b.left = e;

		c.left = f;
		c.right = g;

		
		createLevelLinkedList l = new createLevelLinkedList();
		ArrayList<List> res = l.createList(a);

		for (List x: res){
			x.print();
		}
	}
}
