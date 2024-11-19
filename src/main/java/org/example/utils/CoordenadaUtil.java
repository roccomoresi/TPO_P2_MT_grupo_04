package org.example.utils;

import org.example.tdas.Coordenada;

public class CoordenadaUtil {

    public static double distanciaAlOrigen(Coordenada coordenada) {
        double x = coordenada.getX();
        double y = coordenada.getY();
        return Math.sqrt(x * x + y * y);
    }
}
