package org.example.tdas;


public class QueueStacks implements QueueOfStacks{
    //DEFINO EL FINAL DE LA COLA.
    private static final int MAX = 20;
    private final Stack[] array;
    private int count;

    //CONSTRUCTOR
    public QueueStacks() {
        this.array = new Stack[MAX];
        this.count = 0;
    }



    //Obtengo el primero de la cola (El primero q entro) FILA(First in first out)
    @Override
    public Stack getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return array[0];
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i+1];
        }
        count--;
    }

    @Override
    public void add(StatickStack stack) {
        if(this.count == MAX) {
            throw new RuntimeException("La cola esta llena");
        }
        this.array[this.count] = stack;
        this.count++;
    }

    //VERIFICA SI COUNT == O, EN ESE CASO RETORNA true, LO CUAL SIGNIFICA QUE LA COLA ESTA VACIA.
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }



    public Stack[] getArray() {
        return array;
    }
}


