package class_07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_02_Less_Money {

	public static int lessMoney(int[] arr) {
		PriorityQueue<Integer> pQ=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			pQ.add(arr[i]);
		}
		int sum=0;
		int cur=0;
		while(pQ.size()>1) {
			cur=pQ.poll()+pQ.poll();
			sum+=cur;
			pQ.add(cur);
		}
		return sum;
		
	}
	
	public static void main(String[] args) {
		int[] arr = { 6, 7, 8, 9 };
		System.out.println(lessMoney(arr));
	}
}
