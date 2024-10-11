package Examen22;

public class FicheroEjecucion extends Fichero{
    private byte[] contenido;
    private String permisos;

    public FicheroEjecucion(String nombre) {
        super(nombre);
    }

    public void setPermisos(String permisos) throws ExcepcionFichero {
        if(!permisos.matches("[1-7]{3}"))throw new ExcepcionFichero("Permisos incorrecto");
        this.permisos = permisos;
    }

    @Override
    public void tamano() {
        setTamano(contenido.length);
    }

    @Override
    public void addContenido(String s) {

    }


}
