package ico.fes.aragon.unam.mx.main;

import ico.fes.aragon.unam.mx.clases.listasDobles;

public class Main {
    public static  void main(String[] args) {

        listasDobles<Integer> numeros = new listasDobles<>();

        numeros.agregarAlInicio(50);
        numeros.agregarAlFinal(60);
        numeros.agregarAlFinal(65);
        numeros.agregarAlFinal(70);
        numeros.agregarAlFinal(80);
        numeros.agregarAlFinal(90);
        System.out.println("Contenido inicial:");
        numeros.transversal();
        numeros.eliminar(1);
        System.out.println("Después de eliminar el elemento en la posición 2:");
        numeros.transversal();
        numeros.actualizar(70, 88);
        System.out.println("Después de actualizar el cuarto elemento a 88:");
        numeros.transversal();

        int posicion = numeros.buscar(80);
        System.out.println("El valor 80 se encuentra en la posición: " + posicion);




    }
}