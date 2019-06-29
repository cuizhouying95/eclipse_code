package advancedclass_06;

public class Code_05_LongestSubarrayLessSumAwesomeSolution {

	public static int maxLengthAwesome(int[] arr,int aim) {
		if(arr==null||arr.length==0) {
			return 0;
		}
		int[] sums=new int[arr.length];
		int[] ends=new int[arr.length];;
		//从后向前
		//sums[],以该位置为开头的子数组的最小累加和
		//ends[]获得这个最小累加和的右边界
		sums[arr.length-1]=arr[arr.length-1];
		ends[arr.length-1]=arr.length-1;
		
		for(int i=arr.length-2;i>=0;i--) {
			if(sums[i+1]<0) {
				sums[i]=arr[i]+sums[i+1];
				ends[i]=ends[i+1];
			}else {
				sums[i]=arr[i];
				ends[i]=i;
			}
		}
		
		int R=0;
		int sum=0;
		int len=0;
		for(int start=0;start<arr.length;start++) {
			while(R<arr.length&&sum+sums[R]<=aim) {
				sum+=sums[R];
				R=ends[R]+1;
			}
			sum-=R>start?arr[start]:0;
			len=Math.max(len, R-start);
			R=Math.max(R, start+1);
		}
		return len;
	}
	public static void main(String[] args) {
		int[] arr = { 5, -10,-25,10 };
		int aim =6 ;
		System.out.println(maxLengthAwesome(arr,aim));
	}
	
}
