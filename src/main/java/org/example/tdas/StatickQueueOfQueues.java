package org.example.tdas;

public class StatickQueueOfQueues implements QueueOfQueues {
    private final int MAX = 20;
    private final Queue[] array;
    private int count;


    public StatickQueueOfQueues() {
        this.array = new Queue[MAX];
        this.count = 0;
    }

    @Override
    public QueueOfQueues concatenate(QueueOfQueues instanciasQueueOfQueues, int n) {
        QueueOfQueues t = new StatickQueueOfQueues();


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
    public boolean isEmpty() {
        return count == 0;  
    }
}
