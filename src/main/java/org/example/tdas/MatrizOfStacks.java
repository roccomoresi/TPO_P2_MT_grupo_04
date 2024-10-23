package org.example.tdas;


public class MatrizOfStacks implements QueueOfStacks{
    //DEFINO EL FINAL DE LA COLA.
    private static final int MAX = 20;
    private final StatickStack[] array;
    private int count;

    //CONSTRUCTOR
    public MatrizOfStacks() {
        this.array = new StatickStack[MAX];
        this.count = 0;
    }

    //Obtengo el primero de la cola (El primero q entro) FILA(First in first out)
    @Override
    public StatickStack getFirst() {
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

    public void imprimirQueue(MatrizOfStacks matrizOfStacks) {

        if (this.isEmpty()) {
            System.out.println("Esta vacia la cola");
        } else {
            for (int i = 0; i < matrizOfStacks.getArray().length; i++) {

                System.out.println("");

                for (int j = 0; j < matrizOfStacks.getArray()[0].getArray().length; j++) {
                    System.out.print(j + "-");
                }
            }
        }
    }

    //Calcular traza

    public int calcularTraza(MatrizOfStacks matrizOfStacks){

        int suma = 0;

        for (int i = 0 ; i < matrizOfStacks.getArray().length ; i++) {
            for (int j = matrizOfStacks.getArray()[0].getArray().length - 1; j > matrizOfStacks.getArray()[i].getArray().length; j--) {
                suma+=matrizOfStacks.getArray()[i].getArray()[j];
            }


        }
        return suma;
    }


    public StatickStack[] getArray() {
        return array;
    }






}


