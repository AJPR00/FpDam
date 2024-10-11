import java.time.LocalDate;
import java.util.HashSet;

public class Persona {

    private String nombre;
    private String dni;
    private String tlf;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String dni, String tlf, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.tlf = tlf;
        this.fechaNacimiento = fechaNacimiento;
    }
/*
    1. Crea una clase Persona con las siguientes características:
            ● Nombre
            ● DNI
            ● Teléfono
            ● Fecha de nacimiento
    Añade 5 personas a una colección (da igual el tipo). Exporta dicha colección a un fichero
    XML.*/

    public static void main(String[] args) {


        HashSet<Persona> hasPersonas= new HashSet<>();

        Persona p1= new Persona("Maria","296585475F","959624242",LocalDate.of(1988,2,2));
        Persona p2= new Persona("Fernado","29653251Z","652632541",LocalDate.of(1958,1,30));
        Persona p3= new Persona("Claudio","294157487S","652652652", LocalDate.of(1224,4,11));
        Persona p4= new Persona("Lidia","28542452F","65214125", LocalDate.of(1999,5,12));
        Persona p5= new Persona("Jesus","241512512G","555555555",LocalDate.of(2002,5,16));

        hasPersonas.add(p1);
        hasPersonas.add(p2);
        hasPersonas.add(p3);
        hasPersonas.add(p4);
        hasPersonas.add(p5);
    }
}