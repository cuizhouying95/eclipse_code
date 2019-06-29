package advancedclass_06;
public class RobotPath {
    //动态规划
	//可以向左或者向右走，不能原地不动
	//N 一共有1~N个位置
	//curPosition 来到的位置
	//restSteps 可以走的步数
	//K 最终停在的位置
	//返回值：一共有多少种走法
	public static int ways(int N,int curPosition,int restSteps,int K) {
		if(N<2||curPosition<1||curPosition>N||restSteps<0||K<1||K>N) {
			return 0;
		}
		if(restSteps==0) {
			return curPosition==K?1:0;
		}
		int res=0;
		if(curPosition==1) {
			res=ways(N,curPosition+1,restSteps-1, K);
		}else if(curPosition==N) {
			res=ways(N,curPosition-1,restSteps-1, K);
		}else {
			res=ways(N,curPosition+1,restSteps-1, K)+ways(N,curPosition-1,restSteps-1, K);;
		}
		return res;
	}
}
