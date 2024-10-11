package Tema6_EstructurasDeAlmacenamiento.boletin6_1.ejer3.Class;

import ejer3.Excepcion.ExcepcionMensaje;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();

        personas.add(new Profesor("Claudio"));
        personas.add(new Alumno("José", LocalDate.of(1955, 1, 25)));
        personas.add(new Profesor("Gonzalez"));
        personas.add(new Alumno("María", LocalDate.of(2000, 5, 5)));

        try {
            personas.get(1).enviar(personas.get(1), "Buenos Dias, Soy Jose, Alumno");
            Thread.sleep(1000);
            personas.get(2).enviar(personas.get(1), "Buenos Dias, Soy Gonzalez, Profesor");
            Thread.sleep(1000);
            personas.get(0).enviar(personas.get(1), "Buenos Dias, Soy Claudio, Profesor");
            Thread.sleep(1000);
            personas.get(3).enviar(personas.get(1), "Buenos Dias, Soy Maria, Alumna");
            Thread.sleep(1000);
            personas.get(3).enviar(personas.get(1), "Buenos Dias, Soy Maria, Alumna");

        } catch (InterruptedException | ExcepcionMensaje e) {
            System.out.println("Espera cortado");
        }

     /*   System.out.println("Mensajes sin orden\n" + personas.get(1).leer());
        System.out.println();
        System.out.println("Mensajes con orden de fecha\n" + personas.get(1).leerOrdenadoFecha());
        System.out.println();*/
        System.out.println("Mensajes con orden de Remitente\n" + personas.get(1).leerOrdenadoRemitente());
       // System.out.println("Mensajes contiene\n" + personas.get(1).buscarFrase("Maria"));

        personas.get(1).borrarMensaje(6);
        System.out.println("Mensajes con eliminado\n" + personas.get(1).leerOrdenadoRemitente());


    }
}
