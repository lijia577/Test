import java.util.*;

/*
Given a graph, check if there exist a route between two nodes.

*/

class Node{
	int data;
	ArrayList<Node> suc;
	public Node(int data){
		this.data = data;
		this.suc = new ArrayList<Node>();
	}
}

public class findRouteInGraph{
	public boolean find(Node a, Node b){
		//init a queue and add node a into it	
		ArrayList<Node> q = new ArrayList<Node>();
		q.add(a);
		//init set, contains all the explored stuff
		Set<Node> visited = new HashSet<Node>();
		while(q.size()>0){
			Node tmp = q.remove(0);
		        System.out.println(tmp.data);	
			if(tmp == b) return true;
			//add all successors into the queue if not visited.	
			for(Node k: tmp.suc){
				System.out.println("k" + k.data);
				if(visited.contains(k)==false){
					q.add(k);
				}
			}
			
			visited.add(tmp);
		}
		return false;
	}

	public static void main(String args[]){
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);

		a.suc.add(b);
		b.suc.add(c);
		d.suc.add(a);
		d.suc.add(c);

		findRouteInGraph inst = new findRouteInGraph();
		System.out.println(inst.find(a,d));
		System.out.println(inst.find(d,a));
	}
}		
