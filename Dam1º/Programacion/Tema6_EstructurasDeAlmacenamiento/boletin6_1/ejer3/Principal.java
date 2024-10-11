package ejer3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Persona per1 = new Profesor("Pepe");
        Persona per2 = new Alumno("Juan", LocalDate.of(2002, 1, 1));
        Persona alum1 = new Alumno("Rpdolfo", LocalDate.of(2011, 1, 1));

        List<Persona> personas = new ArrayList<>();
        personas.add(per1);
        personas.add(per2);
        personas.add(alum1);
        try {
            personas.get(0).enviarMensaje(personas.get(1), "Mensaje Prueba");

            Thread.sleep(1000);

            personas.get(1).enviarMensaje(personas.get(0), "Mensaje Prueba");
            Thread.sleep(1000);
            personas.get(0).enviarMensaje(personas.get(1), "Mensaje Prueba");
            Thread.sleep(1000);
            personas.get(1).enviarMensaje(personas.get(1), "Mensaje Prueba");
        } catch (InterruptedException | CorreoException e) {
            System.out.println(e.getMessage());
        }

        personas.get(0).leerMensaje();
        personas.get(0).leerMensajesOrdenados();

    }
}
