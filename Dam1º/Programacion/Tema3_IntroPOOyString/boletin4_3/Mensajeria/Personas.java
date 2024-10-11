/*package boletin4_3.Mensajeria;

import java.util.Arrays;

public class Personas {

    private static final int TAMANO_BADEJA = 5;
    private String nombre;
    private Mensaje[] mensajerRecibidos;
    private Mensaje[] mensajerEnviados;

    public Personas(String nombre) {
        this.nombre = nombre;
        this.mensajerRecibidos = new Mensaje[TAMANO_BADEJA];
        this.mensajerEnviados = new Mensaje[TAMANO_BADEJA];
    }

    //Método con Exepciones
    public void enviaMensaje(Personas destinatario, String asunto, String cuerpo) throws MensajesExcegtion {

        if (destinatario == null) {
            throw new MensajesExcegtion("Destinatario erróneo");

        }
        if (asunto == null || asunto.length() == 0) {
            throw new MensajesExcegtion("Asunto vacío");
        }

        if (cuerpo == null || cuerpo.length() == 0) {
            throw new MensajesExcegtion("Cuerpo vacío");
        }

        if (mensajerEnviados[TAMANO_BADEJA - 1] != null) {
            throw new MensajesExcegtion("Bandeja de salida llena");
        }

        if (destinatario.mensajerRecibidos[TAMANO_BADEJA - 1] != null) {
            throw new MensajesExcegtion("Bandeja de entreda llena");
        }


        Mensaje m = new Mensaje(asunto, cuerpo, this, destinatario);

// Introducir en la bandeja de enviados

        boolean posVacia = true;
        for (int i = 0; i < TAMANO_BADEJA && posVacia; i++) {
            if (mensajerEnviados[i] == null) {
                mensajerEnviados[i] = m;
                posVacia = false;
            }

        }
// Introducir en la bandeja de recibido del destinatario.
        for (int i = 0; i < TAMANO_BADEJA && posVacia; i++) {
            if (destinatario.mensajerRecibidos[i] == null) {
                destinatario.mensajerRecibidos[i] = m;
                posVacia = false;
            }

        }
    }

    public void mostrarBandejaEntrada() {
        if (mensajerRecibidos[0] == null) {

            System.out.println("Su bandeja de entrda está vacía");
        } else {
            for (int i = 0; i < TAMANO_BADEJA && mensajerRecibidos[i] != null; i++) {
                System.out.println(mensajerRecibidos[i]);
            }
        }
    }

    public void mostrarBandejaSalida() {

        if (mensajerEnviados[0] == null) {

            System.out.println("Su bandeja de salida está vacía");
        } else {
            for (int i = 0; i < TAMANO_BADEJA && mensajerEnviados[i] != null; i++) {
                System.out.println(mensajerEnviados[i]);
            }
        }
    }


    public void borrarMensajesEntradaMasAntiguo() throws MensajesExcegtion {
        if (mensajerEnviados[0] == null) {
            throw new MensajesExcegtion("Bandeja de salid está avacía");
        }

        boolean exit = true;

        for (int i = 1; i < TAMANO_BADEJA && exit; i++) {
            if (mensajerEnviados[i] == null) {
                mensajerEnviados[i - 1] = mensajerEnviados[i];
                mensajerEnviados = null;

                if (i < TAMANO_BADEJA - 1 && mensajerEnviados[i] == null) {
                    exit = false;

                }
            }
        }
    }

    public void borrarMensajesRecibidoMasAntiguo() throws MensajesExcegtion {
        if (mensajerRecibidos[0] == null) {
            throw new MensajesExcegtion("Bandeja de salid está avacía");
        }

        boolean exit = true;

        for (int i = 1; i < TAMANO_BADEJA && exit; i++) {
            if (mensajerRecibidos[i] == null) {
                mensajerRecibidos[i - 1] = mensajerRecibidos[i];
                mensajerRecibidos = null;

                if (i < TAMANO_BADEJA - 1 && mensajerRecibidos[i] == null) {
                    exit = false;

                }
            }
        }
    }


    @Override
    public String toString() {
        return "Personas{" +
                "nombre='" + nombre + '\'' +
                ", mensajerRecibidos=" + Arrays.toString(mensajerRecibidos) +
                ", mensajerEnviados=" + Arrays.toString(mensajerEnviados) +
                '}';
    }


}*/

