package advancedclass_02;
import java.util.Stack;
public class Code_04_zijuzhen {//������Ӿ���Ĵ�С
	public static int maxRecSize(int[][] map ) {
		if(map==null||map.length==0||map[0].length==0) {
			return 0;
		}
		int maxArea=0;
		int[] height=new int[map[0].length];
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				height[j]=map[i][j]==0?0:height[j]+1;
			}
			maxArea=Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}
	
	public static int maxRecFromBottom(int[] height) {//��ֱ��ͼ�ҵ�������
		if(height==null||height.length==0) {
			return 0;
		}
		int maxArea=0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<height.length;i++) {
			while(!stack.isEmpty()&&height[i]<=height[stack.peek()]) {
				int j=stack.pop();
				int k=stack.isEmpty()?-1:stack.peek();//��߽�
				int curArea=(i-k-1)*height[j];
				maxArea=Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {//������ջ��ʣ���Ԫ��
			int j=stack.pop();
			int k=stack.isEmpty()?-1:stack.peek();
			int curArea=(height.length-k-1)*height[j];//�ұ߽�Ϊheight.length
			maxArea=Math.max(maxArea, curArea);
		}
		return maxArea;
	}
	
	 public static void main(String[] args) {
		 int[][]arr= {{1,0,1,1},
				 {1,1,1,1},
				 {1,1,1,0},};
		 System.out.println(maxRecSize(arr));	 
		 
		 }
	 }

