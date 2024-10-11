package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc2;

public class Rectangulo extends Forma implements Dibujable {
    private double lado1, lado2;

    public Rectangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    @Override
    public void dibujar() {
        System.out.println("Dibujando Rectangulo");
    }
    @Override
    public double calcularArea() throws FicheroException {
        return lado1 * lado2;
    }
}
