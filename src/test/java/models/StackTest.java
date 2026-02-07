package test.java.models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import main.java.models.Stack;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void testPushElement() {
        stack.push(5);
        assertEquals(1, stack.size());
        assertEquals(5, stack.peek());
    }

    @Test
    public void testPushMultipleElements() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPopElement() {
        stack.push(10);
        stack.push(20);
        Object resultado = stack.pop();
        assertEquals(20, resultado);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPopEmptyStack() {
        Object resultado = stack.pop();
        assertNull(resultado);
    }

    @Test
    public void testPeekElement() {
        stack.push(5);
        stack.push(10);
        Object resultado = stack.peek();
        assertEquals(10, resultado);
        assertEquals(2, stack.size());
    }

    @Test
    public void testPeekEmptyStack() {
        Object resultado = stack.peek();
        assertNull(resultado);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void testStackWithDifferentTypes() {
        stack.push(5);
        stack.push("texto");
        stack.push(3.14);
        assertEquals(3, stack.size());
        assertEquals(3.14, stack.pop());
        assertEquals("texto", stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    public void testStackFILO() {
        // Test que verifica el comportamiento LIFO (Last In, First Out)
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
}
