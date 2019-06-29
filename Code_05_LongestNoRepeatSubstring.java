package advancedclass_08;

public class Code_05_LongestNoRepeatSubstring {

	public static int maxUnique(String str) {
		if(str==null||str.equals("")) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int[] map=new int[256];
	//map(str[i])的值表示在之前的遍历中最近一次出现str[i]字符的位置	
		for(int i=0;i<256;i++) {
			map[i]=-1;
		}
		int len=0;
	//遍历到str[i],pre表示以str[i-1]结尾的情况下，
	//最长无重复字符子串开始位置的前一个位置
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
