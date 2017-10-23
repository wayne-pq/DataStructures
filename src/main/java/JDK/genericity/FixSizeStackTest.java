package JDK.genericity;

public class FixSizeStackTest<T> {
    public static void main(String[] args) {
        FixSizeStack<Integer> integerFixSizeStack = new FixSizeStack<>(1);
        integerFixSizeStack.push(1);
        Integer pop = integerFixSizeStack.pop();
    }
}
