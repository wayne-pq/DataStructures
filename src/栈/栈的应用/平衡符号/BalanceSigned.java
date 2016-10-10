package 栈.栈的应用.平衡符号;

import java.util.LinkedList;

public class BalanceSigned {
	public static Boolean balanceSigned(String str) {

		boolean b = true;
		LinkedList<Character> list = new LinkedList<Character>();

		char[] chars = str.toCharArray();

		for (char s : chars) {
			if ('(' == s || '[' == s || '{' == s) {
				list.addFirst(s);
			} else if (')' == s || ']' == s || '}' == s) {
				if (list.isEmpty()) {
					b = false;
					break;
				}

				switch (s) {
				case ')':
					if (!list.get(0).equals('(')) {
						b = false;
						break;
					} else {
						list.remove(0);
					}
					continue;
				case ']':
					if (!list.get(0).equals('[')) {
						b = false;
						break;
					} else {
						list.remove(0);
					}
					continue;
				case '}':
					if (!list.get(0).equals('{')) {
						b = false;
						break;
					} else {
						list.remove(0);
					}
					continue;
				}
			}
		}

		if (!list.isEmpty())
			b = false;

		return b;
	}

	public static void main(String[] args) {
		String str = "System.out.println{(\"dsadas\")};";
		Boolean b = balanceSigned(str);
		System.out.println(b);
	}
}
