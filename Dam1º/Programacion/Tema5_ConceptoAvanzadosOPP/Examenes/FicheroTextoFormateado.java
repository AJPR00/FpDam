package Tema5_ConceptoAvanzadosOPP.Examenes;

public class FicheroTextoFormateado extends FicheroTexto implements Analizable {
    private String fuente, colorFuente;
    private int tamanoFuente;

    public FicheroTextoFormateado(String name, String[] contenido, String fuente, int tamanoFuente, String colorFuente) throws FicheroException {
        super(name, contenido);
        setFuente(fuente);
        setColorFuente(colorFuente);
        setTamanoFuente(tamanoFuente);
    }

    public void setFuente(String fuente) throws FicheroException {
        if (fuente.isBlank() || fuente.length() < 3) {
            throw new FicheroException("Se ha introducido un valor incorrecto");
        }
        this.fuente = fuente;
    }

    public void setColorFuente(String colorFuente) throws FicheroException {
        if (!colorFuente.matches("^#[0-9a-fA-F]{6}$")) {
            throw new FicheroException("No se ha recibido el color en formato hexadecimal");
        }
        this.colorFuente = colorFuente;
    }

    public void setTamanoFuente(int tamanoFuente) throws FicheroException {
        if (tamanoFuente < 1) {
            throw new FicheroException("El tamaño del texto no puede ser inferior a 1");
        }
        this.tamanoFuente=tamanoFuente;
    }

    @Override
    public void analizar() {
        System.out.println("Analizando " + getName());

    }

}
