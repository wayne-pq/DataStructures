package 栈.栈的应用.平衡符号;

import java.util.Stack;
/**
 * 栈也是一种表， 后进先出
 * 插入和删除只能在一个位置进行，该位置是栈顶。push入栈  pop出栈
 * @author panqian
 *
 */
public class BalanceSigned {
	public static Boolean balanceSigned(String str) {

		boolean b = true;
		
		Stack<Character> list = new Stack<Character>();

		char[] chars = str.toCharArray();

		for (char s : chars) {
			if ('(' == s || '[' == s || '{' == s) {
				list.push(s);
			} else if (')' == s || ']' == s || '}' == s) {
				if (list.empty()) {
					b = false;
					break;
				}

				switch (s) {
				case ')':
					if (!list.peek().equals('(')) {
						b = false;
						break;
					} else {
						list.pop();
					}
					continue;
				case ']':
					if (!list.peek().equals('[')) {
						b = false;
						break;
					} else {
						list.pop();
					}
					continue;
				case '}':
					if (!list.peek().equals('{')) {
						b = false;
						break;
					} else {
						list.pop();
					}
					continue;
				}
			}
		}

		if (!list.empty())
			b = false;

		return b;
	}

	public static void main(String[] args) {
		String str = "System.out.println{(\"dsadas\")};";
		Boolean b = balanceSigned(str);
		System.out.println(b);
	}
}
