package advancedclass_08;

public class Code_03_MaxOneBorderSize {
    //时间复杂度O(N^3)
	//预处理矩阵
	public static void setBorderMap(int[][] m,int[][] right,int[][] down) {
		int r=m.length;
		int c=m[0].length;
		//right[i][j]的值表示从位置(i,j)出发向右，有多少个连续的1
		//down[i][j]的值表示从位置(i,j)出发向下，有多少个连续的1
		if(m[r-1][c-1]==1) {
			right[r-1][c-1]=1;
			down[r-1][c-1]=1;
		}
		//从矩阵的右下角开始向上计算
		for(int i=r-2;i!=-1;i--) {
			if(m[i][c-1]==1) {
				right[i][c-1]=1;
				down[i][c-1]=down[i+1][c-1]+1;
			}
		}
		//从矩阵的右下角开始向左计算
		for(int i=c-2;i!=-1;i--) {
			if(m[r-1][i]==1) {
				right[r-1][i]=right[r-1][i+1]+1;
				down[r-1][i]=1;
			}
		}
		//剩下的位置
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
		//边长从大到小
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
				if(right[i][j]>=size&&down[i][j]>=size//正方形的左上角
					&& right[i+size-1][j]>=size//左下角
					&& down[i][j+size-1]>=size){//右上角
						return true;
					}
			}
		}
		return false;
	}
}
