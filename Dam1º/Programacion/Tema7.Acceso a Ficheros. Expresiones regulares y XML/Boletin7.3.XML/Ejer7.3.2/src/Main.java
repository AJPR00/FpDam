import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main {

 /*   2. Se tiene una página web en formato html en el archivo web1.html. Partiendo de la misma:
            ● Imprime el título de la página web
            ● Cuenta cuántos divisores existen
            ● Cuenta cuántos divisores tienen el atributo id con valor
            ● Imprime por pantalla el texto alternativo de todas las imágenes que haya
            ● Imprime por pantalla el titular de las noticias que haya en la página, seguido del texto
              alternativo de la imagen que la acompaña.
            ● Imprime por pantalla las opciones del menú principal
            ● Muestra ahora todos los titulares de noticia, seguido en la línea de abajo del texto de
              la misma*/


    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(".\\Boletin7.3.XML\\Ejer7.3.2\\web1.html");

            doc.normalize();
            Element elementoRaiz = doc.getDocumentElement();
            NodeList nodosHtml = elementoRaiz.getChildNodes();

            NodeList list2 = nodosHtml.item(1).getChildNodes();

            System.out.print("# Titulo: " + ((Element) list2.item(1)).getTextContent());

            NodeList numeroDiv = doc.getElementsByTagName("div");
            System.out.println("\n# Número de div: " + numeroDiv.getLength());

            int contador = 0;

            for (int i = 0; i < numeroDiv.getLength(); i++) {

                if (numeroDiv.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    if (((Element) numeroDiv.item(i)).getAttribute("id").isBlank()) {
                        contador++;
                    }
                }
            }
            System.out.println("# Número de div con id: " + contador);

            NodeList lisAltImg = doc.getElementsByTagName("img");
            for (int i = 0; i < lisAltImg.getLength(); i++) {
                if (lisAltImg.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("Texto alternativo al src: " + ((Element) lisAltImg.item(i)).getAttribute("alt"));
                }
            }

            NodeList lisNoticiaH2 = doc.getElementsByTagName("h2");

            for (int i = 0; i < lisNoticiaH2.getLength(); i++) {
                if (lisNoticiaH2.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("Noticia: " + ((Element) lisNoticiaH2.item(i)).getTextContent() + ":::::" + ((Element) lisAltImg.item(i)).getAttribute("alt"));
                }
            }

            System.out.println("************ Noticias reumidas ************");
            for (int i = 0; i < lisNoticiaH2.getLength(); i++) {
                if (lisNoticiaH2.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("Noticia: " + ((Element) lisNoticiaH2.item(i)).getTextContent() + " ---> Resumen:  " + ((Element) numeroDiv.item(0).getChildNodes()).getElementsByTagName("p").item(i).getTextContent());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}