package main.java.models.interfaz;

public interface  StackInterfaz<T> {
    void push(T element);
    T pop();
    T peek();
    int size();


    
}
