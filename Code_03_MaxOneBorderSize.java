package advancedclass_08;

public class Code_03_MaxOneBorderSize {
    //ʱ�临�Ӷ�O(N^3)
	//Ԥ�������
	public static void setBorderMap(int[][] m,int[][] right,int[][] down) {
		int r=m.length;
		int c=m[0].length;
		//right[i][j]��ֵ��ʾ��λ��(i,j)�������ң��ж��ٸ�������1
		//down[i][j]��ֵ��ʾ��λ��(i,j)�������£��ж��ٸ�������1
		if(m[r-1][c-1]==1) {
			right[r-1][c-1]=1;
			down[r-1][c-1]=1;
		}
		//�Ӿ�������½ǿ�ʼ���ϼ���
		for(int i=r-2;i!=-1;i--) {
			if(m[i][c-1]==1) {
				right[i][c-1]=1;
				down[i][c-1]=down[i+1][c-1]+1;
			}
		}
		//�Ӿ�������½ǿ�ʼ�������
		for(int i=c-2;i!=-1;i--) {
			if(m[r-1][i]==1) {
				right[r-1][i]=right[r-1][i+1]+1;
				down[r-1][i]=1;
			}
		}
		//ʣ�µ�λ��
		for(int i=r-2;i!=-1;i--) {
			for(int j=c-2;j!=-1;j--) {
				if(m[i][i]==1) {
					right[i][j]=right[i][j+1]+1;
					down[i][j]=down[i+1][j]+1;
				}
			}
		}
	}
	
	public static int getMaxSize(int[][] m) {
		int[][] right=new int[m.length][m[0].length];
		int[][] down=new int[m.length][m.length];
		setBorderMap(m,right,down);
		//�߳��Ӵ�С
		for(int size=Math.min(m.length, m[0].length);size!=0;size--) {
			if(hasSizeOfBorder(size,right,down)) {
				return size;
			}
		}
		return 0;
	}
	
	public static boolean hasSizeOfBorder(int size,int[][] right,int[][] down) {
		for(int i=0;i!=right.length-size+1;i++) {
			for(int j=0;i!=right[0].length-size+1;j++) {
				if(right[i][j]>=size&&down[i][j]>=size//�����ε����Ͻ�
					&& right[i+size-1][j]>=size//���½�
					&& down[i][j+size-1]>=size){//���Ͻ�
						return true;
					}
			}
		}
		return false;
	}
}
