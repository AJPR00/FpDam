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


    /**
     * Método que vuelca un .CSV en un .DAT
     * Tengo en cuenta que solo se va a volcar UNA vez el .CSV y no hay repetidos.
     *
     * @param rutaIn
     */

    public Set<String> cargarCSV(Path rutaIn) {
        Set<String> setCargaCsv = new HashSet<>();

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
                setCargaCsv.add(linea);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        guardarDAT(listFormatDAT(setCargaCsv));
        return setCargaCsv;

    }

    public boolean isRegistrado(String matricula) {

        return true;
    }

    public void guardarDAT(Collection<String> coleccion) {
        try (BufferedWriter bw = Files.newBufferedWriter(dondeGuardar, StandardOpenOption.CREATE)) {
            for (String src : coleccion) {
                bw.write(src);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> listFormatDAT(Collection<String> coleccion) {
        List<String> formatADD = new LinkedList<>();

        for (String src : coleccion) {
            String[] palabras = src.split(",");
            String matricula = "", marca = "", modelo = "";

            if (palabras.length < 3 || palabras[0].isBlank() || palabras[1].isBlank() || palabras[2].isBlank()) {
                continue; // En caso que cumpla se salta una iteracion del while
            }

            matricula = String.format("%-" + TAM_MATRICULA + "s", palabras[0]);
            marca = String.format("%-" + TAM_MARCA + "s", palabras[1]);
            modelo = String.format("%-" + TAM_MODELO + "s", palabras[2]);
            formatADD.add(matricula + " " + marca + " " + modelo + "\n");
        }

        return formatADD;
    }
}
