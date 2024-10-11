package RecuperacionEjercicios.Ejerc2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Animal {

    private static int idContador = 1;
    private int id;
    private EEspecies tipo;
    private int edad;
    private LocalDate fechaNacimiento;
    private ArrayList<LocalDate> listRegistroSalud;
    private ArrayList<LocalDate> listaRegistroAlimentacion;
    private boolean estadoSalud;

    public Animal(EEspecies tipo, LocalDate fechaNacimiento) throws ExceptionGranja {
        this.id = idContador;
        this.tipo = tipo;
        this.fechaNacimiento = fechaNacimiento;
        setEdad(fechaNacimiento);
        this.estadoSalud = true;
        this.listRegistroSalud = new ArrayList<>();
        this.listaRegistroAlimentacion = new ArrayList<>();
        idContador++;
    }

    public int getId() {
        return id;
    }

    public void setEdad(LocalDate fNacimiento) throws ExceptionGranja {
        if (fNacimiento.isAfter(LocalDate.now()))throw new ExceptionGranja("Edad no valida, aun no a nacido");
        LocalDate fechaActual = LocalDate.now();
        this.edad = Period.between(fNacimiento, fechaActual).getYears();
    }

    public void registrarAlimentacion() throws ExceptionGranja {
        if (!listaRegistroAlimentacion.contains(LocalDate.now())) {
            listaRegistroAlimentacion.add(LocalDate.now());
            System.out.println("Alimentacion registrada");
        } else {
            throw new ExceptionGranja("El día de hoy ya se alimento");
        }
    }

    public void registrarComporbacionSalud() throws ExceptionGranja {
        if (!listRegistroSalud.contains(LocalDate.now())) {
            listRegistroSalud.add(LocalDate.now());
            System.out.println("Comprobación de la salud registrada");

        } else {
            throw new ExceptionGranja("El día de hoy ya se analizo");
        }
    }
}
