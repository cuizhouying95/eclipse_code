package class_04;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class Code_07_IsBSTAndCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static boolean isBST(Node head) {
		int pre=Integer.MIN_VALUE;
		boolean res=true;
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					if(pre>head.value) {
					     res= false;
					     break;
					}else {
					head = head.right;
				   }
			    }
			}
		}
		return res;
	}
	
	public static boolean isCBT(Node head) {
		if(head==null) {
			return true;
		}
		Queue<Node> queue=new LinkedList<Node>();
		boolean leaf=false;
		Node l=null;
		Node r=null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head=queue.poll();
			l=head.left;
			r=head.right;
			if((leaf&&(l!=null||r!=null))||(l==null&&r!=null)){
				return false;
			}
			if(l!=null) {
				queue.offer(l);
			}
			if(r!=null) {
				queue.offer(r);
			}
			if(l==null||r==null) {
				leaf=true;
			}
		}
		return true;
	}
	
			
			public static void main(String[] args) {
				Node head = new Node(4);
				head.left = new Node(2);
				head.right = new Node(6);
				head.left.left = new Node(1);
				head.left.right = new Node(3);
				head.right.left = new Node(5);

				
				//System.out.println(isBST(head));
				System.out.println(isCBT(head));

			}		
	}
