package advancedclass_05;
import java.util.LinkedList;
public class Code_07_ExpressionCompute {

	public static int getValue(String str) {
		return value(str.toCharArray(),0)[0];
	}
	//返回值为数组，长度为2
	//arr[0]代表计算结果
	//arr[1]代表计算到的位置
	public static int[] value(char[] str,int i) {
		LinkedList<String> que=new LinkedList<String>();
		int pre=0;
		int[] bra=null;
		while(i<str.length&&str[i]!=')') {
			if(str[i]>='0'&&str[i]<='9') {
				pre=pre*10+str[i++]-'0';//收集数字
			}else if(str[i]!='(') {//遇到加减乘除
				addNum(que,pre);
				que.addLast(String.valueOf(str[i++]));
				pre=0;
			}else {//遇到左括号
				bra=value(str,i+1);
				pre=bra[0];
				i=bra[1]+1;
			}
		}
		addNum(que,pre);
		return new int[] {getNum(que),i};
	}
	
	public static void addNum(LinkedList<String> que, int num) {
		if(!que.isEmpty()) {
			int cur=0;
			String top=que.pollLast();
			if(top.equals("+")||top.equals("-")) {
				que.addLast(top);
			}else {
				cur=Integer.valueOf(que.pollLast());
				num=top.equals("*")?(cur*num):(cur/num);
			}
		}
		que.addLast(String.valueOf(num));
	}
	
	public static int getNum(LinkedList<String> que) {//队列中的数字之和
		int res=0;
		boolean add=true;
		String cur=null;
		int num=0;
		while(!que.isEmpty()) {
			cur=que.pollFirst();
			if(cur.equals("+")) {
				add=true;
			}else if(cur.equals("-")) {
				add=false;
			}else {
				num=Integer.valueOf(cur);
				res+=add?num:(-num);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String exp = "48*((70-65)-43)+8*1";
		System.out.println(getValue(exp));
	}
}
