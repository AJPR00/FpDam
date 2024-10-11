package Tema6_EstructurasDeAlmacenamiento.boletin6_1.ejercicios_Complementarios_Colecciones;

public class Paciente {

    private static final int MAX_PRIORIDAD = 5;
    private static final int MIN_PRIORIDAD = 1;

    private String nombre;
    private int dni, edad, prioridad;

    public int getPrioridad() {
        return prioridad;
    }

    public Paciente(String nombre, int dni, int edad, int prioridad) throws ExcepcionServiciosUrgencias {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        setPrioridad(prioridad);
    }

    public void setPrioridad(int prioridad) throws ExcepcionServiciosUrgencias {
        if (this.prioridad <1 || this.prioridad >5) throw new ExcepcionServiciosUrgencias("La prioridad debe de estar entre 5 y 1");
        this.prioridad = prioridad;
    }
}
