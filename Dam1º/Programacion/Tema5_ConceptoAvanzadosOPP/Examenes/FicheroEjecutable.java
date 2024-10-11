package Tema5_ConceptoAvanzadosOPP.Examenes;

import Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc2.FicheroException;

public class FicheroEjecutable extends Fichero implements Analizable {
    private byte[] arrayDeVideo;
    private int permisoPropietario, permisoGrupo, permisoOtros;

    public FicheroEjecutable(String name, byte[] arrayDeVideo) {
        super(name);
        this.arrayDeVideo = arrayDeVideo;
        this.permisoPropietario = 7;
        this.permisoGrupo = 1;
        this.permisoOtros = 1;
    }

    public int getPermisoPropietario() {
        return permisoPropietario;
    }

    public void setPermisoPropietario(int permisoPropietario) throws FicheroException {
        // try-catch para en caso de que no se introduzca un dígito y me salte la excepción de NumberFormatException la capturo y lanzo una excepción personalizada.
        try {
            if (permisoPropietario < 0 || permisoPropietario > 7) {
                throw new FicheroException("Introduzca un dígito del 0 al 7");
            }
            this.permisoPropietario = permisoPropietario;
        } catch (NumberFormatException e) {
            throw new FicheroException("Introduzca un dígito del 0 al 7");
        }
    }

    public int getPermisoGrupo() {
        return permisoGrupo;
    }

    public void setPermisoGrupo(int permisoGrupo) throws FicheroException {
        try {
            if (permisoGrupo < 0 || permisoGrupo > 7) {
                throw new FicheroException("Introduzca un dígito del 0 al 7");
            }
            this.permisoGrupo = permisoGrupo;
        } catch (NumberFormatException e) {
            throw new FicheroException("Introduzca un dígito del 0 al 7");
        }
    }

    public int getPermisoOtros() {
        return permisoOtros;
    }

    public void setPermisoOtros(int permisoOtros) throws FicheroException {
        try {
            if (permisoOtros < 0 || permisoOtros > 7) {
                throw new FicheroException("Introduzca un dígito del 0 al 7");
            }
            this.permisoOtros = permisoOtros;
        } catch (NumberFormatException e) {
            throw new FicheroException("Introduzca un dígito del 0 al 7");
        }
    }

    @Override
    public long tamanoFichero() {
        System.out.println("El tamaño de" + getName() + " es de " + arrayDeVideo.length);
        return 0;
    }

    @Override
    public void analizar() {
        System.out.println("Analizando " + getName());

    }
}
