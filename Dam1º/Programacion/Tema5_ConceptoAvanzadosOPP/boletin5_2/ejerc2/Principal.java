package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc2;

public class Principal {
    public static void main(String[] args) {
        Forma[] formas = new Forma[4];

        formas[0] = new Circulo(2);
        formas[1] = new Linea(52);
        formas[2] = new Rectangulo(2, 2);
        formas[3] = new CirculoMovible(8.1);
        Canvas c = new Canvas();

        c.dibujaYAnimaFormas(formas);
        //si establezco el try catch fuera del for, este finaliza cuando trate una excepción, de la siguiente forma solo para la iteración del for cuando se ejecuta el método calcularArea.
        for (int i = 0; i < formas.length; i++) {
            try {
                System.out.println(formas[i].calcularArea());
            } catch (FicheroException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
