package advancedclass_02;

import java.util.LinkedList;

public class Code_03_AllLessNumSubArray {//小于或等于某数的子数组数量
	
	public static int getNum(int[]arr,int num) {
		if(arr==null||arr.length==0) {
			return 0;
		}
		LinkedList<Integer> qmax=new LinkedList<Integer>();
		LinkedList<Integer> qmin=new LinkedList<Integer>();
		int L=0;
		int R=0;
		int res=0;
		while(L<arr.length) {
			while(R<arr.length) {
				while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[R]) {
					qmin.pollLast();
				}
			   qmin.addLast(R);
			   while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[R]) {
				     qmax.pollLast();
			  }
		      qmax.addLast(R);
		      if (arr[qmax.getFirst()]-arr[qmin.getFirst()]>num) {//不达标
			    break;
		       }
		      R++;
		     }
		if(qmin.peekFirst()==L) {
			qmin.pollFirst();
		}
		if(qmax.peekFirst()==L) {
			qmax.pollFirst();
		}
		res += R-L;
		L++;
	}	
	    return res;
	    }

	     public static void main(String[] args) {
	    	 int[] arr= {4,3,7};
	    	 int num=3;
	    	 System.out.println(getNum(arr,num));
	     }

}
