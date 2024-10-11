package boletin7_1.Ejer8.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
/*
    8. Realizar un programa que solicite un nombre de un fichero de texto e informe de si
    cumple con el formato que se indica. Cada línea debe contener:
            ● El nombre y dos apellidos, cada uno con dos caracteres alfabéticos
    como mínimo. Estarán separadas por un espacio
● A continuación su edad (1-99), separada por un espacio.*/

    public static void main(String[] args) {

        Path ruta = Paths.get("./Ejer8/prueba.txt");

        Pattern p = Pattern.compile("((?:\\p{L}{2,}\\s){3}) (([1-9][0-9]?)|0[1-9])");

        try (BufferedReader bf = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            if (bf.lines().map(a -> p.matcher(a)).allMatch(Matcher::matches)) {
                System.out.println("El fichero es válido");
            } else {
                System.out.println("El fichero no es válido");
            }

        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
            e.fillInStackTrace();
        }
    }
}