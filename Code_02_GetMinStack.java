package class_03;

import java.util.Stack;

public class Code_02_GetMinStack {

	public static class MyStack1{
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		public MyStack1() {
			this.stackData=new Stack<Integer>();//�������浱ǰջ�е�Ԫ��
			this.stackMin=new Stack<Integer>();//��������ÿһ������Сֵ
		}
		
		public void push(int newNum) {//ѹ�����ݹ���
			if(this.stackMin.isEmpty()) {//���Ϊ�գ������ѹ��stackMin
				this.stackMin.push(newNum);
			} else if (newNum<=this.getmin()) {//�����Ϊ�գ�������ջ��Ԫ�رȽ���һ����С����newNum��С����newNumҲѹ��stackMin
				this.stackMin.push(newNum);
			}
			this.stackData.push(newNum);//����ѹ��stackData
		}
		
		public int pop() {//��������ԭ��
			if(this.stackData.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			//stackMinջ��Ԫ����stackMinջ�е���Сֵ��Ҳ��stackDataջ�е���Сֵ
			int value=this.stackData.pop();
			//value�����stackMinջ��Ԫ�ظ�С
			if (value==this.getmin()) {//��value����stackMinջ��Ԫ��ʱ��stackMin����ջ��Ԫ��
				this.stackMin.pop();
			}
			return value;
		}
		
		public int getmin() {//��ѯ��ǰջ�е���Сֵ����
			if(this.stackMin.isEmpty()) {
				throw new RuntimeException("Your stack is empty.");
			}
			return this.stackMin.peek();//stackMinջ��Ԫ��ʼ���ǵ�ǰstackDataջ�е���Сֵ
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