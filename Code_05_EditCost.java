package advancedclass_07;

public class Code_05_EditCost {
     //时间复杂度O(M*N) 额外空间复杂度为O(M*N)
	//dp的大小为(M+1)*(N+1)
	//dp[i][j]表示str1[0..i-1]编辑成str2[0..j-1]的最小代价
	public static int minCost1(String str1,String str2,int ic,int dc,int rc) {
		if(str1==null||str2==null) {
			return 0;
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		int row=chs1.length+1;
		int col=chs2.length+1;
		int[][] dp=new int[row][col];
		for(int i=1;i<row;i++) {
			dp[i][0]=dc*i;
		}
		for(int j=1;j<col;j++) {
			dp[0][j]=ic*j;
		}
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(chs1[i-1]==chs2[j-1]) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					dp[i][j]=dp[i-1][j-1]+rc;
				}
				dp[i][j]=Math.min(dp[i][j], dp[i][j-1]+ic);
				dp[i][j]=Math.min(dp[i][j], dp[i-1][j]+dc);
			}
		}
		return dp[row-1][col-1];
	}
	
	public static void main(String[] args) {
		String str1 = "ab12cd3";
		String str2 = "abcdf";
		System.out.println(minCost1(str1, str2, 5, 3, 2));
	}
}
