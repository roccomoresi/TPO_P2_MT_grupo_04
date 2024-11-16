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
    public void pasarPilaAOtra(Stack pila1, Stack pila2){

        while(!pila1.isEmpty()){
            int aux = pila1.getTop();
            pila2.add(aux);
            pila1.remove();

        }

    }

    //HACER UNA COPIA
    public void copy(Stack stack1, Stack copy, Stack aux){

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

}
