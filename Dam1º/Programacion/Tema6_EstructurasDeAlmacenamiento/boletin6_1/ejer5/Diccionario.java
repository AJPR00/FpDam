package ejer5;

import java.util.*;
import java.util.stream.Stream;

public class Diccionario {

    private Map<String, List<String>> dicionario;

    public Diccionario() {
        this.dicionario = new HashMap<>();
    }

    public void anadirPalabra(String palabra, String definicion) {

        if (!this.dicionario.containsKey(palabra)) {
            List<String> definiciones = new ArrayList<>();
            this.dicionario.put(palabra, definiciones);
            definiciones.add(definicion);
        } else {
            this.dicionario.get(palabra).add(definicion);
        }
    }


    public List<String> bucarPalabra(String palabra) throws ExcepcionDiccionario {
        List<String> definiciones = this.dicionario.get(palabra);
        if (definiciones == null) {
            throw new ExcepcionDiccionario("Palabra no encontrada");
        }
        return definiciones;
    }

    public void borrarPalabra(String palabrakey) throws ExcepcionDiccionario {

        List<String> definiciones = this.dicionario.remove(palabrakey);
        if (definiciones == null) {
            throw new ExcepcionDiccionario("Palabra no encontrada");
        }
    }


    public List<String> listadoPalabras(String comienzoPalabra) throws ExcepcionDiccionario {
//keySet devulve un conjunto de claves
        Set<String> claves = this.dicionario.keySet();
        List<String> palabrasFiltradas = new ArrayList<>();

        for (String str : claves) {
            if (str.startsWith(comienzoPalabra)) {
                palabrasFiltradas.add(str);
            }
        }
        return palabrasFiltradas;
    }

    public List<String> listadoPalabrasConFlujo(String comienzoPalabra) throws ExcepcionDiccionario {

        return this.dicionario.keySet().stream().filter(pa -> pa.startsWith(comienzoPalabra)).toList();

    }
}
