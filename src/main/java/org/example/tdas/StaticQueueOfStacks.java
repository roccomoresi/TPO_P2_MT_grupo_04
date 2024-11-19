package org.example.tdas;

public class StaticQueueOfStacks implements QueueOfStacks {
    private static final int MAX = 20;
    private final StatickStack[] array; // Usamos StatickStack
    private int count;

    public StaticQueueOfStacks() {
        this.array = new StatickStack[MAX];
        this.count = 0;
    }

    @Override
    public StatickStack getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return array[0];
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede remover el primero de una cola vacía");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    @Override
    public void add(StatickStack stack) {
        if (this.count == MAX) {
            throw new RuntimeException("La cola está llena");
        }
        this.array[this.count] = stack;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

}
