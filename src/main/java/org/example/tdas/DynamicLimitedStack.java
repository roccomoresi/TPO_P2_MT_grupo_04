//modificacion de el TDA DynamicStack

package org.example.tdas;

import org.example.tdas.Nodes.Node;

public class DynamicLimitedStack implements Stack {

    private Node first;

    private final int capacity; // Capacidad máxima de la pila
    private int size; // Tamaño actual de la pila

    // Constructor: recibe la capacidad máxima como parámetro
    public DynamicLimitedStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0");
        }
        this.capacity = capacity;
        this.size = 0; // Inicializamos la pila como vacía
    }

    @Override
    public int getTop() { // C + C = C
        if(this.isEmpty()) { // C
            throw new RuntimeException("No se puede desapilar una pila vacia"); // C
        } else {
            return this.first.getValue(); // N
        }
    }

    // C, LOG(N), N, N LOG(N), N^2, N^3, ...., N^M, 2^N, 3^N, ..., P^N, N!

    @Override
    public void remove() { // C + C = C
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia"); // C
        } else {
            this.first = this.first.getNext(); // C
            this.size--;
        }
    }

    @Override
    public void add(int value) { // C
        if (this.size >= this.capacity) {
            throw new RuntimeException("No se puede apilar: la pila ha alcanzado su capacidad máxima");
        }
        this.first = new Node(value, this.first); // Creamos un nuevo nodo
        this.size++; // Aumentamos el tamaño // C
    }

    @Override
    public boolean isEmpty() { // C
        return this.first == null; // C
    }


    public boolean isFull() {
        return this.size >= this.capacity;
    }


    public int getSize() {
        return this.size;
    }


    public int getCapacity() {
        return this.capacity;
    }
}