package com.postfix.models;

import java.util.Vector;

public class Stack {
    private Vector<Object> stack;
    private int size;

    public Stack() {
        stack = new Vector<Object>();
        size = 0;
    }
    public void push(Object element) {
        stack.add(element);
        size++;
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }
        size--;
        return stack.remove(size);
    }
    
    public Object peek() {
        if (size == 0) {
            return null;
        }
        return stack.get(size - 1);
    }

}
