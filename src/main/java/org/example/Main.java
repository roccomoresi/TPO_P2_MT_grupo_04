package org.example;

import org.example.tdas.MatrizOfStacks;
import org.example.tdas.StatickStack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MatrizOfStacks queueOfStacks = new MatrizOfStacks();


        StatickStack stack1 = new StatickStack();
        StatickStack stack2 = new StatickStack();
        StatickStack stack3 = new StatickStack();
        StatickStack stack4 = new StatickStack();

        stack1.add(1);
        stack1.add(2);

        stack2.add(3);
        stack2.add(4);

        stack3.add(5);
        stack3.add(6);

        stack4.add(7);
        stack4.add(8);

        queueOfStacks.add(stack1);
        queueOfStacks.add(stack2);
        queueOfStacks.add(stack3);
        queueOfStacks.add(stack4);
        

        System.out.println("Cola después de remover el primero:");
        queueOfStacks.imprimirQueue(queueOfStacks);


        int resu = queueOfStacks.calcularTraza(queueOfStacks);
        System.out.println();
        System.out.println("Suma de la traza: " + resu);
    }

    }
