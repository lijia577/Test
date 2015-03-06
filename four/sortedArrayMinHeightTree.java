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

//construct a tree out of an array with mininum height. 
class sortedArrayMinHeightTree{
	public TreeNode makeTree(int arr[], int start, int end){
		if(start>end) return null; //exit condition
		
		//the root is the middle of the array, of course. 
		int mid = start + (end-start)/2;
		TreeNode a = new TreeNode(arr[mid]);
		
		//As you recurse down, make other nodes along the way.
		a.left = makeTree(arr,start,mid-1);
		a.right = makeTree(arr,mid+1, end);
	
		// return node you make.
		return a;
	}
	
	//print a tree level by level, using a queue, this is a modified version of BFS	
	public void print(TreeNode root){
		if(root ==null) return;
		
		ArrayList<TreeNode> q = new ArrayList<TreeNode>();
		q.add(root);
		TreeNode dum=null; //this is just a dummy node. It's used to indicate that you have shifted in level. 
		q.add(dum);
		
		//The idea is add a dummy node into the queue. When you popped it out, you output newline. Yet at the same time
		//push the dummy name back to the queue to set the indicator for another level. You are not adding the dummy immediately
		//after you enqueue successors, that would be wrong. 
		while(q.size()>0){
			TreeNode tmp = q.remove(0);
			if(tmp==dum){
				System.out.println("");	
				if(q.size()>0) q.add(dum); //check q.size()>0 to make sure you are not at the end of the queue
			}else{
				System.out.print(tmp.data + " ");
				if(tmp.left!=null)q.add(tmp.left);
				if(tmp.right!=null)q.add(tmp.right);
			}				
		}
	}

	public static void main(String args[]){
		int a[] = {1,2,3,4,5,6};
		
		sortedArrayMinHeightTree inst = new sortedArrayMinHeightTree();
		TreeNode res = inst.makeTree(a,0,5);

		inst.print(res);
	}	
}







