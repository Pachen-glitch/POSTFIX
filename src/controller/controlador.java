package controller;
import service.Service;

public class controlador {

    private Service service;

    public controlador() {
        this.service = new Service();
    }

    public void leerData(String data) {
        service.setData(data);
    }

    public void procesarData() {
        service.leerData();
    }

    public Object imprimirResultado() {
        return service.imprimirResultado();
    }
            




    
    
}
