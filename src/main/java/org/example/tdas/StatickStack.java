package org.example.tdas;


public class StatickStack implements Stack{

    private final static int MAX = 20;
    private final int[] array;
    private int count;

    public StatickStack() {
        this.array = new int[MAX];
        this.count = 0;
    }



    //PASAR UNA PILA A OTRA
    public void pasarPilaAOtra(StatickStack pila1, StatickStack pila2){

        while(!pila1.isEmpty()){
            int aux = pila1.getTop();
            pila2.add(aux);
            pila1.remove();

        }

    }

    //HACER UNA COPIA
    public void copy(StatickStack stack1, StatickStack copy, StatickStack aux){

        while(!stack1.isEmpty()){
            int num = stack1.getTop();
            aux.add(num);
            stack1.remove();
        }

        while(!aux.isEmpty()){
            int num = aux.getTop();
            copy.add(num);
            aux.remove();
        }

    }

    //Obtener la cantidad de numeros en la pila.
    public void lengthPila(StatickStack pila){
        System.out.println(pila.getArray().length);
    }

    //Sumar elementos de una pila
    public int sumarNumerosPila(StatickStack pila){
        int[] arrayPila = pila.getArray();
        int suma = 0;
        for(int i = 0;i < arrayPila.length;i++){
            suma+=arrayPila[i];
        }
        return suma;
    }

    //Calcular promedio
    public int calcularPromedio(int[] array){
        int suma = 0;
        int promedio = 0;
        for(int i = 0;i<array.length;i++){
            suma+=array[i];
            promedio = suma / array.length;
        }
        return promedio;
    }

    public void printStack(int[] array){
        for(int i = 0;i < array.length;i++){
                System.out.print(array[i] + "");
        }
    }



    @Override
    public int getTop() {

        if(isEmpty()){
            throw new RuntimeException("NO SE PUEDE SACAR EL TOP, EL STACK ESTA VACIO...");
        }
        return array[this.count - 1];
    }

    @Override
    public void remove() {
        if(isEmpty()){
            throw new RuntimeException("NO SE PUEDE... ESTA VACIA");
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        if(this.count == 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void add(int value) {
    if(this.count == MAX){
        throw new RuntimeException("NO SE PUEDE ESTA LLENA...");
    }
    else{
        this.array[this.count] = value;
        count++;
    }
    }

    public int[] getArray() {
        return array;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
