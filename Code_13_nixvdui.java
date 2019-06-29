package basic_class_01;

public class Code_13_nixvdui {
	public static int res = 0;
	public static void nixv(int[] arr) {
		if (arr == null || arr.length < 2) {
			return ;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if(l==r) {
    		return;
    	}
    	int mid=l+((r-l)>>1);
    	mergeSort(arr,l,mid);
    	mergeSort(arr,mid+1,r);
    	merge(arr,l,mid,r);
    	}

	public static void merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;

		while (p1 <= m && p2 <= r) {
			if (arr[p1]>arr[p2]) {
			       res += m-p1+1;
			       for (int j=p1;j<=m;j++) {
				          System.out.print(arr[j]+" "+arr[p2]+"|");
			    }
			}
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		}
	
	public static void main (String[] args) {
		int[] a= {7,3,19,40,4,6,1};
		nixv(a);
		System.out.println("ÄæÐò¶Ô¸öÊý£º"+res);
		
		}

}
