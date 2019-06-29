package class_04;
import java.util.LinkedList;
import java.util.Queue;
public class Code_04_SerializeAndReconstructTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static String serialBypre(Node head) {
		if (head==null) {
			return "#!";
		}
		String res=head.value+"!";
		res+=serialBypre(head.left);
		res+=serialBypre(head.right);
		return res;
	}
	
	public static Node reconByPreString(String preStr) {
		String[] values=preStr.split("!");
		Queue<String> queue=new LinkedList<String>();
		for (int i=0;i!=values.length;i++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}
	public static Node reconPreOrder(Queue<String> queue) {
		String value= queue.poll();
		if(value.equals("#")) {
			return null;
		}
		Node head=new Node(Integer.valueOf(value));
		head.left=reconPreOrder(queue);
		head.right=reconPreOrder(queue);
		return head;
	}
	
	public static String serialByLevel(Node head) {
		if (head==null) {
			return "#!";
		}
		String res=head.value+"!";
		Queue<Node> queue=new LinkedList<Node>();
		queue.offer(head);
		while(!queue.isEmpty()) {
			head=queue.poll();
			if (head.left!=null) {
				res+=head.left.value+"!";
				queue.offer(head.left);
			}else {
				res+="#!"
			}
			if (head.right!=null) {
				res+=head.right.value+"!";
				queue.offer(head.right);
			}else {
				res+="#!"
			}
		}
		return res;
		
	}
	
	public static Node reconByLevelString(String levelStr) {
		String[] values=levelStr.split("!");
		int index=0;
		Node head=generateNodeByString(values[index++]);
		Queue<Node> queue=new LinkedList<Node>();
		if (head!=null) {
			queue.offer(head);
		}
		Node node =null;
		while(!queue.isEmpty()) {
			node=queue.poll();
			node.left=generateNodeByString(values[index++]);
			node.right=generateNodeByString(values[index++]);
			if(node.left!=null) {
				queue.offer(node.left);
			}
			if(node.right!=null) {
				queue.offer(node.right);
			}
		}
		return head;
	}
	
	public static Node generateNodeByString(String val) {
		if(val.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}
	
}
