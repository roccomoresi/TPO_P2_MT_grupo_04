package org.example;
import org.example.tdas.MatrizOfStacks;
import org.example.tdas.StatickStack;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Crear una cola de stacks (MatrizOfStacks)
        MatrizOfStacks queueOfStacks = new MatrizOfStacks();

        // Crear 4 stacks diferentes
        StatickStack stack1 = new StatickStack();
        StatickStack stack2 = new StatickStack();
        StatickStack stack3 = new StatickStack();
        StatickStack stack4 = new StatickStack();

        // Agregar algunos elementos a cada stack
        stack1.add(1);
        stack1.add(2);

        stack2.add(3);
        stack2.add(4);

        stack3.add(5);
        stack3.add(6);

        stack4.add(7);
        stack4.add(8);

        // Agregar los stacks a la cola usando el método add()
        queueOfStacks.add(stack1);
        queueOfStacks.add(stack2);
        queueOfStacks.add(stack3);
        queueOfStacks.add(stack4);
        

        System.out.println("Cola después de remover el primero:");
        queueOfStacks.imprimirQueue(queueOfStacks);
    }

    }
