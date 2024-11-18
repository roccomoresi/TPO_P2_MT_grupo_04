package org.example.utils;

import org.example.tdas.Coordenada;

public class CoordenadaUtil implements Coordenada {
    private final double x;
    private final double y;

    public CoordenadaUtil(double x, double y) {
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

    public double distanciaAlOrigen() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
