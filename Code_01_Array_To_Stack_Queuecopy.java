package class_03;

public class Code_01_Array_To_Stack_Queuecopy {//数组实现栈

	public static class ArrayStack{
		private Integer[] arr;
		private Integer size;
		
		public ArrayStack(int initSize) {
			if (initSize<0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
		}
		public Integer peek() {
			if (size ==0) {
				return null;
			}
			return arr[size-1];
		}
		public void push(int obj) {
			if(size==arr.length) {
				throw new IllegalArgumentException("The init size is full");
			}
			arr[size++]=obj;
		}
		
		public Integer pop() {
			if(size==0) {
				throw new IllegalArgumentException("The init size is empty");
			}
			return arr[--size];
		}
}
	public static void main(String[] args) {
		int initSize = 3;
		ArrayStack myQueue = new ArrayStack(initSize);
		System.out.println(myQueue.peek());
		myQueue.push(12);
		myQueue.push(13);
		myQueue.push(15);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		myQueue.push(23);
		myQueue.push(24);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.peek());
	}

}
