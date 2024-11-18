package org.example.utils;


import org.example.strucutures.StatickQueueClass;
import org.example.strucutures.StatickStackClass;

public class QueueOfStacks {
    public static void main(String[] args) {
        StatickQueueClass cola = new StatickQueueClass();

        int n = 5;
        StatickStackClass pila1 = new StatickStackClass();
        StatickStackClass pila2 = new StatickStackClass();
        StatickStackClass pila3 = new StatickStackClass();
        StatickStackClass pila4 = new StatickStackClass();



        pila1.add(445);
        pila1.add(446);
        pila1.add(447);
        pila1.add(448);

        for(int i = 0;i < cola.getArray().length;i++) {
            {
             cola.agregarStacks(pila1);
            }


            System.out.println(cola.getArray());
        }
    }
}
