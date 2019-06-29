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
	//��cur<0ʱ��˵���ۼӵ���ǰ������С��0�Ľ����
  //��ô�ۼӵ���һ���ֿ϶�������Ϊ��������ۼӺ͵����������߲���
			cur=cur<0?0:cur;
		}
		return max;
	}
}
