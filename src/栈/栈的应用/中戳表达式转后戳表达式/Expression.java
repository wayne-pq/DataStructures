package 栈.栈的应用.中戳表达式转后戳表达式;

import java.util.LinkedList;

/**
 * 将标准形式的数学表达式（中戳表达式）转换成可以程序计算的后戳表达式(逆波兰式),现在还只支持个位数,除法也暂不支持
 * 
 * @author panqian
 *
 */
public class Expression {
	public static int isoperator(char op) {
		switch (op) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '(':
		case ')':
			return 1;
		default:
			return 0;
		}
	}

	public static int priority(char op) {
		switch (op) {
		case '#':
			return -1;
		case '(':
		case ')':
			return 3;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return -1;
		}
	}

	public static String operation(String exp) {

		LinkedList<Character> characters = new LinkedList<Character>();

		char[] chars = exp.toCharArray();

		StringBuffer newExp = new StringBuffer();

		for (char c : chars) {
			if (isoperator(c) == 0) {
				newExp.append(c);
			} else {
				if (characters.isEmpty()) {
					characters.addFirst(c);
				} else {
					if (c == ')') {
						while ('(' != characters.getFirst()) {
							newExp.append(characters.removeFirst());
						}
						characters.removeFirst();
						continue;
					}
					while (!characters.isEmpty()) {
						if (priority(characters.getFirst()) >= priority(c)) {
							if ('(' == characters.getFirst()) {
								characters.addFirst(c);
								break;
							}
							newExp.append(characters.removeFirst());
							if (characters.isEmpty()) {
								characters.addFirst(c);
								break;
							}
						} else {
							characters.addFirst(c);
							break;
						}
					}

				}
			}
		}

		while (!characters.isEmpty()) {
			newExp.append(characters.removeFirst());
		}

		return newExp.toString();
	}

	public static void main(String[] args) {
		String s = "a+b*c+(d*e+f)*g";
		String operation = operation(s);
		System.out.println(operation);
	}
}
