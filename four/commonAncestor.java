import java.util.*;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data = data;
	}
}

class commonAncestor{
	//The following code is buggy! It does not consider the case if a, b is not in the tree, in which case their common ancestor is null.     
	//The algorithm described below will return root, 1. If node a and/or b is not in the tree. The remedy is to test if a and b are both in the tree first. 
	//Then you do the check.
	public TreeNode getCA(TreeNode a, TreeNode b, TreeNode root){	
		if(a==null && b == null) return null; //discuss what should be done here. throw an exception maybe? 
		if(this.isFather(a,root.left)&&this.isFather(b,root.left)) return this.getCA(a,b,root.left);
		if(this.isFather(a,root.right)&&this.isFather(b,root.right)) return this.getCA(a,b,root.right);
		
		return root;
	}	
	
	public boolean isFather(TreeNode n, TreeNode father){
		//assumes that father is not null. 
		if(father==null && n==null) return true;		
		if(father ==null) return false;
		if(father == n) return true;

		return (this.isFather(n,father.left)||this.isFather(n,father.right));
	}

	public static void main(String args[]){
		commonAncestor inst = new commonAncestor();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(0);

		a.left = b;
		a.right =c;
		b.right = f;
		b.left =d;
		d.right=e;
		
		System.out.println(inst.getCA(b,g,a).data);
	}

}
