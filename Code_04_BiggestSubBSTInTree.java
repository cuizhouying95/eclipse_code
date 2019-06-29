package advancedclass_04;

public class Code_04_BiggestSubBSTInTree {

	public static class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data) {
			this.value=data;
		}
	}
	
	public static int biggestSubBST(Node head) {
		return process(head).size;
	}
	
	public static class ReturnType{
		public int size;
		public Node head;
		public int min;
		public int max;
		
		public ReturnType(int a,Node b,int c,int d) {
			this.size=a;
			this.head=b;
			this.min=c;
			this.max=d;
		}
	}
	
	public static ReturnType process(Node head) {
		if(head==null) {
			return new ReturnType(0,null,Integer.MAX_VALUE,Integer.MIN_VALUE);
		}
		Node left=head.left;
		Node right=head.right;
		ReturnType leftSubTreeInfo=process(left);
		ReturnType rightSubTreeInfo=process(right);
		
		int includeItSelf=0;
		if(leftSubTreeInfo.head==left
				&&rightSubTreeInfo.head==right
				&&head.value>leftSubTreeInfo.max
				&&head.value<rightSubTreeInfo.min
				) {
			includeItSelf=leftSubTreeInfo.size+1+rightSubTreeInfo.size;
		}
		int p1=leftSubTreeInfo.size;
		int p2=rightSubTreeInfo.size;
		int maxSize=Math.max(Math.max(p1, p2), includeItSelf);
		
		Node maxHead=p1>p2?leftSubTreeInfo.head:rightSubTreeInfo.head;
		if(maxSize==includeItSelf) {
			maxHead=head;
		}
		return new ReturnType(maxSize,maxHead,
				Math.min(Math.min(leftSubTreeInfo.min,rightSubTreeInfo.min), head.value),
				Math.max(Math.max(leftSubTreeInfo.max,rightSubTreeInfo.max), head.value));
		
	}
	
	public static void main(String[] args) {

		Node head = new Node(6);
		head.left = new Node(1);
		head.left.left = new Node(0);
		head.left.right = new Node(3);
		head.right = new Node(12);
		head.right.left = new Node(10);
		head.right.left.left = new Node(4);
		head.right.left.left.left = new Node(2);
		head.right.left.left.right = new Node(5);
		head.right.left.right = new Node(14);
		head.right.left.right.left = new Node(11);
		head.right.left.right.right = new Node(15);
		head.right.right = new Node(13);
		head.right.right.left = new Node(20);
		head.right.right.right = new Node(16);

		System.out.println(biggestSubBST(head));
	}
}
