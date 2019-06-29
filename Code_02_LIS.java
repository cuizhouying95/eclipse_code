package advancedclass_07;

public class Code_02_LIS {
     //时间复杂度O(N*N)
	//dp[i]表示在以arr[i]为结尾的情况下，arr[0..i]中的最大递增子序列长度
	public static int[] getdp1(int[] arr) {
		int[] dp=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		return dp;
	}
	
	public static int[] generateLIS(int[] arr,int[] dp) {
		int len=0;
		int index=0;
		for(int i=0;i<dp.length;i++) {
			if(dp[i]>len) {
				len=dp[i];//找到最大值及位置
				index=i;
			}
		}
		int[] lis=new int[len];
		lis[--len]=arr[index];
		for(int i=index;i>=0;i--) {
			if(arr[i]<arr[index]&&dp[i]==dp[index]-1) {
				lis[--len]=arr[i];
				index=i;
			}
		}
		return lis;		
	}
	
	public static int[] lis1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp1(arr);
		return generateLIS(arr, dp);
	}
	//时间复杂度O(N*logN)
	//利用二分查找来优化生成dp数组
	public static int[] getdp2(int[] arr) {
		int[] dp=new int[arr.length];
		int[] ends=new int[arr.length];
		ends[0]=arr[0];
		dp[0]=1;
		int right=0;
		int l=0;
		int r=0;
		int m=0;
		for(int i=0;i<arr.length;i++) {
			l=0;
			r=right;
			while(l<=r) {
				m=(l+r)/2;
				if(arr[i]>ends[m]) {
					l=m+1;
				}else {
					r=m-1;
				}
			}
			right=Math.max(right, l);
			ends[l]=arr[i];
			dp[i]=l+1;
		}
        return dp;
		}
	public static int[] lis2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp2(arr);
		return generateLIS(arr, dp);
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		printArray(arr);
		printArray(lis1(arr));
		printArray(lis2(arr));
	}
}
