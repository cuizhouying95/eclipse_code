package class_07;


public class Code_01_TrieTree {

	public static class TrieNode{
		public int path;//表示有多少个单词共用这个节点
		public int end;//表示有多少个单词以这个节点结尾
		public TrieNode[] map;//map是一个哈希表结构，key代表该节点的一条字符路径，value表示字符路径指向的节点
		
		public TrieNode () {
			path=0;
			end=0;
			map=new TrieNode[26];
		}
	}
	
	public static class Trie{
		private TrieNode root;
		
		public Trie() {
			root=new TrieNode();
		}
		
		public void insert(String word) {
			if(word==null) {
				return;
			}
			char[] chs=word.toCharArray();
			TrieNode node=root;
			int index=0;
			for(int i=0;i<chs.length;i++) {
				index=chs[i]-'a';
				if(node.map[index]==null) {
					node.map[index]=new TrieNode();
				}
				node=node.map[index];
				node.path++;
			}
			node.end++;
		}
		
		public boolean search(String word) {
			if(word==null) {
				return false;
			}
			char[] chs=word.toCharArray();
			TrieNode node=root;
			int index=0;
			for(int i=0;i<chs.length;i++) {
				index=chs[i]-'a';
				if(node.map[index]==null) {
					return false;
				}
				node=node.map[index];			
			}
			return node.end!=0;
		}
		
		public void delete(String word) {
			if (search(word)) {
				char[] chs=word.toCharArray();
				TrieNode node=root;
				int index=0;
				for(int i=0;i<chs.length;i++) {
					index=chs[i]-'a';
					if(node.map[index].path--==1) {
						node.map[index]=null;
						return ;
					}
					node=node.map[index];			
				}
				node.end--;
			}
			}
		public int prefixNumber(String pre) {
			if(pre==null) {
				return 0;
			}
			char[] chs=pre.toCharArray();
			TrieNode node=root;
			int index=0;
			for(int i=0;i<chs.length;i++) {
				index=chs[i]-'a';
				if(node.map[index]==null) {
					return 0;
				}
				node=node.map[index];
		}
			return node.path;
		
	}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}
	
		
}
