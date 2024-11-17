package org.example.utils;

import org.example.tdas.StaticDictionary;

public class StatickDictionaryUtil {

    // Inicializar el diccionario con las letras del alfabeto y frecuencia 0
    public static void inicializarDiccionario(StaticDictionary diccionario) {
        for (char letra = 'a'; letra <= 'z'; letra++) {
            diccionario.add(letra, 0);  // Inicializamos con frecuencia 0
        }
    }

    // Método para contar la frecuencia de las letras en el texto
    public static void contarFrecuenciaTexto(String texto, StaticDictionary diccionario) {
        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                char letra = Character.toLowerCase(c);
                int frecuencia = diccionario.get(letra);
                diccionario.add(letra, frecuencia + 1); // Actualizar la frecuencia
            }
        }
    }

    // Método para desencriptar el texto utilizando las frecuencias
    public static String desencriptar(String textoCifrado, StaticDictionary diccionario) {
        // Buscar la letra más frecuente en el texto cifrado
        char letraMasFrecuente = obtenerLetraMasFrecuente(diccionario);

        // Calcular el desplazamiento asumiendo que la letra más frecuente es la 'e'
        int desplazamiento = calcularDesplazamiento(letraMasFrecuente);

        // Desencriptar el texto aplicando el desplazamiento
        StringBuilder textoDesencriptado = new StringBuilder();
        for (char c : textoCifrado.toCharArray()) {
            if (Character.isLetter(c)) {
                textoDesencriptado.append(desplazarLetra(c, -desplazamiento));
            } else {
                textoDesencriptado.append(c);  // Si no es letra, dejamos el carácter tal cual
            }
        }

        return textoDesencriptado.toString();
    }

    // Obtener la letra más frecuente del diccionario
    private static char obtenerLetraMasFrecuente(StaticDictionary diccionario) {
        char letraMasFrecuente = ' ';
        int maxFrecuencia = 0;

        // Buscar la letra con la mayor frecuencia
        for (char letra = 'a'; letra <= 'z'; letra++) {
            int frecuencia = diccionario.get(letra);
            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                letraMasFrecuente = letra;
            }
        }

        return letraMasFrecuente;
    }

    // Calcular el desplazamiento asumiendo que la letra más frecuente es la 'e'
    private static int calcularDesplazamiento(char letraMasFrecuente) {
        return letraMasFrecuente - 'e';  // Suponemos que 'e' es la letra más frecuente en español
    }

    // Desplazar una letra según un desplazamiento dado
    private static char desplazarLetra(char letra, int desplazamiento) {
        char base = Character.isUpperCase(letra) ? 'A' : 'a';
        return (char) ((letra - base + desplazamiento + 26) % 26 + base);
    }
}
