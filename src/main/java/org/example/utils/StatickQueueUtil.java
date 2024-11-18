package org.example.utils;

import org.example.tdas.StatickStack;

public class StatickQueueUtil {

    public static StatickStack generarPilaOrdenadaSinRepetidos(StatickStack pilaOriginal) {
        StatickStack pilaAuxiliar = new StatickStack(); // Pila para ordenar elementos temporalmente
        StatickStack pilaSinRepetidos = new StatickStack(); // Pila final sin repetidos y ordenada

        while (!pilaOriginal.isEmpty()) {
            int elemento = pilaOriginal.getTop();
            pilaOriginal.remove();

            if (!contieneElemento(pilaAuxiliar, elemento)) {
                pilaAuxiliar.add(elemento);
            }
        }


        while (!pilaAuxiliar.isEmpty()) {
            int max = encontrarMaximo(pilaAuxiliar);
            pilaSinRepetidos.add(max);
            eliminarElemento(pilaAuxiliar, max);
        }

        return pilaSinRepetidos;
    }

    private static boolean contieneElemento(StatickStack pila, int elemento) {
        StatickStack temp = new StatickStack();
        boolean encontrado = false;


        while (!pila.isEmpty()) {
            int actual = pila.getTop();
            pila.remove();
            temp.add(actual);

            if (actual == elemento) {
                encontrado = true;
            }
        }


        while (!temp.isEmpty()) {
            pila.add(temp.getTop());
            temp.remove();
        }

        return encontrado;
    }

    private static int encontrarMaximo(StatickStack pila) {
        StatickStack temp = new StatickStack();
        int max = Integer.MIN_VALUE;


        while (!pila.isEmpty()) {
            int actual = pila.getTop();
            pila.remove();
            temp.add(actual);

            if (actual > max) {
                max = actual;
            }
        }

        while (!temp.isEmpty()) {
            pila.add(temp.getTop());
            temp.remove();
        }

        return max;
    }

    private static void eliminarElemento(StatickStack pila, int elemento) {
        StatickStack temp = new StatickStack();


        while (!pila.isEmpty()) {
            int actual = pila.getTop();
            pila.remove();

            if (actual != elemento) {
                temp.add(actual);
            }
        }


        while (!temp.isEmpty()) {
            pila.add(temp.getTop());
            temp.remove();
        }
    }
}
