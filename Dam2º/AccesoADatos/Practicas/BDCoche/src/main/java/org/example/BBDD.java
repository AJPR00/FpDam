package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static java.nio.file.Files.newBufferedReader;


/**
 * Precargo .dat en un HAShSET para
 */

public class BBDD {

    private final int TAM_MATRICULA = 7, TAM_MARCA = 32, TAM_MODELO = 32;
    Path dondeGuardar;
    List<String> tablaCoches;

    public BBDD() {
        this.dondeGuardar = Paths.get("BBDD.dat");
        this.tablaCoches = new LinkedList<>();
    }

    public List<String> getTablaCoches() {
        return tablaCoches;
    }

    public boolean isRegistrado(String matricula) {
        return tablaCoches.stream().anyMatch(l->l.startsWith(matricula));
    }

    /**
     * Método que vuelca un .CSV en un .DAT
     * Tengo en cuenta que solo se va a volcar UNA vez el .CSV y no hay repetidos.
     *
     * @param rutaIn
     */

    public void cargarCSV(Path rutaIn) {
        Set<String> setCargaCsv = new HashSet<>(tablaCoches);
        tablaCoches.clear();

       /* try (BufferedReader br = newBufferedReader(rutaIn);
             BufferedWriter bw = Files.newBufferedWriter(dondeGuardar, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            br.readLine(); // Consume la primera linea sin hacer nada con ella
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(",");
                String matricula = "", marca = "", modelo = "";

                if (palabras.length < 3 || palabras[0].isBlank() || palabras[1].isBlank() || palabras[2].isBlank()) {
                    continue; // En caso que cumpla se salta una iteracion del while
                }

                matricula = String.format("%-" + TAM_MATRICULA + "s", palabras[0]);
                marca = String.format("%-" + TAM_MARCA + "s", palabras[1]);
                modelo = String.format("%-" + TAM_MODELO + "s", palabras[2]);

                for (int i = 0; i < palabras.length && !palabras[i].isBlank(); i++) {

                    if (i == 0) {
                        matricula = String.format("%-" + TAM_MATRICULA + "s", palabras[0]);
                    } else if (i == 1) {
                        marca = String.format("%-" + TAM_MARCA + "s", palabras[1]);
                    } else {
                        modelo = String.format("%-" + TAM_MODELO + "s", palabras[2]);
                    }
                }

                String matriculaADD = matricula + " " + marca + " " + modelo;


                //bw.write(matriculaADD);

                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        try (BufferedReader br = newBufferedReader(rutaIn)) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String pasaLinea = pasarFormatDAT(linea);
                if (pasaLinea != null) setCargaCsv.add(pasaLinea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tablaCoches.addAll(setCargaCsv);

    }

    public void guardarDAT(Collection<String> coleccion) {
        try (BufferedWriter bw = Files.newBufferedWriter(dondeGuardar, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            for (String src : coleccion) {
                bw.write(src);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void añadirMatricula(String coche, int pos){
        String pasaLinea = pasarFormatDAT(coche);
        if (pasaLinea != null) tablaCoches.add(pos,pasaLinea);
    }

    public String pasarFormatDAT(String src) {
        String[] palabras = src.split(",");
        if (palabras.length < 3 || palabras[0].isBlank() || palabras[1].isBlank() || palabras[2].isBlank()) {
            return null; // En caso que cumpla se salta una
        }

        String matricula = String.format("%-" + TAM_MATRICULA + "s", palabras[0]);
        String marca = String.format("%-" + TAM_MARCA + "s", palabras[1]);
        String modelo = String.format("%-" + TAM_MODELO + "s", palabras[2]);
        return matricula + " " + marca + " " + modelo + "\n";
    }
}
