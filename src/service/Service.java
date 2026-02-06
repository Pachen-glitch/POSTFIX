package service;


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
            if (element=="+"){
                int a = (int) popElement();
                int b = (int) popElement();
                resultado = a + b;
                pushElement(resultado);
            } else if (element=="-"){
                int a = (int) popElement();
                int b = (int) popElement();
                resultado = b - a;
                pushElement(resultado);
            } else if (element=="*"){
                int a = (int) popElement();
                int b = (int) popElement();
                resultado = a * b;
                pushElement(resultado);
            } else if (element=="/"){
                int a = (int) popElement();
                int b = (int) popElement();
                resultado = b / a;
                pushElement(resultado);
            } else {
                pushElement(element);  
            }
            
        }
    }
    public void imprimirResultado() {
        System.out.println("El resultado es: " + resultado);
    }   


}
