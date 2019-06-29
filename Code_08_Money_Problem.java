package class_08;

public class Code_08_Money_Problem {

	public static boolean money1(int[] arr,int aim) {
		return isSum(arr,0,0,aim);
	}
	
	public static boolean isSum(int[]arr,int i,int sum,int aim) {
		if(i==arr.length) {
			return sum==aim;
		}
		return isSum(arr,i+1,sum,aim)||isSum(arr,i+1,sum+arr[i],aim);
	}
	
	public static boolean money2(int[] arr,int aim) {
		boolean[][]dp=new boolean[arr.length+1][aim+1];//dp[i][j]表示累加了数组中的i个数
		for(int i=0;i<dp.length;i++) {
			dp[i][aim]=true;	
		}
		//dp[arr.length][aim]=true;	
		for(int i=arr.length-1;i>=0;i--) {
			for(int j=aim-1;j>=0;j--) {
				dp[i][j]=dp[i+1][j];
				if(j+arr[i]<=aim) {
					dp[i][j]=dp[i][j]||dp[i+1][j+arr[i]];
				}
		}
	}
		return dp[0][0];
	}
	public static void main(String[]args) {
		int []arr= {3,2,5,9};
		int aim=20;
		System.out.println(money1(arr, aim));
		System.out.println(money2(arr, aim));
	}
}

	
