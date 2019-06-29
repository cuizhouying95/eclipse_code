package basic_class_01;

public class Code_00_BubbleSortcopy {
	public static void bubbleSort(int[]arr) {
		if (arr== null || arr.length<2) {
			return;
		}
		for (int e=arr.length-1;e>0;e--) {
			for(int i=0;i<e;i++) {
				if(arr[i]>arr[i+1]) {
					swap(arr,i,i+1);
				}
			}
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void main (String[] args) {
		int[] a= {7,3,19,40,4,7,1};
		bubbleSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}


