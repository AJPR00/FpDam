package Tema5_ConceptoAvanzadosOPP.Examenes;

public class FicheroBinario extends Fichero{

    private byte[] arrayFicheroBinario;


    public FicheroBinario(String name, byte[] arrayFicheroBinario) throws FicheroException {
        super(name);
        setArrayFicheroBinario(arrayFicheroBinario);
    }

    public void setArrayFicheroBinario(byte[] arrayFicheroBinario) throws FicheroException {
        if (arrayFicheroBinario.length<0){
            throw new FicheroException("No se puede crear un fichero vacio");
        }        this.arrayFicheroBinario = arrayFicheroBinario;
    }

    @Override
    public long tamanoFichero() {
        return arrayFicheroBinario.length;
    }
}
