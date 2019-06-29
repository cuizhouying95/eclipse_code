package advancedclass_06;
import java.util.HashMap;
public class Code_01_CoinsWay {

	public static int coins1(int[]arr,int aim) {
		if(arr==null||arr.length==0||aim<0) {
			return 0;
		}
		return process1(arr,0,aim);
	}
	//int[] arr:不变的变量，面值数组
	//index:可以任意自由使用index及其之后所有的钱
	//aim:目标钱数
	//返回值：方法数
	public static int process1(int[]arr,int index,int aim) {
		int res=0;
		if(index==arr.length) {
		 res=aim==0?1:0;
		}else {
			for(int i=0;arr[index]*i<=aim;i++) {
				res+=process1(arr,index+1,aim-arr[index]*i);
			}
		}
		return res;
	}
	
	//key:"index_aim"
	//value:返回值
	public static HashMap<String,Integer> map=new HashMap<>();
	
	public static int process_map(int[] arr,int index,int aim) {
		int res=0;
		if(index==arr.length) {
			res=aim==0?1:0;
		}else {
			for(int zhang=0;arr[index]*zhang<=aim;zhang++) {
				int nextAim=aim-arr[index]*zhang;
				String key=String.valueOf(index+1)+"-"+String.valueOf(nextAim);
				if(map.containsKey(key)) {
					res+=map.get(key);
				}else {
					res+=process_map(arr,index+1,nextAim);
				}
			}
		}
		map.put(String.valueOf(index)+"-"+String.valueOf(aim),res);
		return res;
	}
	
	//动态规划
	
	public static int coins3(int[] arr,int aim) {
		if(arr==null||arr.length==0||aim<0) {
			return 0;
		}
		int[][]dp=new int[arr.length+1][aim+1];
		for(int j=0;j<=aim;j++) {
			if(j==0) {
				dp[arr.length][j]=1;
			}else {
			    dp[arr.length][j]=0;
			}
		}
		int num=0;
		for(int i=arr.length-1;i>=0;i--) {
			for(int j=0;j<=aim;j++) {
				num=0;
				for(int k=0;j-arr[i]*k>=0;k++) {
					num+=dp[i+1][j-arr[i]*k];
				}
				dp[i][j]=num;
			}
		}
		return dp[0][aim];
	}
	//省去了枚举过程
	public static int coins4(int[] arr,int aim) {
		if(arr==null||arr.length==0||aim<0) {
			return 0;
		}
		int[][]dp=new int[arr.length+1][aim+1];
		for(int j=0;j<=aim;j++) {
			if(j==0) {
				dp[arr.length][j]=1;
			}else {
			    dp[arr.length][j]=0;
			}
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			for(int j=0;j<=aim;j++) {
				dp[i][j]=dp[i+1][j];
				dp[i][j]+=j-arr[i]>=0?dp[i][j-arr[i]]:0;
			}
		}
		return dp[0][aim];
	}
	
	public static void main(String[] args) {
		int[] coins = { 5, 10,25,1 };
		int aim =20 ;
		System.out.println(coins1(coins,aim));
		System.out.println(process_map(coins,0,aim));
		System.out.println(coins3(coins,aim));
		System.out.println(coins4(coins,aim));
	}
}
