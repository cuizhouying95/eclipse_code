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
			//')'���ֱ࣬�ӷ���false
			if(chas[i]==')'&&--status<0) {
				return false;
			}
			if(chas[i]=='(') {
				status++;
			}
		}
		return status==0;
	}
	
	//��������
	// dp[]���Ⱥ��ַ����ĳ���һ��
	//dp[i]����str[0..i]�б������ַ�str[i]��β�������Ч���ų���
	public static int maxLength(String str) {
		if(str==null||str.equals("")) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int[] dp=new int[chas.length];
		int pre=0;
		int res=0;
		for(int i=1;i<chas.length;i++) {
			//chas[i]=='(' ,��Ч�ַ�����Ȼ��')'��β����dp[i]=0
			if(chas[i]==')') {
				pre=i-dp[i-1]-1;
				//str[i]��chas[pre]���һ�ԣ���Ӧ�ð�dp[pre-1]����
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
