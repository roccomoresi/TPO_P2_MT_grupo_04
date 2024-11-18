package org.example.tdas;

import java.util.Random;



public class StaticSet implements Set {

    private static final int MAX = 10000;
    private final int[] array;
    private int count;
    private final Random random;

    public StaticSet() {
        this.array = new int[MAX];
        this.count = 0;
        this.random = new Random();
    }


    
    @Override
    public void add(int a) {
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == a) {
                return;
            }
        }
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public int choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(count);
        return this.array[i];
    }

    @Override
    public void remove(int a) {
        for(int i = 0; i < this.count; i++) {
            if(this.array[i] == a) {
                this.array[i] = this.array[this.count-1];
                this.count--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        if(this.count == 0) {
            return true;
        }
        return false;
    }

    public static void copiarSet(StaticSet original, StaticSet copia) {
        for (int i = 0; i < original.count; i++) {
            copia.add(original.array[i]);
        }
    }
}
