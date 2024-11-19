package org.example.tdas;

public class CoordenadaImp implements Coordenada {

    private final double x;
        private final double y;

        public CoordenadaImp(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
}
