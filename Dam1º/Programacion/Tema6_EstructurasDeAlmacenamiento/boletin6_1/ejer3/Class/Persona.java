package Tema6_EstructurasDeAlmacenamiento.boletin6_1.ejer3.Class;

import ejer3.Excepcion.ExcepcionMensaje;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Persona {

    private String nombre;
    private List<Mensaje> buzon;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.buzon = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    /*    Un método para poder enviar un mensaje a otra persona. Recibirá como
            parámetro la persona destinataria y el texto del mensaje.*/
    public void enviar(Persona destinatario, String contenido) throws ExcepcionMensaje {
        //Crea y guarda un objeto Mensaje en destinatario, this es el que lo envia,
        destinatario.buzon.add(new Mensaje(this, contenido));
    }

    /* ● Un método para poder leer los mensajes del buzón. Este método devolverá un
     String con todos los mensajes que tiene. Si no tiene mensajes para leer saltará el
     correspondiente mensaje de error. Cada mensaje irá precedido de un número 1
     en adelante, es decir se mostrará con este formato.
             “Mensaje X: De: nombreRemitente Texto: textoMensaje
     Fecha y hora: DD-MM-AAAA HH:MM”*/
    public String leer() {
        StringBuilder bl = new StringBuilder();
        for (int i = 0; i < buzon.size(); i++) {
            System.out.println();
            bl.append("Mensaje ").append(i + 1 + " ").append(buzon.get(i)).append("\n\n");
        }
        return bl.toString();
    }

    public String leerOrdenadoFecha() {
        StringBuilder bl = new StringBuilder();
        ArrayList<Mensaje> copiaLista = new ArrayList<>(buzon);
// Para dar configuracion a sort hay que IMPLEMENTS con COMPARABLE<> a la clase que se va a ordenar
        Collections.sort(copiaLista, new ComparadorFecha());

        for (int i = 0; i < copiaLista.size(); i++) {
            System.out.println();
            bl.append("Mensaje ").append(i + 1 + " ").append(copiaLista.get(i)).append("\n\n");
        }
        return bl.toString();
    }

    public String leerOrdenadoRemitente() {
        StringBuilder bl = new StringBuilder();
        ArrayList<Mensaje> copiaLista = new ArrayList<>(buzon);
        ComparadorRemitente ordenandoNombre = new ComparadorRemitente();
// Para dar configuracion a sort hay que IMPLEMENTS con COMPARABLE<> a la clase que se va a ordenar
        Collections.sort(copiaLista, ordenandoNombre);

        for (int i = 0; i < copiaLista.size(); i++) {
            System.out.println();
            bl.append("Mensaje ").append(i + 1 + " ").append(copiaLista.get(i)).append("\n\n");
        }
        return bl.toString();
    }

    /*public int compareTo(Persona remitente) {
        return nombre.compareTo(remitente.nombre);
    }*/

    /**
     * ● Un método para poder borrar un mensaje del buzón. Al método se le pasará el
     * número de mensaje que se desea borrar. Si no existe ese número de mensaje
     * saltará una excepción.
     *
     * @param num Número de mensajes a borrar.
     */

    public void borrarMensaje(int num) {
        try {
            // remove lanza una excepcion en caso no de encontrar.
            System.out.println("El mensaje de " + buzon.get(num-1).getRemitente().getNombre() + " fue eliminado");
            buzon.remove(num - 1);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe ese mensaje");
        }
    }


    /**
     * ● Un método que realice una búsqueda para poder encontrar los mensajes de su
     * buzón que contienen una frase Este método devolverá un String con todos los
     * mensajes que tienen esa frase o saltará la excepción si no encuentra ningún
     * mensaje con esa frase.
     */

    public String buscarFrase(String frase) {
        StringBuilder bl = new StringBuilder();
        for (Mensaje mensaje : buzon) {
            if (mensaje.getContenido().contains(frase)) {
                bl.append(mensaje.toString());
            }
        }
        return bl.toString();
    }
}

