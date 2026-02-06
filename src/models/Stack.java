package models;

import java.util.Vector;

public class Stack {

    private Vector<Object> stack;

    public Stack() {
        this.stack = new Vector<>();
    }

    public void push(Object element) {
        stack.add(element);
    }

    public Object pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public Object peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
