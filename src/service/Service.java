package service;




public class Service {
    private Stack stack= new Stack();
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


    
}
