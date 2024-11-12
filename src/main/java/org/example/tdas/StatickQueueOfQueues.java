package org.example.tdas;

public class StatickQueueOfQueues implements QueueOfQueues {
        private final int MAX = 20;
        private final Queue[] array;
        int count;


        public StatickQueueOfQueues() {
            this.array = new Queue[MAX];
            this.count = 0;
        }



        //Invertir sin pila auxiliar
        public Queue invertirColaSinPila(org.example.tdas.StatickQueue queue){
            int[] arrayCola = queue.getArray();
            org.example.tdas.StatickQueue colaInvertida = new org.example.tdas.StatickQueue();
            for(int i = arrayCola[arrayCola.length-1];i >= arrayCola[0];i--){
                colaInvertida.add(arrayCola[i]);
            }
            return colaInvertida;

        }

        @Override
        public Queue getFirst() {
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
        public void add(Queue queue) {
            if(this.count == MAX){
                throw new RuntimeException("La cola esta llena...");
            }
            this.array[this.count] = queue;
            this.count++;
        }

        @Override
        public boolean isEmpty() {
            if(count == 0){
                return true;
            }
            return false;
        }


        public void print(org.example.tdas.StatickQueue cola1){
            for(int i = 0;i < cola1.getArray().length;i++){
                System.out.print(cola1.getArray()[i] + " ");
            }
        }
}
