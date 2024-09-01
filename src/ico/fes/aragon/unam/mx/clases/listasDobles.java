package ico.fes.aragon.unam.mx.clases;

public class listasDobles<T> {
    private nodoNoble<T> head;
    private nodoNoble<T> tail;
    private int direccion;
    private int tamanio;


    public listasDobles() {

    }

    public boolean estaVacia() {
        boolean res = false;

        if (this.head == null && this.tail == null) {


            return true;

        }

        return res;

    }


    public int getTamanio() {
        return tamanio;
    }

    public void agregarAlInicio(T valor) {
        nodoNoble<T> nuevo = new nodoNoble<T>(valor);
        if (this.estaVacia()) {
            this.head= nuevo;
            this.tail= nuevo;
        } else {
            this.head.setAnterior(nuevo);
            nuevo.setSiguiente(this.head);
            this.head= nuevo;
        }
        tamanio++;
    }

    public void agregarAlFinal(T valor) {
        nodoNoble<T> nuevo = new nodoNoble<>(valor);
        if (estaVacia()) {
            head = tail = nuevo;
        } else {
            tail.setSiguiente(nuevo);
            nuevo.setAnterior(tail);
            tail = nuevo;
        }
        tamanio++;
    }

    public void agregar_despues_de(T referencia, T valor) {
        nodoNoble<T> nuevo = head;
        while (nuevo != null) {
            if (nuevo.getData().equals(referencia)) {
                nodoNoble<T> newNode = new nodoNoble<>();
                newNode.setSiguiente(nuevo.getSiguiente());
                newNode.setAnterior(nuevo);
                if (nuevo.getSiguiente() != null) {
                    nuevo.getSiguiente().setAnterior(newNode);
                } else {
                    tail = newNode;
                }
                nuevo.setSiguiente(newNode);
                tamanio++;
                return;
            }
            nuevo = nuevo.getSiguiente();
        }
        throw new IllegalArgumentException("Referencia no encontrada");
    }

    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        nodoNoble<T> nuevo = head;
        for (int i = 0; i < posicion; i++) {
            nuevo = nuevo.getSiguiente();
        }
        return nuevo.getData();
    }

    public void eliminar_el_primero() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        head = head.getSiguiente();
        if (head != null) {
            head.setAnterior(null);
        } else {
            tail = null;
        }
        tamanio--;
    }

    public void eliminar_el_final() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        tail = tail.getAnterior();
        if (tail != null) {
            tail.setSiguiente(null);
        } else {
            head = null;
        }
        tamanio--;
    }

    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= tamanio) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            eliminar_el_primero();
        } else if (posicion == tamanio - 1) {
            eliminar_el_final();
        } else {
            nodoNoble<T> nuevo = head;
            for (int i = 0; i < posicion; i++) {
                nuevo = nuevo.getSiguiente();
            }
            nuevo.getAnterior().setSiguiente(nuevo.getSiguiente());
            nuevo.getSiguiente().setAnterior(nuevo.getAnterior());
            tamanio--;
        }
    }

    public int buscar(T valor) {
        nodoNoble<T> nuevo = head;
        int index = 0;
        while (nuevo != null) {
            if (nuevo.getData().equals(valor)) {
                return index;
            }
            nuevo = nuevo.getSiguiente();
            index++;
        }
        return -1;
    }

    public void actualizar(T a_buscar, T valor) {
        nodoNoble<T> nuevo = head;
        while (nuevo != null) {
            if (nuevo.getData().equals(a_buscar)) {
                nuevo.setData(valor);
                return;
            }
            nuevo = nuevo.getSiguiente();
        }
        throw new IllegalArgumentException("Elemento no encontrado");
    }

    public void transversal() {
        nodoNoble<T> nuevo = head;
        while (nuevo != null) {
            System.out.print(nuevo.getData() + " ");
            nuevo = nuevo.getSiguiente();
        }
        System.out.println();
    }
}
