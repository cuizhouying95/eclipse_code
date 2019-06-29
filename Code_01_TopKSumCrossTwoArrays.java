package advancedclass_08;
import java.util.Arrays;
import java.util.HashSet;
public class Code_01_TopKSumCrossTwoArrays {

	public static class HeapNode{
		public int row;
		public int col;
		public int value;
		
		public HeapNode(int row,int col,int value) {
			this.row=row;
			this.col=col;
			this.value=value;
		}
	}
	
	public static int[] topKSum(int[] a1,int[] a2,int topK) {
		if(a1==null||a2==null||topK<1) {
			return null;
		}
		topK=Math.min(topK, a1.length*a2.length);
		HeapNode[] heap=new HeapNode[topK+1];//×¢ÒâÒª¼Ó1
		int heapSize=0;
		int headR=a1.length-1;
		int headC=a2.length-1;
		int uR=-1;
		int uC=-1;
		int lR=-1;
		int lC=-1;
		heapInsert(heap,heapSize++,headR,headC,a1[headR]+a2[headC]);
		HashSet<String> positionSet=new HashSet<String>();
		int[] res=new int[topK];
		int resIndex=0;
		while(resIndex!=topK) {
			HeapNode head=popHead(heap,heapSize--);
			res[resIndex++]=head.value;
			headR=head.row;
			headC=head.col;
			uR=headR-1;
			uC=headC;
			if(headR!=0&&!isContains(uR,uC,positionSet)) {
				heapInsert(heap,heapSize++,uR,uC,a1[uR]+a2[uC]);
				addPositonToSet(uR,uC,positionSet);
			}
			lR=headR;
			lC=headC-1;
			if(headR!=0&&!isContains(lR,lC,positionSet)) {
				heapInsert(heap,heapSize++,lR,lC,a1[lR]+a2[lC]);
				addPositonToSet(lR,lC,positionSet);
			}
		}
		return res;
	}
	
	public static HeapNode popHead(HeapNode[] heap,int heapSize) {
		HeapNode res=heap[0];
		swap(heap,0,heapSize-1);
		heap[--heapSize]=null;
		heapify(heap,0,heapSize);
		return res;
	}
	
	public static void heapify(HeapNode[] heap,int index,int heapSize) {
		int left=index*2+1;
		int right=index*2+2;
		int largest=index;
		while(left<heapSize) {
			if(heap[left].value>heap[index].value) {
				largest=left;
			}
			if(right<heapSize&&heap[right].value>heap[largest].value) {
				largest=right;
			}
			if(largest!=index) {
				swap(heap,largest,index);
			}else {
				break;
			}
			index=largest;
			left=index*2+1;
			right=index*2+2;
		}
	}
	
	public static void heapInsert(HeapNode[] heap,int index,int row,int col,int value) {
		heap[index]=new HeapNode(row,col,value);
		int parent =(index-1)/2;
		while(index!=0) {
			if(heap[index].value>heap[parent].value) {
				swap(heap,parent,index);
				index=parent;
				parent=(index-1)/2;
			}else {
				break;
			}
		}
	}
	
	public static void swap(HeapNode[] heap,int index1,int index2) {
		HeapNode tmp=heap[index1];
		heap[index1]=heap[index2];
		heap[index2]=tmp;
	}
	
	public static boolean isContains(int row,int col,HashSet<String> set) {
		return set.contains(String.valueOf(row+"_"+col));
	}
	
	public static void addPositonToSet(int row,int col,HashSet<String> set) {
		set.add(String.valueOf(row+"_"+col));
	}
}
