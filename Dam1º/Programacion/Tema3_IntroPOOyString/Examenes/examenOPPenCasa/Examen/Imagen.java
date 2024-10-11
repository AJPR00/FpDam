package Tema3_IntroPOOyString.Examenes.examenOPPenCasa.Examen;

import java.util.Random;

public class Imagen {


    public static String[][] generateRandomColors(int anchura, int altura) {

        String[][] colorMatrix = new String[altura][anchura]; // Crea la MATRIZ

        Random random = new Random();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                // Generar un color hexadecimal aleatorio
                String color = String.format("#%06X", random.nextInt(0xFFFFFF + 1));
                colorMatrix[i][j] = color;
            }
        }

        return colorMatrix;
    }
}
