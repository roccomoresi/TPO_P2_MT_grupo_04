package org.example.strucutures;

public class StatickQueueClass implements Queue {

    private static final int MAX = 10000;

    private final int[] array;
    private StatickStackClass[] stackList;
    private int count;

    public StatickQueueClass() {
        this.array = new int[MAX];
        this.count = 0;
    }


    public void agregarStacks(StatickStackClass stack) {
        if(this.count == MAX) {
            throw new RuntimeException("La cola esta llena");
        }
        this.stackList[this.count] = stack;
        this.count++;
    }

    @Override
    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return array[0];
    }



    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i+1];
        }
        count--;
    }

    @Override
    public void add(int value) {
        if(this.count == MAX) {
            throw new RuntimeException("La cola esta llena");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    public int[] getArray() {
        return array;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

