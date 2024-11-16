package org.example.utils;

import org.example.tdas.Queue;
import org.example.tdas.QueueOfQueues;
import org.example.tdas.StatickQueue;
import org.example.tdas.StatickQueueOfQueues;

public class QueueOfQueuesUtil {

    // Método para aplanar una instancia de QueueOfQueues en una sola Queue
    public static Queue flat(QueueOfQueues queueOfQueues) {
        // Crear una nueva cola vacía donde se almacenarán todos los elementos
        Queue result = new StatickQueue();

        // Mientras que QueueOfQueues no esté vacía
        while (!queueOfQueues.isEmpty()) {
            // Obtener la primera cola de QueueOfQueues
            Queue currentQueue = queueOfQueues.getFirst();

            // Mientras que la cola actual no esté vacía
            while (!currentQueue.isEmpty()) {
                // Obtener el primer elemento de la cola interna
                int element = currentQueue.getFirst();

                // Agregar el elemento a la cola resultante
                result.add(element);

                // Eliminar el primer elemento de la cola interna
                currentQueue.remove();
            }

            // Eliminar la cola interna de QueueOfQueues
            queueOfQueues.remove();
        }

        // Devolver la cola resultante que contiene todos los elementos
        return result;
    }
}






