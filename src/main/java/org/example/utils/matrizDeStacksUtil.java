package org.example.utils;

import org.example.tdas.QueueStacks;
import org.example.tdas.StatickStack;

public class matrizDeStacksUtil {

    public static void main(String[] args) {



        QueueStacks cola = new QueueStacks();

        StatickStack pila1 = new StatickStack();
        StatickStack pila2 = new StatickStack();
        StatickStack pila3 = new StatickStack();
        StatickStack pila4 = new StatickStack();

        for (int i = 1; i <= 20; i++) {
            pila1.add(i);
            pila2.add(i);
            pila3.add(i);
            pila4.add(i);
        }

        pila1.printStack(pila1.getArray());
        System.out.println();
        pila2.printStack(pila2.getArray());
        System.out.println();
        pila3.printStack(pila3.getArray());
        System.out.println();
        pila4.printStack(pila4.getArray());

        cola.add(pila1);
        cola.add(pila2);
        cola.add(pila3);
        cola.add(pila4);

        System.out.println("");
        System.out.println(cola.getFirst().getTop());
        int cont = 0;
        while(!cola.getFirst().isEmpty()){
            cola.getFirst().getTop();
            cont+=1;
            cola.getFirst().remove();
        }

        System.out.println(cont);

        while(!cola.isEmpty()){
            
        }
    }
}
