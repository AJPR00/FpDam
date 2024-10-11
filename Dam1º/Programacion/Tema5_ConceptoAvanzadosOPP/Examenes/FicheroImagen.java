package Tema5_ConceptoAvanzadosOPP.Examenes;

public class FicheroImagen extends Fichero {
    private byte[] arrayFicheroImagen;
    private TFormato formato;

    public FicheroImagen(String name, byte[] arrayFicheroImagen, TFormato formato) {
        super(name);
        this.arrayFicheroImagen = arrayFicheroImagen;
        this.formato = formato;
    }

    public TFormato getFormato() {
        return formato;
    }

    public void setFormato(TFormato formato) {


        this.formato = formato;
    }

    @Override
    public long tamanoFichero() {

        return 0;
    }
}
