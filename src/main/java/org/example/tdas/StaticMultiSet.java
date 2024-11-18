package org.example.tdas;

import java.util.Random;

public class StaticMultiSet {
    private static final int MAX = 10000;
    private final int[] elements;
    private final int[] quantities;
    private int count;
    private final Random random;

    public StaticMultiSet() {
        this.elements = new int[MAX];
        this.quantities = new int[MAX];
        this.count = 0;
        this.random = new Random();
    }

    public void add(int element) {
        for (int i = 0; i < this.count; i++) {
            if (this.elements[i] == element) {
                this.quantities[i]++;
                return;
            }
        }
        this.elements[this.count] = element;
        this.quantities[this.count] = 1;
        this.count++;
    }

    public int choose() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(count);
        return this.elements[i];
    }

    public void remove(int element) {
        for (int i = 0; i < this.count; i++) {
            if (this.elements[i] == element) {
                this.quantities[i]--;
                if (this.quantities[i] == 0) {
                    this.elements[i] = this.elements[this.count - 1];
                    this.quantities[i] = this.quantities[this.count - 1];
                    this.count--;
                }
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int getQuantity(int element) {
        for (int i = 0; i < this.count; i++) {
            if (this.elements[i] == element) {
                return this.quantities[i];
            }
        }
        return 0;
    }
}
