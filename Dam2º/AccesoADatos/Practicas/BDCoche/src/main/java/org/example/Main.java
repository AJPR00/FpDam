package org.example;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        BBDD bbdd = new BBDD();

        bbdd.cargarCSV(Paths.get("src/Files/BBDDCoches.csv"));

    }
}
