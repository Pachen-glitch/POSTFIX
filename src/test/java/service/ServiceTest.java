package test.java.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import main.java.service.Service;

public class ServiceTest {
    private Service service;

    @Before
    public void setUp() {
        service = new Service();
    }

    @Test
    public void testPushElement() {
        service.pushElement(5);
        assertEquals(5, service.peekElement());
    }

    @Test
    public void testPopElement() {
        service.pushElement(10);
        Object resultado = service.popElement();
        assertEquals(10, resultado);
    }

    @Test
    public void testPopElementEmptyStack() {
        try {
            service.popElement();
            fail("Debería lanzar RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Error: operandos insuficientes en la expresión postfix", e.getMessage());
        }
    }

    @Test
    public void testPeekElement() {
        service.pushElement(15);
        assertEquals(15, service.peekElement());
    }

    @Test
    public void testSetAndGetData() {
        String datos = "5 3 +";
        service.setData(datos);
        assertEquals(datos, service.getData());
    }

    @Test
    public void testSumaSimple() {
        service.setData("5 3 +");
        service.leerData();
        assertEquals(8, service.getResultado());
    }

    @Test
    public void testRestaSimple() {
        service.setData("10 3 -");
        service.leerData();
        assertEquals(7, service.getResultado());
    }

    @Test
    public void testMultiplicacionSimple() {
        service.setData("5 3 *");
        service.leerData();
        assertEquals(15, service.getResultado());
    }

    @Test
    public void testDivisionSimple() {
        service.setData("15 3 /");
        service.leerData();
        assertEquals(5, service.getResultado());
    }

    @Test
    public void testDivisionEntreCero() {
        service.setData("10 0 /");
        try {
            service.leerData();
            fail("Debería lanzar ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("División entre cero", e.getMessage());
        }
    }

    @Test
    public void testOperacionCompleja1() {
        // (5 + 3) * 2 = 16
        service.setData("5 3 + 2 *");
        service.leerData();
        assertEquals(16, service.getResultado());
    }

    @Test
    public void testOperacionCompleja2() {
        // ((10 - 3) * 2) + 5 = 19
        service.setData("10 3 - 2 * 5 +");
        service.leerData();
        assertEquals(19, service.getResultado());
    }

    @Test
    public void testTokenInvalido() {
        service.setData("5 3 @");
        try {
            service.leerData();
            fail("Debería lanzar RuntimeException");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Token inválido"));
        }
    }

    @Test
    public void testOperandosInsuficientes() {
        service.setData("5 +");
        try {
            service.leerData();
            fail("Debería lanzar RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Error: operandos insuficientes en la expresión postfix", e.getMessage());
        }
    }

    @Test
    public void testNumeroNegativo() {
        service.setData("-5 3 +");
        service.leerData();
        assertEquals(-2, service.getResultado());
    }

    @Test
    public void testImprimirResultado() {
        service.setData("5 3 +");
        service.leerData();
        Object resultado = service.imprimirResultado();
        assertEquals(8, resultado);
    }

    @Test
    public void testSetAndGetResultado() {
        service.setResultado(42);
        assertEquals(42, service.getResultado());
    }

    @Test
    public void testOperacionesMultiples() {
        // Primera operación
        service.setData("10 5 +");
        service.leerData();
        assertEquals(15, service.getResultado());
        service.imprimirResultado();
        
        // Segunda operación
        service.setData("20 4 -");
        service.leerData();
        assertEquals(16, service.getResultado());
    }
}
