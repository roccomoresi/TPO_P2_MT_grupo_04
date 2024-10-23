package org.example.utils;

import org.example.tdas.StatickQueue;
import org.example.tdas.StatickStack;

public class StatickColaUtil {

    public static void main(String[] args) {

        StatickQueue cola1 = new StatickQueue();
        StatickQueue cola2 = new StatickQueue();

        StatickStack colaAux = new StatickStack();


        for (int i = 0; i < 20; i++) {

            cola1.add(i);

        }

        System.out.println("Cola normal");
        cola1.print(cola1);



        System.out.println("");

        System.out.println("Cola invertida");
        StatickQueue colainv = cola1.invertirColaSinPila(cola1);
        colainv.print(colainv);




    }






}
