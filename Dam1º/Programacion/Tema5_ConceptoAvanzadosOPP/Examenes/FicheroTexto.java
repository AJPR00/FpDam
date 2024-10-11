package Tema5_ConceptoAvanzadosOPP.Examenes;

import java.nio.charset.StandardCharsets;

public class FicheroTexto extends Fichero implements Convertible {

    // Esta matriz es protected para que sus herederas puedan dar uso, el contenido lo comparte con sus hijas
    protected String[][] matrizContenedor;


    public FicheroTexto(String name, String[] contenido) {
        super(name);
        setMatrizContenedor(contenido);
    }

    // Pasamos por parametro una array e inicializamos la matriz con 1 columna, el tamaño lo pasamos mediante array.length
    // for para pasar contenido de la array a la matriz solo en una columna
    public void setMatrizContenedor(String[] arrayToColumna) {

        matrizContenedor = new String[arrayToColumna.length][1];
        for (int i = 0; i < arrayToColumna.length; i++) {
            matrizContenedor[i][0] = arrayToColumna[i];

        }
    }

    @Override
    public long tamanoFichero() {

        StringBuilder sumaCadena = new StringBuilder();
        //Recore y añade el contenido de cada posición de la matriz a un solo objeto.
        for (int i = 0; i < matrizContenedor[0].length; i++) {
            if (matrizContenedor[i][0] != null) {
                // añade el contenido de la posición.
                sumaCadena.append(matrizContenedor[i][0]);
            }
        }
// Convierte sumaCadena en un String y .getBytes() en un array de bytes que respectivamente con.length nos da el tamaño,
        return String.valueOf(sumaCadena).getBytes(StandardCharsets.UTF_8).length;
    }

    @Override
    public String convertirTextoAudio() {

        StringBuilder sumaCadena = new StringBuilder();
        //Recore y añade el contenido de cada posición de la matriz a un solo objeto.
        for (int i = 0; i < matrizContenedor[0].length; i++) {
            if (matrizContenedor[i][0] != null) {
                // añade el contenido de la posición.
                sumaCadena.append(matrizContenedor[i][0]);
            }
        }
// Convierte  sumaCadena en un String.
        return sumaCadena.toString();
    }
}
