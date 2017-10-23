package JDK.genericity;

public class FixSizeStack<T> {
    int i = 0;
    private Object[] objects;

    public FixSizeStack(int size) {
        this.objects = new Object[size];
    }

    public T pop() {
        return (T) objects[--i];
    }

    public void push(T objects) {
        this.objects[i++] = objects;
    }
}
