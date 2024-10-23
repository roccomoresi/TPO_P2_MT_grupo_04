package org.example.tdas;

public interface Queue {
    int getFirst();
    void remove();
    void add(int value);
    boolean isEmpty();
}
