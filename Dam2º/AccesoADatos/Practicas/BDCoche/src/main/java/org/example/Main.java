package org.example;

import java.nio.file.Paths;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        BBDD bbdd = new BBDD();

        bbdd.cargarCSV(Paths.get("src/Files/BBDDCoches.csv"));
       bbdd.guardarDAT(bbdd.getTablaCoches());
        imprirLista(bbdd.getTablaCoches());
    }

    public static void imprirLista(Collection lista) {
        System.out.print(lista);
    }

    public static void odenarLista(Collection<String> lista) {
        for (String ser : lista){
            System.out.println(ser);
        }
    }
}
