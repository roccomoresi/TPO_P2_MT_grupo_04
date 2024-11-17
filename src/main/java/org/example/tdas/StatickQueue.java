package org.example.tdas;

public class StatickQueue implements Queue {
    private final int MAX = 20;
    public final int[] array;
    private int count;
    
    public StatickQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    public StatickQueue(int[] values) {
        this.array = new int[MAX];
        this.count = 0;

        for (int value : values) {
            if (count < MAX) {
                this.add(value);
            } else {
                throw new RuntimeException("La cola está llena con los valores iniciales.");
            }
        }
    }

    public void invertirCola(StatickQueue cola, StatickStack pila) {
        while (count != 0) {
            int a = cola.getFirst();
            pila.add(a);
            cola.remove();
        }
        while (!pila.isEmpty()) {
            int a = pila.getTop();
            cola.add(a);
            pila.remove();
        }
    }

    @Override
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía.");
        }
        return array[0];
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía.");
        }
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public void add(int value) {
        if (count == MAX) {
            throw new RuntimeException("La cola está llena.");
        }
        array[count++] = value;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public void pasarColaAOtra(StatickQueue cola1, StatickQueue cola2) {
        while (!cola1.isEmpty()) {
            cola2.add(cola1.getFirst());
            cola1.remove();
        }
    }
}
