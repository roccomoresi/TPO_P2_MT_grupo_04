package org.example.tdas;

public class DoublyNode {
    private int value;
    private DoublyNode next;
    private DoublyNode prev;

    public DoublyNode(int value, DoublyNode next, DoublyNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public int getValue() {
        return value;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public DoublyNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }
}

