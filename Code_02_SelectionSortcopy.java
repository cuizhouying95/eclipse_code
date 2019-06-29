package basic_class_01;

public class Code_02_SelectionSortcopy {
	public static void selectionSort(int[] arr) {
		if (arr== null || arr.length<2) {
			return;
		}
		for (int i=0;i<arr.length-1;i++) {
			int minIndex=i;// ��ʼ��δ������������С���������±�
			for (int j=i+1; j<arr.length;j++) {
				// ��δ����Ԫ���м���Ѱ����СԪ�أ����������±�
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main (String[] args) {
		int[] a= {7,3,19,40,4,7,1};
		selectionSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
