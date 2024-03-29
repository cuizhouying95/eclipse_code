package advancedclass_07;

public class Code_07_StringCross {

	public static boolean isCross1(String str1,String str2,String aim) {
		if(str1==null||str2==null||aim==null) {
			return false;
		}
		char[] ch1=str1.toCharArray();
		char[] ch2=str2.toCharArray();
		char[] chaim=aim.toCharArray();
		if(chaim.length!=ch1.length+ch2.length) {
			return false;
		}
		boolean[][] dp=new boolean[ch1.length+1][ch2.length+1];
		dp[0][0]=true;
		for(int i=1;i<=ch1.length;i++) {
			if(ch1[i-1]!=chaim[i-1]) {
				break;
			}
			dp[i][0]=true;
		}
		for(int j=1;j<=ch2.length;j++) {
			if(ch2[j-1]!=chaim[j-1]) {
				break;
			}
			dp[0][j]=true;
		}
		for(int i=1;i<=ch1.length;i++) {
			for(int j=1;j<=ch2.length;j++) {
				if((ch1[i-1]==chaim[i+j-1]&&dp[i-1][j])
						||(ch2[j-1]==chaim[i+j-1]&&dp[i][j-1])) {
					dp[i][j]=true;
				}
			}
		}
		return dp[ch1.length][ch2.length];
	}
	
	public static void main(String[] args) {
		String str1 = "1234";
		String str2 = "abcd";
		String aim = "1a23bcd4";
		System.out.println(isCross1(str1, str2, aim));
	}
}
