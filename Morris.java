package advancedclass_03;

import advancedclass_02.Code_02_maxtree.Node;

public class Morris {

	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value=data;
		}
	}
	
	public static void morrisIn(Node head) {
		if(head==null) {
		       return ;	
		}
		Node cur=head;
		Node mostright=null;
		while(cur!=null) {
			mostright=cur.left;
			if(mostright!=null) {
				while(mostright.right!=null&&mostright.right!=cur) {
					mostright=mostright.right;
				}
				if(mostright.right==null) {
					mostright.right=cur;
					cur=cur.left;
					continue;
				}else {
					mostright.right=null;
				}
			}
			System.out.print(cur.value+" ");//œÚ”““∆∂Ø«∞
			cur=cur.right;
		}
		System.out.println();
	}
	
	public static void morrisPre(Node head) {
		if(head==null) {
		       return ;	
		}
		Node cur=head;
		Node mostright=null;
		while(cur!=null) {
			mostright=cur.left;
			if(mostright!=null) {
				while(mostright.right!=null&&mostright.right!=cur) {
					mostright=mostright.right;
				}
				if(mostright.right==null) {
					mostright.right=cur;
					System.out.print(cur.value+" ");
					cur=cur.left;
					continue;
				}else {
					mostright.right=null;
				}
			}else {
			      System.out.print(cur.value+" ");
			}
			cur=cur.right;
		}
		System.out.println();
	}
	
	public static void morrisPos(Node head) {
		if(head==null) {
		       return ;	
		}
		Node cur=head;
		Node mostright=null;
		while(cur!=null) {
			mostright=cur.left;
			if(mostright!=null) {
				while(mostright.right!=null&&mostright.right!=cur) {
					mostright=mostright.right;
				}
				if(mostright.right==null) {
					mostright.right=cur;
					System.out.print(cur.value+" ");
					cur=cur.left;
					continue;
				}else {
					mostright.right=null;
			        printEdge(cur.left);
			}
			cur=cur.right;
		}
			printEdge(head);
			System.out.println();
			}	
		}
	
		public static void printEdge(Node head) {
			Node tail=reverseEdge(head);
			Node cur=tail;
			while(cur!=null) {
				System.out.print(cur.value+" ");
				cur=cur.right;
			}
			reverseEdge(tail);
		}
		
		public static Node reverseEdge(Node from) {
			Node pre=null;
			Node next=null;
			while(from!=null) {
				next=from.right;
				from.right=pre;
				pre=from;
				from=next;
			}
			return pre;
		}
} 
