import java.util.*;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data){
		this.data = data;
	}
}

/* Print all path in a tree which sums up to a given value. The algorithm:
	1. Think about how to print all the path of a tree from root to leaf. 
	2. Think about how to print all the path of a tree from root to some node that sums up to a given value.
	3. Use tree traversal or something to call the 2. above so that you are letting every node in the tree to be the root in 2. 
*/

class pathSum{
	// This is wrapper function
	public void printPath(TreeNode root, int sum){
		if(root==null) return;
		int d = getDepth(root); // we need the depth for the array. 
		//do a pre order traversal of the tree and call the function below for each node. This means that the path can start any where, not just the root.
		this.printPathHelper(root,sum,new TreeNode[d],0);
		
		//recursion call, the start point now can by anywhere!
		this.printPath(root.left,sum);
		this.printPath(root.right,sum);

	}
	
	//This will print all path starting from root which adds up to some value. 
	private void printPathHelper(TreeNode root, int sum, TreeNode path[], int depth){
		if(root==null) return;

		path[depth++] = root; //add root into the path.
		
		int tmp = 0; //calculate the tmp sum.
		for(int i = 0; i<depth; i++){ //Notice that i should end at depth, NOT path.length
			tmp += path[i].data;
		} 
		//compare the tmp sum with the target sum. If they are equal we output the list. 
		if(tmp ==sum) this.print(path,depth);

		if(root.left ==null && root.right ==null) return; //we are reaching the leaf. stop
		
		//recurse
		this.printPathHelper(root.left , sum, path, depth);
		this.printPathHelper(root.right, sum, path, depth);
	}

	
	// A function print from every path from root to leaf. This is the starting point! 
	// The trick is to use depth as index in your path array. So you will have path.  
	private void printRootToLeaf(TreeNode root, TreeNode path[], int depth){
		if (root ==null) return;  //return if root is null.
		path[depth++] = root;     //if root is not null save it into the path. depth++
		if(root.left ==null && root.right ==null){ //if this a leaf then output the list.
			this.print(path,depth);
			return;
		}
		this.printRootToLeaf(root.left, path, depth); //recurse left
		this.printRootToLeaf(root.right,path, depth); //recurse right.
	}
	
	private void print(TreeNode path[], int len){
		for(int i = 0; i<len; i++){
			System.out.print(path[i].data + " ");
		}
		System.out.println("");	
	}

	private int getDepth(TreeNode root){
		if(root==null) return 0;
		return Math.max(  getDepth(root.left)+1, getDepth(root.right)+1);

	}

	public static void main(String args[]){
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(7);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(1);
		TreeNode f = new TreeNode(-1);
		TreeNode g = new TreeNode(8);
		TreeNode h = new TreeNode(1);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		f.right = h;

		pathSum inst = new pathSum();
		inst.printPath(a,8);                                                         
	 }
}
