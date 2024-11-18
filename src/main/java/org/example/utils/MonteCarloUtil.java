package org.example.utils;
import java.util.ArrayList;
import java.util.List;
import org.example.tdas.Coordenada;

public class MonteCarloUtil {
    private final double lado; // Tamaño del cuadrado
    private final List<Coordenada> coordenadas;

    public MonteCarloUtil(double lado) {
        this.lado = lado;
        this.coordenadas = new ArrayList<>();
    }

    public void agregar(Coordenada coordenada) {
        if (coordenada.getX() >= 0 && coordenada.getX() <= lado &&
                coordenada.getY() >= 0 && coordenada.getY() <= lado) {
            this.coordenadas.add(coordenada);
        }
    } // Complejidad O(1)

    public double aproximarPi() {
        int dentroDelCirculo = 0;
        double radio = lado / 2.0;

        for (Coordenada coordenada : coordenadas) {
            double distancia = Math.sqrt(
                    Math.pow(coordenada.getX() - radio, 2) +
                            Math.pow(coordenada.getY() - radio, 2)
            );
            if (distancia <= radio) {
                dentroDelCirculo++;
            }
        }

        return 4.0 * dentroDelCirculo / coordenadas.size();
    } // Complejidad O(n), donde n es el tamaño de la lista coordenadas
}
