package org.example.utils;
import org.example.tdas.Stack;
import org.example.tdas.StatickStack;

public class StatickStackUtil {

    public static void invertirStack(StatickStack stack) {
        StatickStack auxiliar = new StatickStack();

        // Mover todos los elementos del stack original al auxiliar
        while (!stack.isEmpty()) {
            int topElement = stack.getTop();
            auxiliar.add(topElement);
            stack.remove();
        }

        // Mover los elementos del auxiliar de vuelta al stack original (esto los invertirá)
        while (!auxiliar.isEmpty()) {
            int topElement = auxiliar.getTop();
            stack.add(topElement);
            auxiliar.remove();
        }
    }
}
