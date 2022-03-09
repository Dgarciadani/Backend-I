package arboles;

import java.util.Scanner;

public class Bosque {
    public static void main(String[] args) {
        ArbolFactory bosque = new ArbolFactory();
        int alto;
        int ancho;
        String color;
        String tipo;

        for (int i = 0; i < 1000000; i++) {
            if (i <= 500000) {
                System.out.println("arbol n°" + i);
                alto = (int) (Math.random() * 100);
                ancho = (int) (Math.random() * 200);
                color = "verde";
                tipo = "Ornamentales";
                bosque.getArboles(alto, ancho, color, tipo);
            } else if (i <= 750000) {
                System.out.println("arbol n°" + i);
                alto = (int) (Math.random() * 100);
                ancho = (int) (Math.random() * 200);
                color = "rojo";
                tipo = "frutales";
                bosque.getArboles(alto, ancho, color, tipo);
            } else if (i > 750000) {
                System.out.println("arbol n°" + i);
                alto = (int) (Math.random() * 100);
                ancho = (int) (Math.random() * 200);
                color = "celeste";
                tipo = "frutales";
                bosque.getArboles(alto, ancho, color, tipo);
            }

        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }
}