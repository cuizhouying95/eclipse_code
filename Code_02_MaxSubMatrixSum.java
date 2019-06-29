package advancedclass_08;

public class Code_02_MaxSubMatrixSum {

	public static int maxSum(int[][] m) {
		if(m==null||m.length==0||m[0].length==0) {
			return 0;
		}
		int max=Integer.MIN_VALUE;
		int cur=0;
		int[]s=null;//累加数组
		for(int i=0;i!=m.length;i++) {
			s=new int[m[0].length];
			//以每一行为开头的往下所有的子矩阵
			for(int j=i;j!=m.length;j++) {
				cur=0;
		//用求子数组的最大累加和的方式得到每一步的最大子矩阵的累加和
				for(int k=0;k!=s.length;k++) {
		//利用前一步求出的累加数组			
					s[k]+=m[j][k];
					cur+=s[k];
					max=Math.max(max, cur);
					cur=cur<0?0:cur;
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
		System.out.println(maxSum(matrix));
	}
}
