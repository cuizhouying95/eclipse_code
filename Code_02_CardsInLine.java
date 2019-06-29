package advancedclass_06;

public class Code_02_CardsInLine {

	//暴力递归
	public static int win1(int[] arr) {
		if(arr==null||arr.length==0) {
			return 0;
		}
		return Math.max(f(arr,0,arr.length-1),s(arr,0,arr.length-1) );
	}
	//f(i,j)表示如果arr[i...j]上的纸牌被绝顶聪明的人先拿，最终获得的分数
	public static int f(int[]arr,int i,int j) {
		if(i==j) {
			return arr[i];
		}
		return Math.max(arr[i]+s(arr,i+1,j),arr[j]+s(arr,i,j-1));
	}
	//s(i,j)表示如果arr[i...j]上的纸牌被绝顶聪明的人后拿，最终获得的分数
	public static int s(int[]arr,int i,int j) {
		if(i==j) {
			return arr[i];
		}
		return Math.max(f(arr,i+1,j),f(arr,i,j-1));
	}
	//动态规划
	public static int win2(int[] arr) {
		if(arr==null||arr.length==0) {
			return 0;
		}
	//f[i][j]表示函数f的返回值
	//s[i][j]表示函数s的返回值
	//矩阵大小为N*N，i<=j，对角线方向为base case
		int[][]f=new int[arr.length][arr.length];
		int[][]s=new int[arr.length][arr.length];
		for(int j=0;j<arr.length;j++) {
			f[j][j]=arr[j];
			for(int i=j-1;i>=0;i--) {
				f[i][j]=Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
				s[i][j]=Math.max(f[i+1][j], f[i][j-1]);
			}
		}
		return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
	}
	public static void main(String[] args) {
		int[] arr = { 1, 9, 1 };
		System.out.println(win1(arr));
		System.out.println(win2(arr));
	}
}
