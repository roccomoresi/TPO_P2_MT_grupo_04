package org.example.utils;

import org.example.tdas.Nodes.DoublyNode;
import org.example.tdas.Queue;

public class CircularDoublyLinkedQueue implements Queue {
    private DoublyNode first; // Apunta al primer nodo
    private DoublyNode last;  // Apunta al último nodo

    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primer elemento de una cola vacía.");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede eliminar un elemento de una cola vacía.");
        }
        if (this.first == this.last) { // Caso de un solo nodo
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext(); // Mover el puntero de `first`
            this.first.setPrev(this.last);     // Actualizar el predecesor de `first`
            this.last.setNext(this.first);     // Mantener la circularidad
        }
    }

    @Override
    public void add(int value) {
        DoublyNode newNode = new DoublyNode(value, null, null);
        if (this.isEmpty()) { // Caso de cola vacía
            this.first = newNode;
            this.last = newNode;
            this.first.setNext(this.first); // Circularidad
            this.first.setPrev(this.first);
        } else {
            newNode.setPrev(this.last);     // Conectar el nuevo nodo al final
            newNode.setNext(this.first);    // Conectar al inicio para circularidad
            this.last.setNext(newNode);     // Actualizar el siguiente del último nodo
            this.first.setPrev(newNode);    // Actualizar el previo del primer nodo
            this.last = newNode;            // Mover el puntero de `last`
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
