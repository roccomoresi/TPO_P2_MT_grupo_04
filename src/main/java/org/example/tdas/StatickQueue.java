package org.example.tdas;

public class StatickQueue implements Queue{
    private final int MAX = 20;
    private final int[] array;
    int count;


    public StatickQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }



    //Invertir sin pila auxiliar
    public StatickQueue invertirColaSinPila(StatickQueue queue){
        int[] arrayCola = queue.getArray();
        StatickQueue colaInvertida = new StatickQueue();
        for(int i = arrayCola[arrayCola.length-1];i >= arrayCola[0];i--){
            colaInvertida.add(arrayCola[i]);
        }
        return colaInvertida;

    }

    //cola de stacks
    public void addStacks(){}



    //Invertir con pila auxiliar
    public void invertirCola(StatickQueue cola, StatickStack pila){

        while(count!=0){
            int a = cola.getFirst();
            pila.add(a);
            cola.remove();
        }
        while(!pila.isEmpty()){
            int a = pila.getTop();
            cola.add(a);
            pila.remove();
        }
    }

    public boolean definirSiCoincidenFinPrinc(StatickQueue cola1, StatickQueue cola2){
        int[] array1 = cola1.getArray();
        int[] array2 = cola2.getArray();

        if (array1[0] == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getFirst() {
        if(isEmpty()){
            throw new RuntimeException("Esta vacio breooooo");
        }
        else{
            return array[0];
        }
    }

    @Override
    public void remove() {

        if(isEmpty()){
            throw new RuntimeException("Esta breoooo");
        }
        for(int i = 0;i < array.length - 1;i++){
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    @Override
    public void add(int value) {
    if(this.count == MAX){
        throw new RuntimeException("La cola esta llena...");
    }
    this.array[this.count] = value;
    this.count++;
    }

    @Override
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }


    public void print(StatickQueue cola1){
        for(int i = 0;i < cola1.getArray().length;i++){
            System.out.print(cola1.getArray()[i] + " ");
        }
    }

    public void pasarColaAOtra(StatickQueue cola1, StatickQueue cola2){
        while(!cola1.isEmpty()){
            cola2.add(cola1.getFirst());
            cola1.remove();
        }
    }

    public int[] getArray() {
        return array;
    }
}
