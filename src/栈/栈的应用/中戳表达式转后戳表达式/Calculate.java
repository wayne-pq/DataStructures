package 栈.栈的应用.中戳表达式转后戳表达式;

import java.util.LinkedList;

/**
 * 根据后戳表达式进行计算
 * 
 * @author panqian
 *
 */
public class Calculate {

	public static Integer calculate(String exp) {
		LinkedList<String> characters = new LinkedList<String>();

		char[] chars = exp.toCharArray();

		for (char c : chars) {
			if (Expression.isoperator(c) == 0)
				characters.addFirst(Character.toString(c));
			else{
			Integer first = Integer.valueOf(characters.removeFirst());
			Integer second = Integer.valueOf(characters.removeFirst());
			switch (c) {
			case '+':
				characters.addFirst(((Integer)(second+first)).toString());
				break;
			case '-':
				characters.addFirst(((Integer)(second-first)).toString());
				break;
			case '*':
				characters.addFirst(((Integer)(second*first)).toString());
					break;
				default:
					break;
				}
			}
		}
		
		String str = characters.getFirst();
		return Integer.valueOf(str);
	}
	
	public static void main(String[] args) {
		String s = "1+2*3+4*5-6*7";
		String operation = Expression.operation(s);
		Integer calculate = calculate(operation);
		System.out.println(calculate);
	}
}
