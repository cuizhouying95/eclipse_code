package advancedclass_07;

public class Code_06_PalindromeMinCut {

	public static int minCut(String str) {
		  if(str==null||str.equals("")) {
			  return 0;
		  }
		  char[] chas=str.toCharArray();
		  int len=chas.length;
		  //dp[i]�����Ӵ�str[i..len+1]������Ҫ�и�Σ�
		  //���ܰ�str[i..len+1]ȫ���гɻ����Ӵ�
		  int[] dp=new int[len+1];
		  //p[i][j]Ϊtrue,�ַ���str[i..j]�ǻ��Ĵ�
		  //p[i][j]Ϊtrue,һ���������������
		  //str[i..j]��һ���ַ����
		  //str[i..j]��2���ַ�����������ַ����
		  //str[i+1..j-1]Ϊ���Ĵ�����str[i]==str[j]
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
