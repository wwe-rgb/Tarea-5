package ico.fes.aragon.unam.mx.clases;

public class nodoNoble<T> {
    T data;
    private nodoNoble<T> siguiente;
    private nodoNoble<T> anterior;
    public nodoNoble(){

    }

    public nodoNoble(T data) {
        this.data = data;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public nodoNoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoNoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public nodoNoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoNoble<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return data+"|-> |";
    }
}