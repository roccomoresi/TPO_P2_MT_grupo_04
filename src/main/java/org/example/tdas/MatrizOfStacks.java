package org.example.tdas;

public class MatrizOfStacks implements QueueOfStacks{
    //DEFINO EL FINAL DE LA COLA.
    private static final int MAX = 50;
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

    public void imprimirQueue(){

        if(this.isEmpty()){
            System.out.println("Esta vacia la cola");
        }
        for(int i = 1;i <= this.count;i++){
            System.out.print(this.array[i] + "-");
        }
    }



    //Calcular traza


    public StatickStack[] getArray() {
        return array;
    }

    public int calcularTraza(MatrizOfStacks queueOfStacks, StatickStack pila1) {


        int suma = 0;


        StatickStack[] cola = queueOfStacks.getArray();
        StatickStack stack = queueOfStacks.getArray()[0];

        int lenCola = cola.getArray()[0].length;
        int lenStack = pila1.getArray().length;

        int contador = lenStack;

        if (cola.getArray().length == 0) {
            throw new RuntimeException("La matriz esta vacia");
        }

        if (lenCola != lenStack) {
            throw new RuntimeException("No es cuadrada la matriz.");
        } else {
            for(int i = 0;i < cola.getArray().length;i++){
                for(int j = 0; j < pila1.getArray().length;j++){
                    suma+=pila1.getArray()[contador];

                }
                contador-=1;
            }

        }

        return suma;



        //1) Averiguamos si la matriz es cuadrada.


    }
}


