package org.example.tdas;


public class StatickQueueOfStacks implements QueueOfStacks{
    private static final int MAX = 20;
    private final Stack[] array;
    private int count;

    public StatickQueueOfStacks() {
        this.array = new Stack[MAX];
        this.count = 0;
    }

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

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    public int calcularTraza() {
        int traza = 0;
        for (int i = 0; i < count; i++) {
            StatickStack currentStack = (StatickStack) array[i];
            StatickStack tempStack = new StatickStack();


            for (int j = 0; j <= i; j++) {
                if (!currentStack.isEmpty()) {
                    int element = currentStack.getTop();
                    tempStack.add(element);
                    currentStack.remove();
                    if (j == i) {
                        traza += element;
                    }
                } else {
                    throw new RuntimeException("No hay suficientes elementos en la pila en la posición " + i);
                }
            }

            while (!tempStack.isEmpty()) {
                currentStack.add(tempStack.getTop());
                tempStack.remove();
            }
        }
        return traza;
    } //Complejidad Lineas O(n)


    public StatickQueueOfStacks traspuesta() {
        StatickQueueOfStacks transposedQueue = new StatickQueueOfStacks();


        for (int i = 0; i < count; i++) {
            transposedQueue.add(new StatickStack());
        }

        for (int i = 0; i < count; i++) {
            StatickStack currentStack = (StatickStack) array[i];
            StatickStack tempStack = new StatickStack();

            while (!currentStack.isEmpty()) {
                int value = currentStack.getTop();
                tempStack.add(value);
                currentStack.remove();
            }

            int col = 0;
            while (!tempStack.isEmpty()) {
                int value = tempStack.getTop();
                tempStack.remove();

                StatickStack targetStack = (StatickStack) transposedQueue.array[col];
                targetStack.add(value);
                col++;
            }
        }

        return transposedQueue;
    } //Complejidad Lineas O(n)

    public int size() {
        return count;
    }

    public static StatickQueueOfStacks suma(StatickQueueOfStacks queue1, StatickQueueOfStacks queue2) {
        if (queue1.size() != queue2.size()) {
            throw new IllegalArgumentException("Las colas deben tener el mismo tamaño");
        }

        StatickQueueOfStacks resultQueue = new StatickQueueOfStacks();

        for (int i = 0; i < queue1.size(); i++) {
            StatickStack stack1 = (StatickStack) queue1.array[i];
            StatickStack stack2 = (StatickStack) queue2.array[i];


            StatickStack resultStack = new StatickStack();


            StatickStack auxStack1 = new StatickStack();
            StatickStack auxStack2 = new StatickStack();

            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int value1 = stack1.getTop();
                int value2 = stack2.getTop();
                resultStack.add(value1 + value2);

                auxStack1.add(value1);
                auxStack2.add(value2);

                stack1.remove();
                stack2.remove();
            }


            while (!auxStack1.isEmpty()) {
                stack1.add(auxStack1.getTop());
                auxStack1.remove();
            }

            while (!auxStack2.isEmpty()) {
                stack2.add(auxStack2.getTop());
                auxStack2.remove();
            }


            resultQueue.add(resultStack);
        }

        return resultQueue;
    }//Complejidad Lineas O(n)



}


