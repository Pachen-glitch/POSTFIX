package models;

import java.util.Vector;
import javax.lang.model.element.Element;

public class Stack {
    private Vector<Object> stack;
    private int size;



    public Stack() {
        Vector<Object> stack = new Vector<Object>();

    }
    void  push(Object element) {
        stack.add(element);
        size++;
    }

    Element pop() {
        if (size == 0) {
            return null;
        }
        size--;
        return (Element) stack.remove(size);
    }
    Element peek() {
        if (size == 0) {
            return null;
        }
        return (Element) stack.get(size - 1);
    }

}
