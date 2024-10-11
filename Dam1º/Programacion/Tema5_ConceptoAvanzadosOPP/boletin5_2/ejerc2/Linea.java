package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc2;

public class Linea extends Forma{
    private double longitud;

    public Linea(double longitud) {
        this.longitud = longitud;
    }
    @Override
    public double calcularArea() throws FicheroException {
        throw  new FicheroException("La linea no puede calchlar su area");
    }
}
