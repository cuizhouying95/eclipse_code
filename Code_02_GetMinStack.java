package class_03;

import java.util.Stack;

public class Code_02_GetMinStack {

	public static class MyStack1{
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		public MyStack1() {
			this.stackData=new Stack<Integer>();//用来保存当前栈中的元素
			this.stackMin=new Stack<Integer>();//用来保存每一步的最小值
		}
		
		public void push(int newNum) {//压入数据规则
			if(this.stackMin.isEmpty()) {//如果为空，则该数压入stackMin
				this.stackMin.push(newNum);
			} else if (newNum<=this.getmin()) {//如果不为空，该数和栈顶元素比较哪一个更小，若newNum更小，则newNum也压入stackMin
				this.stackMin.push(newNum);
			}
			this.stackData.push(newNum);//该数压入stackData
		}
		
		public int pop() {//弹出数据原则
			if(this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			//stackMin栈顶元素是stackMin栈中的最小值，也是stackData栈中的最小值
			int value=this.stackData.pop();
			//value不会比stackMin栈顶元素更小
			if (value==this.getmin()) {//当value等于stackMin栈顶元素时，stackMin弹出栈顶元素
				this.stackMin.pop();
			}
			return value;
		}
		
		public int getmin() {//查询当前栈中的最小值操作
			if(this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();//stackMin栈顶元素始终是当前stackData栈中的最小值
		}
		
		public static class MyStack2 {
			private Stack<Integer> stackData;
			private Stack<Integer> stackMin;

			public MyStack2() {
				this.stackData = new Stack<Integer>();
				this.stackMin = new Stack<Integer>();
			}

			public void push(int newNum) {
				if (this.stackMin.isEmpty()) {
					this.stackMin.push(newNum);
				} else if (newNum < this.getmin()) {
					this.stackMin.push(newNum);
				} else {
					int newMin = this.stackMin.peek();
					this.stackMin.push(newMin);
				}
				this.stackData.push(newNum);
			}

			public int pop() {
				if (this.stackData.isEmpty()) {
					throw new RuntimeException("Your stack is empty.");
				}
				this.stackMin.pop();
				return this.stackData.pop();
			}

			public int getmin() {
				if (this.stackMin.isEmpty()) {
					throw new RuntimeException("Your stack is empty.");
				}
				return this.stackMin.peek();
			}
	}
	}
		public static void main(String[] args) {
			MyStack1 stack1 = new MyStack1();
			stack1.push(3);
			System.out.println(stack1.getmin());
			stack1.push(4);
			System.out.println(stack1.getmin());
			stack1.push(1);
			System.out.println(stack1.getmin());
			System.out.println(stack1.pop());
			System.out.println(stack1.getmin());
			System.out.println("=============");

			MyStack1 stack2 = new MyStack1();
			stack2.push(3);
			System.out.println(stack2.getmin());
			stack2.push(4);
			System.out.println(stack2.getmin());
			stack2.push(1);
			System.out.println(stack2.getmin());
			System.out.println(stack2.pop());
			System.out.println(stack2.getmin());
	}
}
