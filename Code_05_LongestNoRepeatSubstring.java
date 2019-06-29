package advancedclass_08;

public class Code_05_LongestNoRepeatSubstring {

	public static int maxUnique(String str) {
		if(str==null||str.equals("")) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int[] map=new int[256];
	//map(str[i])��ֵ��ʾ��֮ǰ�ı��������һ�γ���str[i]�ַ���λ��	
		for(int i=0;i<256;i++) {
			map[i]=-1;
		}
		int len=0;
	//������str[i],pre��ʾ��str[i-1]��β������£�
	//����ظ��ַ��Ӵ���ʼλ�õ�ǰһ��λ��
		int pre=-1;
		int cur=0;
		for(int i=0;i!=chas.length;i++) {
			pre=Math.max(pre, map[chas[i]]);
			cur=i-pre;
			len=Math.max(len,cur);
			map[chas[i]]=i;
		}
		return len;
	}
	public static void main(String[] args) {
		String str = "abcvda";
		System.out.println(maxUnique(str));
	}
}
