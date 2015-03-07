import java.util.*;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data){
		this.data = data;
	}
}

class isSubTree{
	/* Memory O(log(s) + log(m))
	   Runtime complexity is O(mn), where m is the # node in s. n is # node in l.
	   To be exact, suppose k is number of occurance of root of s in l. Run time is O(n + km). 

	   You may also use preorder + inorder traversal to describe a tree and solve this problem. It requires more memory. 
	*/
	//extra wrapper class. Handle special case where s is null.
	public boolean isSubtree(TreeNode s, TreeNode l){
		if(s==null) return true;
		return isSubtreeH(s,l);
	}

	//check subtree. 
	public boolean isSubtreeH(TreeNode s, TreeNode l){
		// if the large tree is null, return false because no subtree exist for null large tree.
		if(l==null) return false;//base case
		//check if check node and the small are the same.
		if(isSame(s,l)) return true;
		
		//if not, check the left and right node of the root 
		return isSubtreeH(s,l.left)||isSubtreeH(s,l.right);	

	}

	//returns true if tree a and b are absolutely identical!
	public boolean isSame(TreeNode a, TreeNode b){
		if(a == null && b==null) return true;
		//if a,b are not both null. But one of them is null. Those two trees can't be identical.
		if(a==null || b==null) return false;
		
		//check if they have the same data of course!! don't forget this! And you are check data, not node.
		if(a.data!=b.data) return false;

		//make sure the left and right subtree are also the same
		return isSame(a.left,b.left)&&isSame(a.right,b.right);
	}

	public static void main(String args[]){
		isSubTree inst = new isSubTree();
		
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
		b.right = e;
		
		c.left = f;
		c.right = g;

		
		TreeNode x= new TreeNode(2);
		TreeNode y = new TreeNode(4);
		TreeNode z = new TreeNode(5);
		
		x.left = y;
		x.right = z;

		System.out.println("true? " + inst.isSubtree(x,a));
		TreeNode m = new TreeNode(7);
		System.out.println("true? " + inst.isSubtree(m,a));
		
		TreeNode p = new TreeNode(3);
		TreeNode q = new TreeNode(6);

		
		p.right = q;

		System.out.println("false ?" + inst.isSubtree(p,a));
		System.out.println("false ?" + inst.isSubtree(p,null));

		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(6);
		a1.left = a2;
		System.out.println("false ?" + inst.isSubtree(a1,a));
		
		
		System.out.println("true ?" + inst.isSubtree(null,a));

}		
}
