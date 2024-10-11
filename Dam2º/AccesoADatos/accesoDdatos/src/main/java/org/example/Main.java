package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> camapos = new HashMap<>();
        camapos.put("Matrícula", 7);
        camapos.put("Marca", 32);
        camapos.put("Modelo", 32);
        try {
            BBDDFicheros bbddFicheros = new BBDDFicheros("coches.dat", "Matricula", camapos);
            HashMap<String, String> coches = new HashMap<>();
            coches.put("Matricula", "1111AAA");
            coches.put("Marca", "Seat");
            coches.put("Moldelo", "León");
            bbddFicheros.insertar(coches);
            coches.clear();
            coches.put("Matricula", "2222AAA");
            coches.put("Marca", "Toyota");
            coches.put("Moldelo", "Ch-R");
            bbddFicheros.insertar(coches);
            coches.clear();
            coches.put("Matricula", "3333AAA");
            coches.put("Marca", "Kia");
            coches.put("Moldelo", "Sportage");
            bbddFicheros.insertar(coches);
            coches.clear();
            coches.put("Matricula", "4444AAA");
            coches.put("Marca", "Ferrari");
            coches.put("Moldelo", "Erzo");
            bbddFicheros.insertar(coches);
            coches.clear();
            coches= (HashMap<String, String>)bbddFicheros.recuperar("4444AAA").entrySet();

            for (Map.Entry<String, String> entry : coches.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
