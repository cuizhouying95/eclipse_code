package advancedclass_07;

public class Code_08_ParenthesesProblem {

	public static boolean isValid(String str) {
		if(str==null||str.equals("")) {
			return false;
		}
		char[] chas=str.toCharArray();
		int status=0;
		for(int i=0;i<chas.length;i++) {
			if(chas[i]!=')'&&chas[i]!='(') {
				return false;
			}
			//')'更多，直接返回false
			if(chas[i]==')'&&--status<0) {
				return false;
			}
			if(chas[i]=='(') {
				status++;
			}
		}
		return status==0;
	}
	
	//补充问题
	// dp[]长度和字符串的长度一样
	//dp[i]代表str[0..i]中必须以字符str[i]结尾的最长的有效括号长度
	public static int maxLength(String str) {
		if(str==null||str.equals("")) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int[] dp=new int[chas.length];
		int pre=0;
		int res=0;
		for(int i=1;i<chas.length;i++) {
			//chas[i]=='(' ,有效字符串必然以')'结尾，故dp[i]=0
			if(chas[i]==')') {
				pre=i-dp[i-1]-1;
				//str[i]与chas[pre]配成一对，还应该吧dp[pre-1]加上
				if(pre>=0&&chas[pre]=='(') {
					dp[i]=dp[i-1]+2+(pre>0?dp[pre-1]:0);
				}
			}
			res=Math.max(res, dp[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String str1 = "((())())";
		System.out.println(isValid(str1));
		System.out.println(maxLength(str1));
	}
}
