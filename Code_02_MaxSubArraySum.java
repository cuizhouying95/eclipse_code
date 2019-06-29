package advancedclass_08;

public class Code_02_MaxSubArraySum {

	public static int maxSum(int[] arr) {
		if(arr==null||arr.length==0) {
			return 0;
		}
		int max=Integer.MIN_VALUE;
		int cur=0;
		for(int i=0;i<arr.length;i++) {
			cur+=arr[i];
			max=Math.max(max, cur);
	//当cur<0时，说明累加到当前数出现小于0的结果，
  //那么累加的这一部分肯定不能作为产生最大累加和的子数组的左边部分
			cur=cur<0?0:cur;
		}
		return max;
	}
}
