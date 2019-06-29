package class_04;

public class Code_03_SuccessorNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getSuccessorNode(Node node) {
		if(node==null) {
			return node;
		}
		if(node.right!=null) {//如果有右子树，那么后继节点是右子树最左边的节点
			return getleftMost(node.right);
		}else {
			Node parent=node.parent;
			while(parent!=null&&parent.left!=node) {
				node=parent;
				parent=node.parent;
			}
			return parent;
		}
	}
	
	public static Node getleftMost(Node node) {
		if(node==null) {
			return node;
		}
		while(node.left!=null) {
			node=node.left;
		}
		return node;
	}
	
	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;
		
		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
	}
}
