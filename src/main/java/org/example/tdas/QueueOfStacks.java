package org.example.tdas;
import org.example.tdas.StatickStack;

public interface QueueOfStacks {
    Stack getFirst();
    void remove();
    void add(StatickStack stack);
    boolean isEmpty();
}
