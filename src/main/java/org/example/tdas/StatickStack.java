package org.example.tdas;

public class StatickStack implements Stack {

    private static final int MAX = 20;
    private final int[] array;
    private int count;

    private StatickStack(Builder builder) {
        this.array = builder.array;
        this.count = builder.count;
    }

    public StatickStack() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("NO SE PUEDE SACAR EL TOP, EL STACK ESTÁ VACÍO...");
        }
        return array[this.count - 1];
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("NO SE PUEDE... ESTÁ VACÍA");
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(int value) {
        if (this.count == MAX) {
            throw new RuntimeException("NO SE PUEDE... ESTÁ LLENA");
        } else {
            this.array[this.count] = value;
            count++;
        }
    }

    public void addAll(StatickStack otherStack) {
        for (int i = 0; i < otherStack.count; i++) {
            this.add(otherStack.array[i]);
        }
    }

    public static class Builder {
        private final int[] array;
        private int count;

        public Builder() {
            this.array = new int[MAX];
            this.count = 0;
        }

        public Builder add(int value) {
            if (count < MAX) {
                this.array[count++] = value;
            } else {
                throw new RuntimeException("La pila está llena.");
            }
            return this;
        }

        public Builder addAll(StatickStack otherStack) {
            for (int i = 0; i < otherStack.count; i++) {
                this.add(otherStack.array[i]);
            }
            return this;
        }

        public StatickStack build() {
            return new StatickStack(this);
        }
    }
}
