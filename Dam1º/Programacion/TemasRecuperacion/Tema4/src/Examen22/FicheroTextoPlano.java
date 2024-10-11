package Examen22;

public class FicheroTextoPlano extends FicheroTexto implements Representable {

    public FicheroTextoPlano(String nombre) {
        super(nombre);
    }

    @Override
    public void imprimir(String src) {
        System.out.println(src);
    }




}
