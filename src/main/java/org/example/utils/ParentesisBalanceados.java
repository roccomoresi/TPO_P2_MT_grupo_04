package org.example.utils;

import org.example.tdas.StatickStack;

    public class ParentesisBalanceados {

    public static boolean balancearParentesis(String expresion) {
        StatickStack pila = new StatickStack();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '\'' || c == '\"') {
                continue;
            }

            if (c == '(' || c == '{' || c == '[') {
                pila.add(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (pila.isEmpty()) {
                    return false;
                }

                char top = (char) pila.getTop();

                if ((c == ')' && top == '(') ||
                        (c == '}' && top == '{') ||
                        (c == ']' && top == '[')) {
                    pila.remove();
                } else {
                    return false;
                }
            }
        }

            return pila.isEmpty();
        }
    }

