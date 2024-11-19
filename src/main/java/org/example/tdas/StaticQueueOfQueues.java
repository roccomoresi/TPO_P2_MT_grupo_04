package org.example.tdas;

public class StaticQueueOfQueues implements QueueOfQueues {
    private final int MAX = 20;
    private final Queue[] array;
    private int count;


    public StaticQueueOfQueues() {
        this.array = new Queue[MAX];
        this.count = 0;
    }

    @Override
    public QueueOfQueues concatenate(QueueOfQueues instanciasQueueOfQueues, int n) {
        QueueOfQueues t = new StaticQueueOfQueues();


        for (int h = 0; h < n; h++) {
            Queue aux = new StatickQueue();
            t.add(aux);
        }


        for (int i = 0; i < n; i++) {
            Queue f = instanciasQueueOfQueues.getFirst();
            while (!f.isEmpty()) {
                int auxNum = f.getFirst();
                t.getFirst().add(auxNum);
                f.remove();
            }
            instanciasQueueOfQueues.remove();
        }
        return t;
    }

    @Override
    public Queue flat(QueueOfQueues queueOfQueues) {
        Queue result = new StatickQueue();

        while (!queueOfQueues.isEmpty()) {

            Queue currentQueue = queueOfQueues.getFirst();
            while (!currentQueue.isEmpty()) {
                int element = currentQueue.getFirst();


                result.add(element);
                currentQueue.remove();
            }
            queueOfQueues.remove();
        }
        return result;
    }

    @Override
    public Queue getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La cola principal está vacía.");
        } else {
            return array[0];
        }
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La cola principal está vacía.");
        }

        for (int i = 0; i < array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }


    @Override
    public void add(Queue queue) {
        if (this.count == MAX) {
            throw new RuntimeException("La cola está llena.");
        }
        this.array[this.count] = queue;
        this.count++;
    }

    @Override
    public void reverseWithDepth(StaticQueueOfQueues queueOfQueues) {
        if (queueOfQueues.isEmpty()) {
            return; // Si está vacía, no hacemos nada
        }

        StaticQueueOfQueues tempQueueOfQueues = new StaticQueueOfQueues();
        StatickQueue queueAux = new StatickQueue();

        // Paso 1: Transferir colas de `queueOfQueues` a `tempQueueOfQueues` invirtiendo cada una
        while (!queueOfQueues.isEmpty()) {
            Queue currentQueue = queueOfQueues.getFirst();
            queueOfQueues.remove();

            // Invertir la cola actual
            while (!currentQueue.isEmpty()) {
                queueAux.add(currentQueue.getFirst());
                currentQueue.remove();
            }
            while (!queueAux.isEmpty()) {
                currentQueue.add(queueAux.getFirst());
                queueAux.remove();
            }

            // Añadir la cola invertida al principio de `tempQueueOfQueues`
            tempQueueOfQueues.add(currentQueue);
        }

        // Paso 2: Reconstruir `queueOfQueues` desde `tempQueueOfQueues` (ya está en orden invertido)
        while (!tempQueueOfQueues.isEmpty()) {
            queueOfQueues.add(tempQueueOfQueues.getFirst());
            tempQueueOfQueues.remove();
        }
    }

    @Override
        public boolean isEmpty() {
        return count == 0;
    }
}
