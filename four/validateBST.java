import java.util.*;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data){
		this.data = data;
	}
}


class validateBST{
	//The defintion of BST: FOR ALL NODE, all the left subnode<= NODE, all the right subnode > Node.
	// The idea is to check the boundary of a node. For example, in tree with 3 nodes. a.left = b, a.right = c. The boundry for b is (-inf,a) 
	public boolean validate(TreeNode root, int min, int max){
		if(root ==null) return true;
		
		//root should be contained in the range, s.t. min<root.data<=max
		if(root.data>max || root.data<=min) return false;

		if(!validate(root.left,min,root.data)) return false;
		if(!validate(root.right,root.data, max)) return false;

		return true;
	}

	//Assume all value in the tree is unique. We can modify In Order Trasversal. The in order traversal of a BST will be in ascending order. So we can just check the current 
	//value should always be greater than the previous value. 
	
	public static int prev = Integer.MIN_VALUE;

	public boolean validate2(TreeNode root){
		if(root==null) return true;
		
		//recurse to the left
		if(this.validate2(root.left)==false) return false;
		//compare the root with prev, the first time prev is the -infinity. 
		if(root.data<=prev) return false;
		prev = root.data;
		if(this.validate2(root.right)==false) return false;

		return true;

	}
	
	public static void main(String args[]){
		TreeNode m = new TreeNode(10);
		TreeNode n = new TreeNode(10);
		m.right = n;
		
		validateBST inst = new validateBST();
		System.out.println("False? " + inst.validate(m,Integer.MIN_VALUE, Integer.MAX_VALUE));

		TreeNode a = new TreeNode(20);
		TreeNode b = new TreeNode(10);
		TreeNode c = new TreeNode(30);
		TreeNode d = new TreeNode(25);

		a.left = b;
		a.right = c;
		b.right = d;
		
		System.out.println("False? " + inst.validate(a,Integer.MIN_VALUE, Integer.MAX_VALUE));

		System.out.println("False? " + inst.validate2(a));
		
	}
}
