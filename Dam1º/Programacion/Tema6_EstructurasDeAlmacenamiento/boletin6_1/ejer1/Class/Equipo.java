package ejer1.Class;




public class Equipo {
    private String nombreEquipo;
    // uso el interface Set<> para luego usar la clase HashSet porque es eficiente en gestión de add, remove y contains.
    private Set<Alumno> listAlumno;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.listAlumno = new HashSet<>();
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public Set<Alumno> getListaAlumno() {
        return listAlumno;
    }

    public void setListaAlumno(Set<Alumno> newlista) {
        this.listAlumno = newlista;
    }

    /* El equipo tiene operaciones para:
                ● Añadir un alumno (recibe como parámetro el objeto alumno a insertar). Si el
        alumno ya existe en el equipo debe saltar una excepción.
        */
    public void addAlumno(Alumno newAlumno)  {
        try {
            if (!listAlumno.add(newAlumno)) throw new ExcepcionEquipos("Alumno ya exíste");
            System.out.println("Agregado!!!");
        } catch (ExcepcionEquipos e) {
            System.out.println(e.getMessage());
        }
    }

/*    ● Borrar un alumno (recibe como parámetro el objeto alumno a borrar). Si el
    alumno no existe en el equipo debe saltar una excepción.*/

    /**
     * Ojo .remove porque devuelve un boolean  si se a borrado o no.
     *
     * @param newAlumno
     * @throws ExcepcionEquipos
     */
    public void delAlumno(Alumno newAlumno) {
        try {
            if (!listAlumno.remove(newAlumno)) throw new ExcepcionEquipos("El alumno no existe");
            System.out.println("Eliminado!!!");
        } catch (ExcepcionEquipos e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    ● Saber si un alumno pertenece al equipo. Recibe como parámetro el objeto
    alumno a buscar y devuelve null si no lo encuentra y el objeto alumno si existe.*/
    public boolean contieneAlumno(Alumno newAlumno) {
        return listAlumno.contains(newAlumno);
    }

    //  ● Mostrar en pantalla la lista de personas del equipo.
    public void viewLista() {
        for (Alumno obAlumno : listAlumno) {
            System.out.println("# " + obAlumno);
        }
    }

    /*● Unión de equipos. El método lo llamará un equipo y se le pasará por parámetro
    el otro equipo con el que se quiere unir. Devuelve un equipo formado por los
    alumnos de ambos equipos*/

    public Equipo unirEquipo(Equipo equipoUnir) {
        Equipo union=new Equipo(this.getNombreEquipo()+" "+equipoUnir.getNombreEquipo());
        union.listAlumno.addAll(this.listAlumno);
        union.listAlumno.addAll(equipoUnir.listAlumno);

        return union;
    }


    /* ● Intersección de equipos. Idem al anterior pero devuelve un equipo formado por
     los alumnos que están en los dos equipos*/
    public Set<Alumno> interseccionEquipo(Equipo equipoInters) {
        Set<Alumno> listaStart = new HashSet<>();
        Iterator<Alumno> it = listAlumno.iterator();

        //hasNext() me devuelve un boolean si la colección tiene más objeto que recorrer, si es un true, Next() devuelve el siguiente OBJETO.
        while (it.hasNext()) {
            //La devolución de Next
            Alumno alumno = it.next();

            if (equipoInters.listAlumno.contains(alumno)) {
                listaStart.add(alumno);
            }
        }
        return new HashSet<Alumno>(listaStart);
    }

}