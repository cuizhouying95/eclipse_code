package advancedclass_07;

public class Code_06_PalindromeMinCut {

	public static int minCut(String str) {
		  if(str==null||str.equals("")) {
			  return 0;
		  }
		  char[] chas=str.toCharArray();
		  int len=chas.length;
		  //dp[i]代表子串str[i..len+1]至少需要切割几次，
		  //才能把str[i..len+1]全部切成回文子串
		  int[] dp=new int[len+1];
		  //p[i][j]为true,字符串str[i..j]是回文串
		  //p[i][j]为true,一定是以下三种情况
		  //str[i..j]有一个字符组成
		  //str[i..j]有2个字符组成且两个字符相等
		  //str[i+1..j-1]为回文串，且str[i]==str[j]
		  boolean[][]p=new boolean[len][len];
		  for(int i=len-1;i>=0;i--) {
			  dp[i]=Integer.MAX_VALUE;
			  for(int j=i;j<len;j++) {
				  if(chas[i]==chas[j]&&(j-i<2||p[i+1][j-1])) {
					  p[i][j]=true;
					  dp[i]=Math.min(dp[i], dp[j+1]+1);
				  }
			  }  
		  }
		  return dp[0];
	}
	// for test
		public static String getRandomStringOnlyAToD(int len) {
			int range = 'D' - 'A' + 1;
			char[] charArr = new char[(int) (Math.random() * (len + 1))];
			for (int i = 0; i != charArr.length; i++) {
				charArr[i] = (char) ((int) (Math.random() * range) + 'A');
			}
			return String.valueOf(charArr);
		}

		public static void main(String[] args) {
			int maxLen = 10;
			int testTimes = 5;
			String str = null;
			for (int i = 0; i != testTimes; i++) {
				str = getRandomStringOnlyAToD(maxLen);
				System.out.print("\"" + str + "\"" + " : ");
				System.out.println(minCut(str));
			}
		}
}
