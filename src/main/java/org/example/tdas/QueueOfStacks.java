package org.example.tdas;

public interface QueueOfStacks {
    StatickStack getFirst();
    void remove();
    void add(StatickStack stack);
    boolean isEmpty();
}
