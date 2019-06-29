package class_03;

import class_03.Code_01_Array_To_Stack_Queuecopy.ArrayStack;

public class Code_01_Array_To_Queuecopy {

	public static class ArrayQueue {
		private Integer[] arr;
		private Integer size;
		private Integer first;
		private Integer last;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr = new Integer[initSize];
			size = 0;
			first = 0;
			last = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}

		public void push(int obj) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[last] = obj;
			last = (last == arr.length - 1) ? 0 : last + 1;//如果已经到达数组末尾就重新等于0
		}

		public Integer poll() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int tmp = first;
			first = (first == arr.length - 1) ? 0 : first + 1;//如果已经到达数组末尾就重新等于0
			return arr[tmp];
		}
	}
	public static void main(String[] args) {
		int initSize = 3;
		ArrayQueue myQueue = new ArrayQueue(initSize);
		myQueue.push(12);
		myQueue.push(13);
		myQueue.push(15);
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
		System.out.println(myQueue.poll());
		myQueue.push(23);
		myQueue.push(24);
		System.out.println(myQueue.poll());
		System.out.println(myQueue.peek());
	}
}
