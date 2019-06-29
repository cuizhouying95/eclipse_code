package advancedclass_02;
import java.util.LinkedList;
public class Code_01_windowmax {//���ɴ������ֵ����

	public static int[] getMaxWindow(int[] arr,int w) {
		if(arr==null||w<1||arr.length<w) {
			return null;
		}
		LinkedList<Integer> qmax=new LinkedList<Integer>();
		int[] res=new int[arr.length-w+1];
		int index =0;
		for(int i=0;i<arr.length;i++) {
			while(!qmax.isEmpty()&& arr[qmax.peekLast()]<=arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if (qmax.peekFirst()==i-w) {//ͷ������
				qmax.pollFirst();
			}
			if(i>=w-1) {//�����γ�
				res[index++]=arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr= {4,3,5,4,3,3,6,7};
		printArray(getMaxWindow(arr,3));
	}
	
}
