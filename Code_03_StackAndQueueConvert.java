package class_03;
import java.util.LinkedList;
import java.util.Stack;

import class_03.Code_02_GetMinStack.MyStack1;

import java.util.Queue;
public class Code_03_StackAndQueueConvert {

	public static class TwoStacksQueue{
		public Stack<Integer> stackPush;
		public Stack<Integer> stackPop;
		
		public TwoStacksQueue() {
			stackPush=new Stack<Integer>();
			stackPop=new Stack<Integer>();
		}
		
		public void add(int pushInt) {
			stackPush.push(pushInt);
			
		}
		
		public int poll() {
			if(stackPop.empty()&&stackPush.empty()) {
				throw new RuntimeException("Queue is empty.");
			} else if (stackPop.empty()) {
				while(!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
			}
			return stackPop.pop();
		}
		
		public int peek() {
			if(stackPop.empty()&&stackPush.empty()) {
				throw new RuntimeException("Queue is empty.");
			}else if (stackPop.empty()) {
				while(!stackPush.empty()) {
					stackPop.push(stackPush.pop());
				}
		}
			
			return stackPop.peek();
		
	}
	}
	public static class TwoQueuesStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		public void push(int pushInt) {
			queue.add(pushInt);
		}

		public int peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}

		public int pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = queue;
			queue = tmp;
		}

	}
	public static void main(String[] args) {
		TwoStacksQueue queue1 = new TwoStacksQueue();
		queue1.add(3);
		queue1.add(5);
		System.out.println(queue1.peek());
		queue1.add(4);
		System.out.println(queue1.poll());
		
		System.out.println("=============");

		TwoQueuesStack stack2 = new TwoQueuesStack();
		stack2.push(3);
		System.out.println(stack2.peek());
		stack2.push(4);
	
		stack2.push(1);
		
		System.out.println(stack2.pop());
	
}
}
