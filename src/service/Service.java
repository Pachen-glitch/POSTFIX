package service;


import javax.lang.model.element.Element;
import models.Stack;

public class Service {
    private  Stack stack= new Stack();
    private String data;
    private int resultado;

    public Service() {

        
    }
    public void pushElement(Object element) {
        stack.push(element);
    }
    public Object popElement() {
    if (stack.isEmpty()) {
        throw new RuntimeException("Error: operandos insuficientes en la expresión postfix");
    }
    return stack.pop();
}
    public Object peekElement() {
        return stack.peek();
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public int getResultado() {
        return resultado;
    }
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    public void leerData() {
        String[] elements = data.split(" ");
        for (String element : elements) {
            System.out.println("Procesando elemento: " + element);
            if (element.equals("+")){
                int a = (int) popElement();
                int b = (int) popElement();
                resultado = a + b;
                pushElement(resultado);
            } else if (element.equals("-")){
                int a = (int) popElement();
                int b = (int) popElement();
                resultado = b - a;
                pushElement(resultado);
            } else if (element.equals("*")){
                int a = (int) popElement();
                int b = (int) popElement();
                resultado = a * b;
                pushElement(resultado);
            } else if (element.equals("/")){
                int a = (int) popElement();
                int b = (int) popElement();
                 if (a == 0) {
                throw new ArithmeticException("División entre cero");
            }
                resultado = b / a;
                pushElement(resultado);
            } else {
                
                    try {
                        int numero = Integer.parseInt(element);
                        pushElement(numero);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("Token inválido " + element);
                    }
            }
            
        }
    }
    public Object imprimirResultado() {
        Object resultado = peekElement();
        stack.pop();//vacia la pila para otra operacion
        return resultado;

    }   


}
