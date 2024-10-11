package Tema5_ConceptoAvanzadosOPP.boletin5_2.ejerc2;

public class Canvas {
    void dibujaYAnimaFormas(Forma[] formas) {
        for (Forma forma : formas) {
            if (forma instanceof Dibujable) {
                ((Dibujable) forma).dibujar();
            }
            if (forma instanceof Animable) {
                ((Animable) forma).animar();
            }
        }
    }

}
