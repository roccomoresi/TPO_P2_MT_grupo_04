package org.example.utils;
import org.example.tdas.StatickStack;

public class StatickStackutil {

    public static void main(String[] args) {

        //PASAR UNA PILA A OTRA Y DEJARLA INVERTIDA

        StatickStack pila = new StatickStack();
        StatickStack copy = new StatickStack();
        StatickStack aux = new StatickStack();

        for(int i = 0; i < pila.getArray().length;i++){
            pila.add(i);
        }


        System.out.println();
        pila.printStack(pila.getArray());

        pila.copy(pila, copy, aux);
        System.out.println();
        aux.printStack(aux.getArray());

        System.out.println();
        copy.printStack(copy.getArray());

        System.out.println();
        copy.lengthPila(copy);


        int x = pila.sumarNumerosPila(pila);
        System.out.println(x);

        int f = pila.calcularPromedio(pila.getArray());
        System.out.println(f);
    }





}

