package basic_class_02;

public class Code_02_KMP_Subpinjie {

	public static String answer(String str) {
		if(str==null||str.length()==0) {
			return "F";
		}
		char[] chas=str.toCharArray();
		if(chas.length==1) {
			return "F";
		}
		
		int lensub=SubLength(chas);
		if(lensub==0) {
			return "F";
		}
		return str.substring(0,lensub);
	}
	
	public static int SubLength(char[] chas) {
		int[] next=new int[chas.length+1];//注意
		next[0]=-1;
		next[1]=0;
		int pos=2;
		int cn=0;
		while(pos<next.length) {
			if(chas[pos-1]==chas[cn]) {
				next[pos++]=++cn;
			}else if (cn>0) {
				cn=next[cn];
			}else {
				next[pos++]=0;
			}
		}
		int lensub=chas.length-next[next.length-1];//举例可推出
		
		return (lensub!=chas.length&&chas.length%lensub==0)?lensub:0;
	}
	
	public static void main(String[] args) {
		String test1 = "a";
		System.out.println(answer(test1));

		String test2 = "aa";
		System.out.println(answer(test2));

		String test3 = "abcabc";
		System.out.println(answer(test3));

		String test4 = "abcabcab";
		System.out.println(answer(test4));

		String test5 = "abcabcabcabb";
		System.out.println(answer(test5));

	}
}
