package org.example.tdas;

public class StatickQueueOfQueues implements QueueOfQueues {
        private final int MAX = 20;
        private final Queue[] array;
        private int count;

        public StatickQueueOfQueues() {
            this.array = new Queue[MAX];
            this.count = 0;
        }

        @Override
        public QueueOfQueues concatenate(QueueOfQueues instaciasQueueOfQueues, int n){

            QueueOfQueues t = new StatickQueueOfQueues();

            for(int h = 0; h < n; h++){
                Queue aux = new StatickQueue();
                t.add(aux);
            }



            for(int i = 0; i < n; i++){
                Queue f = instaciasQueueOfQueues.getFirst();
                while(!f.isEmpty()){
                    int auxNum = f.getFirst();
                    t.getFirst().add(auxNum);
                    f.remove();

                }
                instaciasQueueOfQueues.remove();
            }
            return t;

        }


        @Override
        public Queue getFirst() {
            if(isEmpty()){
                throw new RuntimeException("Esta vacia la cola principal.");
            }
            else{
                return array[0];
            }
        }

        @Override
        public void remove() {

            if(isEmpty()){
                throw new RuntimeException("Esta vacia la cola principal adiosñjasdjioñ.");
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

    public Queue[] getArray() {
        return array;
    }
}
