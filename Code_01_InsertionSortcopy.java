package basic_class_01;

public class Code_01_InsertionSortcopy {
    public static void insertionSort(int[]arr) {
	if (arr==null || arr.length<2) {
    	return;
    }
	for(int i=1;i<arr.length;i++) {
		for (int j=i-1;j>=0&&arr[j]>arr[j+1];j--) {
			swap(arr,j,j+1);
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
		insertionSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
