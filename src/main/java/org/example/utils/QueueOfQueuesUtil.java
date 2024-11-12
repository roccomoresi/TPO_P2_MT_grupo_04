package org.example.utils;

import org.example.tdas.Queue;
import org.example.tdas.QueueOfQueues;
import org.example.tdas.StatickQueue;
import org.example.tdas.StatickQueueOfQueues;

public class QueueOfQueuesUtil {
    public static void main(String[] args) {

        QueueOfQueues q = new StatickQueueOfQueues();

        Queue queue1 = new StatickQueue();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        Queue queue2 = new StatickQueue();
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        Queue queue3 = new StatickQueue();
        queue3.add(7);
        queue3.add(8);
        queue3.add(9);

        Queue queue4 = new StatickQueue();
        queue4.add(10);
        queue4.add(11);
        queue4.add(12);

        Queue queue5 = new StatickQueue();
        queue5.add(13);
        queue5.add(14);
        queue5.add(15);
        // Agregar las colas al objeto QueueOfQueues

        q.add(queue1);
        q.add(queue2);
        q.add(queue3);
        q.add(queue4);
        q.add(queue5);

        StatickQueueOfQueues aux = new StatickQueueOfQueues();



        QueueOfQueues resu = q.concatenate(q,5);

        // Imprimir el resultado de la concatenación para verificar
        while (!resu.isEmpty()) {
            Queue queueAux = resu.getFirst();
            while (!queueAux.isEmpty()) {
                System.out.print(queueAux.getFirst() + " ");
                queueAux.remove();
            }
            resu.remove();
            System.out.println(); // Para separar las colas en la salida
        }

    }



}
