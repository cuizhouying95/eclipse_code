package class_08;

import java.util.HashSet;

public class Code_04_Print_All_Permutations {

	public static void printAllPermutations1(String str) {
		char[] chs=str.toCharArray();
		process1(chs,0);
	}
	
	public static void process1(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		for (int j = i; j < chs.length; j++) {
			swap(chs, i, j);//将第一个字符与后面的字符交换
			process1(chs, i + 1);//对后面所有的字符进行全排列
			swap(chs, i, j);//再将之前交换的字符交换回来，以便第一个字符再与其他字符交换
		}
	}
	
	public static void printAllPermutations2(String str) {
		char[] chs = str.toCharArray();
		process2(chs, 0);
	}
	
	public static void process2(char[] chs, int i) {//不包含重复的排列
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		HashSet<Character> set = new HashSet<>();//用set来查看是否有重复元素
		for (int j = i; j < chs.length; j++) {
			if (!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs, i, j);
				process2(chs, i + 1);
				swap(chs, i, j);
			}
		}
	}
	
	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}
	public static void main(String[] args) {
		String test1 = "abc";
		printAllPermutations1(test1);
		System.out.println("======");
		printAllPermutations2(test1);
		System.out.println("======");

		String test2 = "aa";
		printAllPermutations1(test2);
		System.out.println("======");
		printAllPermutations2(test2);
		System.out.println("======");
	}
}
