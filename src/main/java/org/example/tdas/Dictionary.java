
package org.example.tdas;

public interface Dictionary {

    void add(int key, int value);
    void remove(int key, int value);
    int get(int key);
    Set getKeys();

}
