package advancedclass_06;
public class RobotPath {
    //��̬�滮
	//����������������ߣ�����ԭ�ز���
	//N һ����1~N��λ��
	//curPosition ������λ��
	//restSteps �����ߵĲ���
	//K ����ͣ�ڵ�λ��
	//����ֵ��һ���ж������߷�
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
