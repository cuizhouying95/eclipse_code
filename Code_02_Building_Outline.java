package advancedclass_02;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
public class Code_02_Building_Outline {
	public static class Node {
		public boolean be;
		public int p;
		public int h;

		public Node(boolean bORe, int position, int height) {
			be = bORe;
			p = position;
			h = height;
		}
	}

	public static class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			if (o1.p != o2.p) {//按位置排序，同一位置，先排上，再排下
				return o1.p - o2.p;
			}
			if (o1.be != o2.be) {
				return o1.be ? -1 : 1;
			}
			return 0;
		}
	}

	public static List<List<Integer>> buildingOutline(int[][] buildings) {
		Node[] nodes = new Node[buildings.length * 2];
		for (int i = 0; i < buildings.length; i++) {//n座大楼，生成2*n条信息
			nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
			nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
		}
		Arrays.sort(nodes, new NodeComparator());
		TreeMap<Integer, Integer> htMap = new TreeMap<>();//key:某高度，value:有几条
		TreeMap<Integer, Integer> pmMap = new TreeMap<>();//key:某位置，value:最大高度
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].be) {
				if (!htMap.containsKey(nodes[i].h)) {
					htMap.put(nodes[i].h, 1);
				} else {//上+1
					htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
				}
			} else {
				if (htMap.containsKey(nodes[i].h)) {
					if (htMap.get(nodes[i].h) == 1) {
						htMap.remove(nodes[i].h);
					} else {//下-1
						htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
					}
				}
			}
    	 if(htMap.isEmpty()) {
    		 pmMap.put(nodes[i].p, 0);
    	 }else {
    		 pmMap.put(nodes[i].p, htMap.lastKey());
    	 }
     }
		List<List<Integer>> res=new ArrayList();
		int start=0;
		int height=0;
		for(Entry<Integer,Integer> entry:pmMap.entrySet()) {
			int curPosition=entry.getKey();
			int curMaxHeight=entry.getValue();
			if(height!=curMaxHeight) {
				if(height!=0) {
					List<Integer> newRecord=new ArrayList<Integer>();
					newRecord.add(start);
					newRecord.add(curPosition);
					newRecord.add(height);
					res.add(newRecord);
				}
				start=curPosition;
				height=curMaxHeight;
			}
		}
		return res;
     }
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 3 }, { 2, 4, 4 }, { 5,6,1 }};
		List bu=buildingOutline(matrix);
		System.out.println(bu);//[[1, 2, 3], [2, 4, 4], [5, 6, 1]]
    }
}
    
