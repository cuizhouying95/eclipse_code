package advancedclass_07;

public class Code_03_LCSubsequence {
//动态规划
	//dp[i][j]代表str1[0..i]与str2[0..j]的最长公共子序列长度
	public static int[][] getdp(char[] str1,char[] str2){
		int[][] dp=new int[str1.length][str2.length];
		dp[0][0]=str1[0]==str2[0]?1:0;
		//第一列
		for(int i=1;i<str1.length;i++) {
			dp[i][0]=Math.max(dp[i-1][0], str1[i]==str2[0]?1:0);
		}
		//第一行
		for(int j=1;j<str2.length;j++) {
			dp[0][j]=Math.max(dp[0][j-1], str1[0]==str2[j]?1:0);
		}
		for(int i=1;i<str1.length;i++) {
			for(int j=1;j<str2.length;j++) {
				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				if(str1[i]==str2[j]) {
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j-1]+1);
				}
			}
		}
		return dp;
	}
	
	public static String lcse(String str1,String str2) {
		if(str1==null||str2==null||str1.equals("")||str2.equals("")) {
			return "";
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		int[][] dp=getdp(chs1,chs2);
		int m=chs1.length-1;
		int n=chs2.length-1;
		char[] res=new char[dp[m][n]];
		int index=res.length-1;
		//通过dp求解最长公共子序列的过程就是还原出当时如何求解dp的过程
		while(index>=0) {
			if(n>0&&dp[m][n]==dp[m][n-1]) {
				n--;//向左移动
			}else if(m>0&&dp[m][n]==dp[m-1][n]) {
				m--;//向上移动
			}else {//选择了决策dp[i-1][j-1]+1
				res[index--]=chs1[m];
				m--;
				n--;	
			}
		}
		return String.valueOf(res);		
	}
	
	public static void main(String[] args) {
		String str1 = "A1BC2D3EFGH45I6JK7LMN";
		String str2 = "12OPQ3RST4U5V6W7XYZ";
		System.out.println(lcse(str1, str2));
	}
}
