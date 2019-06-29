package advancedclass_05;

public class Code_03_MaxDistanceInTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static int maxdistance(Node head) {
		return process(head).maxDistance;
	}
	public static class ReturnType{
		public int maxDistance;
		public int h;
		
		public ReturnType(int m,int h) {
			this.maxDistance=m;//最大距离
			this.h=h;//深度
		}
	}
	
	public static ReturnType process(Node head) {
		if(head==null) {
			return new ReturnType(0,0);
		}
		ReturnType leftReturnType=process(head.left);
		ReturnType rightReturnType=process(head.right);
		//左子树上离h.left最远距离+1+右子树上离h.right最远距离
		int includeHeadDistance=leftReturnType.h+1+rightReturnType.h;
		int p1=leftReturnType.maxDistance;//来自左子树的最大距离
		int p2=rightReturnType.maxDistance;//来自右子树的最大距离
		int resultDistance=Math.max(Math.max(p1,p2),includeHeadDistance);
		int hitself=Math.max(leftReturnType.h,rightReturnType.h)+1;
		return new ReturnType(resultDistance,hitself);
				
	}
	
	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.left = new Node(2);
		head1.right = new Node(3);
		head1.left.left = new Node(4);
		head1.left.right = new Node(5);
		head1.right.left = new Node(6);
		head1.right.right = new Node(7);
		head1.left.left.left = new Node(8);
		head1.right.left.right = new Node(9);
		System.out.println( maxdistance(head1));

		Node head2 = new Node(1);
		head2.left = new Node(2);
		head2.right = new Node(3);
		head2.right.left = new Node(4);
		head2.right.right = new Node(5);
		head2.right.left.left = new Node(6);
		head2.right.right.right = new Node(7);
		head2.right.left.left.left = new Node(8);
		head2.right.right.right.right = new Node(9);
		System.out.println( maxdistance(head2));

	}

	
}
