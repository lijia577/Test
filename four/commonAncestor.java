import java.util.*;

/*
Find lowest common ancestor in a binary tree given two nodes a and b.

!If you are not sure about whether a and b are both present in the tree. You should CHECK!!!

The complexity for both of algorithms are O(n), the buttom-up one is slightly better than the top-down one. 
*/

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data = data;
	}
}


class BoolPair{
	boolean a;
	boolean b;
}

class commonAncestor{
	//Assumes a and b are both in the tree. If this assumption is bad, simply check a,b using covers before you use the function below. 
	public TreeNode getCA(TreeNode root, TreeNode a, TreeNode b){	
		if(this.covers(root.left,a)&&this.covers(root.left,b)) return this.getCA(root.left,a,b);
		if(this.covers(root.right,a)&&this.covers(root.right,b)) return this.getCA(root.right,a,b);
		
		return root;
	}	
	
	//returns if top covers n. U may w2 discuss the case where n is null what should be returned. here. I assume a tree(non-trivial) does NOT cover null.  
	public boolean covers(TreeNode top, TreeNode n){ 
		if(top ==null) return false;
		if(top == n) return true;

		return (this.covers(top.left,n)||this.covers(top.right, n));
	}



	/* Assume a, b must exist in tree; otherwise use covers function to check.
	Buttom-up style recursion. Where you did reach the leaf of the recursion tree. And they we go up from there by the recursion. 
	As you recurse down, you will find p or q eventually. If (root == p || root==q) return root.
	if this branch fails somehow, return null.
	Once you have both the left and right branch returns non-null value for the first time, this is the common ancestor you are trying to find. Return it. 
	*/
	public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b){
		//if root is null, it can't be ancestor of node a,b.
		if(root == null) return null;
		
		//this means that root is an ancestor of either nodes. Because we are buttom up.
		if(root == a || root == b) return root;  

		//recurse until the above two cases happens.
		TreeNode left = LCA(root.left, a, b);
		TreeNode right = LCA(root.right, a, b);
		
		//if both left and right are non-null, we found the LCA. 
		if(left!=null && right!=null) return root;

		//else a OR b is still missing. So we return whatever have been found now
		return left!=null? left: right;

	}
	

	public static void main(String args[]){
		commonAncestor inst = new commonAncestor();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		
		a.left = b;
		a.right= c;
	
		b.left = d;
		b.right = e;
		e.right = f;
		
		System.out.println("LCA of 2,5 is 2? " + inst.LCA(a,b,e).data + " " + inst.getCA(a,b,e).data);
		System.out.println("LCA of 4,6 is 2? " + inst.LCA(a,d,f).data + " " + inst.getCA(a,d,f).data);
		System.out.println("LCA of 3,6 is 1? " + inst.LCA(a,c,f).data + " " + inst.getCA(a,c,f).data);
		System.out.println("LCA of 5,5 is 5? " + inst.LCA(a,e,e).data + " " + inst.getCA(a,e,e).data);
		System.out.println("LCA of 1,6 is 1? " + inst.LCA(a,a,f).data + " " + inst.getCA(a,a,f).data);
		
	}

}
