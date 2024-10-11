package Tema6_EstructurasDeAlmacenamiento.boletin6_1.ejer3.Class;

import ejer3.Excepcion.ExcepcionMensaje;

import java.time.LocalDate;

public class Alumno extends Persona {


    private final int MENOR_EDAD = 216;
    private LocalDate fechaNacimiento;

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Alumno(String nombre, LocalDate fechaNacimiento) {
        super(nombre);
        this.fechaNacimiento = fechaNacimiento;
    }

    /*
◦ Si la persona que envía el mensaje es un alumno y es menor de edad solo
    puede enviar mensajes a profesores, es decir, si un alumno menor de edad
    intenta enviar un mensaje a otro alumno se debe provocar un error*/

    @Override
    public void enviar(Persona destinatario, String contenido) throws ExcepcionMensaje {
        LocalDate fechaMinima = LocalDate.now().minusMonths(MENOR_EDAD);
        if (destinatario instanceof Alumno && fechaNacimiento.isAfter(fechaMinima)) {
            throw new ExcepcionMensaje("Los menores de edad no pude enviar mensajes");
        }
        super.enviar(destinatario, contenido);
    }
}
