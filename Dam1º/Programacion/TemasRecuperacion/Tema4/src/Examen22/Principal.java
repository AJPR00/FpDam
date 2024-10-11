package Examen22;

public class Principal {
    public static void main(String[] args) {

        System.out.println("**************Archivo Formateado");
        FicheroTextoFormateado fFormateado = new FicheroTextoFormateado("Fichero Formateado", "estri", "negro", 33);
        fFormateado.addContenido("TextoFormateado contenido sdfdsferwferewrfreqwfreigguifyfiufuffw");
        fFormateado.analizando();
        fFormateado.convertir();
        fFormateado.tamano();
        System.out.println(fFormateado.getTamano());


        System.out.println("\n\n***************Archivo  Plano");
        FicheroTextoPlano fPlano = new FicheroTextoPlano("Fichero de texto PLano");
        fPlano.addContenido("Era ser un avión. Y ser que no fue. De ti ya se fue");
        fPlano.imprimir(fPlano.leerContenido());
        fPlano.tamano();
        System.out.println(fPlano.getTamano());

        System.out.println("\n\n***************Archivo  IMAGEN");
        FicheroImagen fImg = new FicheroImagen("FicheroImg",EFormato.MPG);
        fImg.addContenido("Era ser un avión. Y ser que no fue. De ti ya se fue");
        fImg.imprimir(fPlano.leerContenido());
        fImg.tamano();
        System.out.println(fPlano.getTamano());

    }
}
