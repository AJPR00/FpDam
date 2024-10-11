package Tema5_ConceptoAvanzadosOPP.Examenes;

public class FicheroTexoPlano extends FicheroTexto implements Representable {


    public FicheroTexoPlano(String name, String[] contenido) {
        super(name, contenido);
    }


    @Override
    public void imprimir() {
        for (int i = 0; i < matrizContenedor[0].length; i++) {
            System.out.println(matrizContenedor[i][0]);
        }

    }
}
