package org.example.utils;

import org.example.tdas.StaticSet;

public class StaticSetUtil {


        public static void copiarSet(StaticSet original, StaticSet copia) {

            while (!original.isEmpty()) {
                int elemento = original.choose();
                copia.add(elemento);
                original.remove(elemento);
            }
        }
    }




