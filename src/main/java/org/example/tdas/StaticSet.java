package org.example.tdas;

import java.util.Random;

public class StaticSet implements Set {

    private static final int MAX = 10000;
    private final int[] array;
    private int count;
    private final Random random;


    public StaticSet(int[] array, int count) {
        this.array = array;
        this.count = count;
        this.random = new Random();
    }


    public StaticSet() {
        this.array = new int[MAX];
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                return;  // Si ya existe, no lo agregamos
            }
        }
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public int choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(count);
        return this.array[i];
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == a) {
                this.array[i] = this.array[this.count - 1];
                this.count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void addAll(Set other) {

    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final int[] array;
        private int count;

        public Builder() {
            this.array = new int[MAX];
            this.count = 0;
        }

        public Builder add(int a) {
            for (int i = 0; i < count; i++) {
                if (this.array[i] == a) {
                    return this;
                }
            }
            this.array[this.count] = a;
            this.count++;
            return this;
        }


        public Builder addAll(Set other) {
            while (!other.isEmpty()) {
                int element = other.choose();
                this.add(element);
                other.remove(element);
            }
            return this;
        }

        public StaticSet build() {
            return new StaticSet(this.array, this.count);
        }
    }
}
