package controller;
import javax.lang.model.element.Element;
import service.Service;
public class controlador {
    private Service service = new service.Service();
    public void leerData(String data) {
            service.setData(data);}
    public void procesarData() {
        service.leerData();
    }
    public Element imprimirResultado() {
        return service.imprimirResultado();
    }
            




    
    
}
