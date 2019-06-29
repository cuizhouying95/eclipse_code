package class_07;

import java.util.Arrays;//注意导入这两行
import java.util.Comparator;//比较器接口

public class Code_06_BestArrange {

	public static class Program {
		
		public String name;
		public int start;
		public int end;

		public Program( String name,int start, int end) {
			this.name = name;
			this.start = start;
			this.end = end;
		}
	}

	public static class ProgramComparator implements Comparator <Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (start <= programs[i].start) {
				result++;
				start = programs[i].end;
			}
		}
		return result;
	}

	
	public static void main(String[] args) {
		Program program1 = new Program("a",11, 13);
		Program program2 = new Program("b",14, 17);
		Program program3 = new Program("c",18,23);
		Program[] programs = new Program[] {program1, program2, program3 };
		System.out.println(bestArrange(programs,9));
	}
}
