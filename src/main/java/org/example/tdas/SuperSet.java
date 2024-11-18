package org.example.tdas;
import org.example.tdas.Nodes.Node;

    public class SuperSet {

        private final DynamicSet universalSet;

        public SuperSet() {
            this.universalSet = new DynamicSet();
        }


        public void add(int value) {
            this.universalSet.add(value);
        }


        public void remove(int value) {
            this.universalSet.remove(value);
        }


        public boolean isSubset(Set subset) {
            DynamicSet dynamicSubset = (DynamicSet) subset; // Suponemos que usamos DynamicSet
            Node current = dynamicSubset.getFirstNode();
            while (current != null) {
                if (!contains(current.getValue())) {
                    return false; // Si algún elemento del subset no está en el superconjunto
                }
                current = current.getNext();
            }
            return true; // Todos los elementos están en el superconjunto
        }


        public DynamicSet complement(Set subset) {
            if (!isSubset(subset)) {
                throw new RuntimeException("El conjunto recibido no es subconjunto del superconjunto.");
            }

            DynamicSet complementSet = new DynamicSet();
            Node current = this.universalSet.getFirstNode();

            while (current != null) {
                if (!subsetContains(subset, current.getValue())) {
                    complementSet.add(current.getValue());
                }
                current = current.getNext();
            }

            return complementSet;
        }


        private boolean contains(int value) {
            Node current = this.universalSet.getFirstNode();
            while (current != null) {
                if (current.getValue() == value) {
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }


        private boolean subsetContains(Set subset, int value) {
            DynamicSet dynamicSubset = (DynamicSet) subset;
            Node current = dynamicSubset.getFirstNode();
            while (current != null) {
                if (current.getValue() == value) {
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }
    }
