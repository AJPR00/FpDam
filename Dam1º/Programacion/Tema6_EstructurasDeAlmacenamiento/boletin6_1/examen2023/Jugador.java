package Tema6_EstructurasDeAlmacenamiento.boletin6_1.examen23;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Jugador {
    private String nombre;
    private TDemarcacion demarcacion;
    private LocalDate fechaNacimiento;
    private String paisNacimiento;


    public Jugador(String nombre, TDemarcacion demarcacion, LocalDate fechaNacimiento, String paisNacimiento) {
        super();
        this.nombre = nombre;
        this.demarcacion = demarcacion;
        this.fechaNacimiento = fechaNacimiento;
        this.paisNacimiento = paisNacimiento;
    }

    public String getNombre() {
        return nombre;
    }


    public TDemarcacion getDemarcacion() {
        return demarcacion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public int calculaEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nombre).append(": ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append(fechaNacimiento.format(formatter)).append(". ")
                .append(demarcacion).append(" (").append(paisNacimiento).append(")");

        return sb.toString();

    }


}
