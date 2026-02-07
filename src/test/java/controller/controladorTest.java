package test.java.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import main.java.controller.controlador;

public class controladorTest {
    private controlador controlador;

    @Before
    public void setUp() {
        controlador = new controlador();
    }

    @Test
    public void testControladorInitialization() {
        assertNotNull(controlador);
    }

    @Test
    public void testLeerDataSuma() {
        controlador.leerData("5 3 +");
        controlador.procesarData();
        Object resultado = controlador.imprimirResultado();
        assertEquals(8, resultado);
    }

    @Test
    public void testLeerDataResta() {
        controlador.leerData("10 3 -");
        controlador.procesarData();
        Object resultado = controlador.imprimirResultado();
        assertEquals(7, resultado);
    }

    @Test
    public void testLeerDataMultiplicacion() {
        controlador.leerData("5 4 *");
        controlador.procesarData();
        Object resultado = controlador.imprimirResultado();
        assertEquals(20, resultado);
    }

    @Test
    public void testLeerDataDivision() {
        controlador.leerData("20 4 /");
        controlador.procesarData();
        Object resultado = controlador.imprimirResultado();
        assertEquals(5, resultado);
    }

    @Test
    public void testOperacionCompleja() {
        controlador.leerData("10 3 - 2 * 5 +");
        controlador.procesarData();
        Object resultado = controlador.imprimirResultado();
        assertEquals(19, resultado);
    }

    @Test
    public void testDivisionEntreCero() {
        controlador.leerData("10 0 /");
        try {
            controlador.procesarData();
            fail("Debería lanzar ArithmeticException");
        } catch (ArithmeticException e) {
            assertEquals("División entre cero", e.getMessage());
        }
    }

    @Test
    public void testTokenInvalido() {
        controlador.leerData("5 3 @");
        try {
            controlador.procesarData();
            fail("Debería lanzar RuntimeException");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Token inválido"));
        }
    }

    @Test
    public void testOperandosInsuficientes() {
        controlador.leerData("5 +");
        try {
            controlador.procesarData();
            fail("Debería lanzar RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Error: operandos insuficientes en la expresión postfix", e.getMessage());
        }
    }
}
