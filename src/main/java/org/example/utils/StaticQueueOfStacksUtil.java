package org.example.utils;

import org.example.tdas.StatickStack;
import org.example.tdas.StaticQueueOfStacks;

public class StaticQueueOfStacksUtil {

    public static int calcularTraza(StaticQueueOfStacks queue) {
        int traza = 0;

        // Crear una cola temporal para no modificar la original
        StaticQueueOfStacks tempQueue = new StaticQueueOfStacks();

        int fila = 0; // Indica el índice de la fila actual

        while (!queue.isEmpty()) {
            StatickStack currentStack = queue.getFirst(); // Obtener la pila en la posición actual
            queue.remove(); // Remover la pila procesada

            tempQueue.add(currentStack); // Guardar en la cola temporal para restaurar luego

            // Procesar la pila para encontrar el valor en la posición diagonal (fila = columna)
            StatickStack tempStack = new StatickStack();
            int columna = 0; // Índice para iterar la pila

            while (!currentStack.isEmpty()) {
                int value = currentStack.getTop(); // Obtener el valor de la cima
                currentStack.remove(); // Remover el valor de la pila
                tempStack.add(value); // Guardar en la pila temporal

                // Si estamos en la posición diagonal (fila == columna), sumamos el valor a la traza
                if (columna == fila) {
                    traza += value;
                }
                columna++;
            }

            // Restaurar la pila original desde la temporal
            while (!tempStack.isEmpty()) {
                currentStack.add(tempStack.getTop());
                tempStack.remove();
            }
            fila++; // Avanzar a la siguiente fila
        }

        // Restaurar la cola original
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.getFirst());
            tempQueue.remove();
        }

        return traza;
    }

    public static StaticQueueOfStacks suma(StaticQueueOfStacks queue1, StaticQueueOfStacks queue2) {
        // Crear colas temporales para no modificar las originales
        StaticQueueOfStacks tempQueue1 = new StaticQueueOfStacks();
        StaticQueueOfStacks tempQueue2 = new StaticQueueOfStacks();

        // Calcular los tamaños de las colas verificando manualmente
        int size1 = 0;
        int size2 = 0;

        // Contar elementos de queue1
        while (!queue1.isEmpty()) {
            StatickStack stack = queue1.getFirst();
            queue1.remove();
            tempQueue1.add(stack);
            size1++;
        }

        // Contar elementos de queue2
        while (!queue2.isEmpty()) {
            StatickStack stack = queue2.getFirst();
            queue2.remove();
            tempQueue2.add(stack);
            size2++;
        }

        // Verificar si las colas tienen el mismo tamaño
        if (size1 != size2) {
            // Restaurar las colas originales antes de lanzar la excepción
            while (!tempQueue1.isEmpty()) {
                queue1.add(tempQueue1.getFirst());
                tempQueue1.remove();
            }
            while (!tempQueue2.isEmpty()) {
                queue2.add(tempQueue2.getFirst());
                tempQueue2.remove();
            }
            throw new IllegalArgumentException("Las colas deben tener el mismo tamaño");
        }

        // Restaurar las colas originales para procesarlas
        while (!tempQueue1.isEmpty()) {
            queue1.add(tempQueue1.getFirst());
            tempQueue1.remove();
        }
        while (!tempQueue2.isEmpty()) {
            queue2.add(tempQueue2.getFirst());
            tempQueue2.remove();
        }

        // Crear la cola resultado
        StaticQueueOfStacks resultQueue = new StaticQueueOfStacks();

        // Realizar la suma
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            StatickStack stack1 = queue1.getFirst();
            StatickStack stack2 = queue2.getFirst();

            queue1.remove();
            queue2.remove();

            StatickStack resultStack = new StatickStack();
            StatickStack auxStack1 = new StatickStack();
            StatickStack auxStack2 = new StatickStack();

            // Sumar elementos de las pilas
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                int value1 = stack1.getTop();
                int value2 = stack2.getTop();

                resultStack.add(value1 + value2);
                auxStack1.add(value1);
                auxStack2.add(value2);

                stack1.remove();
                stack2.remove();
            }

            // Restaurar las pilas originales
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

        // Restaurar las colas originales
        while (!tempQueue1.isEmpty()) {
            queue1.add(tempQueue1.getFirst());
            tempQueue1.remove();
        }
        while (!tempQueue2.isEmpty()) {
            queue2.add(tempQueue2.getFirst());
            tempQueue2.remove();
        }

        return resultQueue;
    }

    public static StaticQueueOfStacks traspuesta(StaticQueueOfStacks queue) {
        // Crear una cola temporal para procesar sin modificar la original
        StaticQueueOfStacks tempQueue = new StaticQueueOfStacks();
        StaticQueueOfStacks transposedQueue = new StaticQueueOfStacks();

        // Contar el número de filas en la cola original y duplicarla en tempQueue
        int numFilas = 0;
        while (!queue.isEmpty()) {
            tempQueue.add(queue.getFirst());
            queue.remove();
            numFilas++;
        }

        // Determinar el número de columnas procesando las pilas
        int numColumnas = 0;
        StaticQueueOfStacks tempQueueForColumns = new StaticQueueOfStacks();

        // Iteramos sobre las pilas para encontrar la mayor cantidad de elementos
        while (!tempQueue.isEmpty()) {
            StatickStack stack = tempQueue.getFirst();
            tempQueue.remove();
            tempQueueForColumns.add(stack);

            // Contar elementos en la pila actual
            StatickStack auxStack = new StatickStack();
            int columnasEnPila = 0;
            while (!stack.isEmpty()) {
                auxStack.add(stack.getTop());
                stack.remove();
                columnasEnPila++;
            }

            // Restaurar la pila
            while (!auxStack.isEmpty()) {
                stack.add(auxStack.getTop());
                auxStack.remove();
            }

            // Actualizar el número máximo de columnas
            if (columnasEnPila > numColumnas) {
                numColumnas = columnasEnPila;
            }
        }

        // Restaurar la cola temporal después del cálculo de columnas
        while (!tempQueueForColumns.isEmpty()) {
            tempQueue.add(tempQueueForColumns.getFirst());
            tempQueueForColumns.remove();
        }

        // Inicializar la cola transpuesta con pilas vacías
        for (int i = 0; i < numColumnas; i++) {
            transposedQueue.add(new StatickStack());
        }

        // Procesar las pilas y llenar la transpuesta
        while (!tempQueue.isEmpty()) {
            StatickStack currentStack = tempQueue.getFirst();
            tempQueue.remove();

            StatickStack tempStack = new StatickStack();

            // Transferir los elementos de la pila actual a una pila temporal
            while (!currentStack.isEmpty()) {
                tempStack.add(currentStack.getTop());
                currentStack.remove();
            }

            // Añadir elementos a las pilas transpuestas
            int col = 0;
            while (!tempStack.isEmpty()) {
                int value = tempStack.getTop();
                tempStack.remove();

                StatickStack targetStack = transposedQueue.getFirst();
                transposedQueue.remove();
                targetStack.add(value);
                transposedQueue.add(targetStack);
                col++;
            }

            // Restaurar la pila actual en la cola temporal
            tempQueue.add(currentStack);
        }

        // Restaurar la cola original
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.getFirst());
            tempQueue.remove();
        }

        return transposedQueue;
    }

    public static StaticQueueOfStacks sumarMatrices(StaticQueueOfStacks queue1, StaticQueueOfStacks queue2) {
        StaticQueueOfStacks resultQueue = new StaticQueueOfStacks();

        // Crear colas temporales para procesar sin modificar las originales
        StaticQueueOfStacks tempQueue1 = new StaticQueueOfStacks();
        StaticQueueOfStacks tempQueue2 = new StaticQueueOfStacks();

        // Procesar ambas colas
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            // Obtener la pila actual de cada cola, o una pila vacía si la cola está vacía
            StatickStack stack1 = queue1.isEmpty() ? new StatickStack() : queue1.getFirst();
            StatickStack stack2 = queue2.isEmpty() ? new StatickStack() : queue2.getFirst();

            if (!queue1.isEmpty()) {
                tempQueue1.add(queue1.getFirst());
                queue1.remove();
            }
            if (!queue2.isEmpty()) {
                tempQueue2.add(queue2.getFirst());
                queue2.remove();
            }

            // Crear una nueva pila para almacenar la suma
            StatickStack resultStack = new StatickStack();

            // Crear pilas temporales para procesar los elementos
            StatickStack tempStack1 = new StatickStack();
            StatickStack tempStack2 = new StatickStack();

            // Sumar los elementos de las pilas
            while (!stack1.isEmpty() || !stack2.isEmpty()) {
                int value1 = stack1.isEmpty() ? 0 : stack1.getTop();
                int value2 = stack2.isEmpty() ? 0 : stack2.getTop();

                // Eliminar elementos de las pilas originales y almacenarlos en temporales
                if (!stack1.isEmpty()) {
                    tempStack1.add(value1);
                    stack1.remove();
                }
                if (!stack2.isEmpty()) {
                    tempStack2.add(value2);
                    stack2.remove();
                }

                // Agregar la suma a la pila de resultados
                resultStack.add(value1 + value2);
            }

            // Restaurar las pilas originales desde las temporales
            while (!tempStack1.isEmpty()) {
                stack1.add(tempStack1.getTop());
                tempStack1.remove();
            }
            while (!tempStack2.isEmpty()) {
                stack2.add(tempStack2.getTop());
                tempStack2.remove();
            }

            // Agregar la pila de resultados a la cola de resultados
            resultQueue.add(resultStack);
        }

        // Restaurar las colas originales
        while (!tempQueue1.isEmpty()) {
            queue1.add(tempQueue1.getFirst());
            tempQueue1.remove();
        }
        while (!tempQueue2.isEmpty()) {
            queue2.add(tempQueue2.getFirst());
            tempQueue2.remove();
        }

        return resultQueue;
    }

}


