/*
POSTIFX CALCULADORA
JORGE MARTINEZ CAMBARA
QUIQUE BRAN

Es una calculadora simple de postfix, el usuario ingresa una expresión en formato postfix y el programa devuelve el resultado de la operación.
El programa se compone de tres clases principales: App, controlador y Service.
La clase App es la clase principal que se encarga de recibir la expresión postfix del usuario, enviar los datos al controlador, procesar los datos y mostrar el resultado.
La clase controlador es la clase que se encarga de recibir los datos de la clase App, procesar los datos y enviar el resultado a la clase App.
La clase Service es la clase que se encarga de realizar las operaciones matemáticas y manejar la
pila de operandos.

Para crear el stack se creo una clase Stack que utiliza un Vector para almacenar los elementos de la pila. La clase Stack tiene métodos para agregar elementos a la pila (push), eliminar elementos de la pila (pop), obtener el elemento superior de la pila (peek), verificar si la pila está vacía (isEmpty) y obtener el tamaño de la pila (size).



*/

package main.java.view;

import java.util.Scanner;
import main.java.controller.controlador;

public class App {
    private controlador controlador;

    public App() {
        this.controlador = new controlador();
    }

    public void recibirPostfix() {
        Scanner scanner = new Scanner(System.in);
        String expresionPostfix="";
        while (expresionPostfix!="exit") {
        System.out.println("Ingrese la expresión postfix (números y operadores separados por espacio):");
        System.out.println("Ingrese exit para finalizar el programa.");
        expresionPostfix = scanner.nextLine();

        if (expresionPostfix.equals("exit")) {
            System.out.println("Programa finalizado.");
            scanner.close();
            break;
            
            



            
        }else

            // Enviar datos al controlador
            controlador.leerData(expresionPostfix);
            // Procesar los datos
            controlador.procesarData();
            
            // Obtener y mostrar el resultado
            Object resultado = controlador.imprimirResultado();
            System.out.println("Resultado: " + resultado);
            
            }
            
        
    }
  
    public static void main(String[] args) throws Exception {
        App app = new App();
        app.recibirPostfix();
    }
}
