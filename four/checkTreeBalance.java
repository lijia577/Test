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

class checkTreeBalance{
	//Solution 1. Use a getHeight function and a check function together. The complexity is O(n^2) because we recurse the whole subtree of
	//each node. 
	private int getHeight(TreeNode n){
		if(n==null) return 0;
		//The height depends on the highest subtree, so:
		return Math.max(1+this.getHeight(n.left), 1+ this.getHeight(n.right));
	}
	public boolean check(TreeNode root){
		if(root==null) return true;
		//if the height difference on this level is greater than 1, this is not balance.
		if(Math.abs(this.getHeight(root.left)-this.getHeight(root.right))>1) return false;		
		//recurse down to check the subtrees for the same height difference condition.
		return(this.check(root.left)&&this.check(root.right));
	}


	//Solution 2. Better complexity wise. The idea is to get the height of each left node. When you get down to a leaf, return its depth.
	//Backtrack its depth up to the internal tree node. 
	private int check2helper(TreeNode root, int h){
		if(root==null) return h;
		//recurse to the leaf node.	
		int left = this.check2helper(root.left,1+h);
		int right = this.check2helper(root.right, 1+h);
		
		//now you are at the buttom of the tree on your way back. 
		
		//check if the tree is not balanced.		
		if(Math.abs(left-right)>1) return -1;
		//this is the not balanced code -1.
		if(left==-1||right==-1) return -1;
		
		//it is balanced then you return the height of the tree.
		return Math.max(left,right);
		
	}
	
	public boolean check2(TreeNode root){
		if(root==null) return true;
		if(this.check2helper(root,0)==-1) return false;
		return true;
	}

	public static void main(String args[]){
		checkTreeBalance inst = new checkTreeBalance();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(4);
		TreeNode h = new TreeNode(4);
		TreeNode i = new TreeNode(4);
		TreeNode j = new TreeNode(4);
		TreeNode k = new TreeNode(4);
		TreeNode l = new TreeNode(4);
			
		a.left = b;
		b.left = c;
		c.right= g;
		
		a.right = e;
		e.right = f;
				
		System.out.println(inst.check2(l));
	}
}
