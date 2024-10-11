package ejer3;

import java.time.LocalDate;

public class Alumno extends Persona {
    private static final int MAYOR_EDAD = 18;
    private LocalDate fechaNacimiento;

    public Alumno(String nombre, LocalDate fechaNacimiento) {
        super(nombre);
        fechaNacimiento = fechaNacimiento;
    }

    @Override
    public void enviarMensaje(Persona receptor, String mensaje) throws CorreoException {

        LocalDate fechaMinima = LocalDate.now().minusYears(18);

        if (receptor.getClass() == Alumno.class && fechaNacimiento.isAfter(fechaMinima))
           // if (receptor instanceof Alumno && fechaNacimiento.isAfter(fechaMinima)) {
            throw new CorreoException("Los alumnos no puede enviar mensajes a otros alumnos");
        }

}
