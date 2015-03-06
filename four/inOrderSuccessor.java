import java.util.*;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(int data){
		this.data = data;
	}
}

//Get the in order successor in a binary search tree. The TreeNode has a link to parent. 
class inOrderSuccessor{
	public TreeNode getIOS(TreeNode n){
		if(n == null) return null;
		TreeNode res = null;
		//if n has a right child, we should go right one step, then go left left left..  
		if(n.right!=null){
			res = n.right;
			while(res.left!=null) res = res.left;
		}else{
		//when n does not have a right child, go up to left parent, left parent... , then one right parent.
			res = n;
			//Behold the condition setting below. Be careful otherwise you will get null pointer exception.
			while(res.parent!=null && res.parent.right == res) res = res.parent;
			res = res.parent;
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
		TreeNode h = new TreeNode(8);

		e.left = a;
		e.right = f;
		
		a.right = c;
		
		c.left = b;
		c.right = d;

		f.right = g;

		b.parent = c;
		d.parent = c;
		
		c.parent = a;
		
		a.parent = e;

		f.parent =e;
		g.parent =f;

		inOrderSuccessor inst = new inOrderSuccessor();
		System.out.println(inst.getIOS(d).data+ "should be 5");
		System.out.println(inst.getIOS(g)==null);
		System.out.println(inst.getIOS(c).data + "should be 4");

	}

}
