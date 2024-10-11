import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

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

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("C:\\Users\\Alumno\\Desktop\\Programacion\\boletin7_1\\boletin7_3_XML\\Documents\\web1.html");
            Element raiz = doc.getDocumentElement();

            //● Imprime el título de la página web
            Element titulo = (Element) raiz.getElementsByTagName("title").item(0);
            System.out.println("Este es el nombre del titulo" + titulo.getTextContent());

            // ● Cuenta cuántos divisores tienen el atributo id con valor


            //  ● Imprime por pantalla el texto alternativo de todas las imágenes que haya


            NodeList listaImg = doc.getElementsByTagName("img");

            for (int i = 0;i < listaImg.getLength();i++){
                Element elemento = (Element) listaImg.item(i);

                if (!elemento.getAttribute("alt").isBlank()){
                    System.out.println("La imagen contiene el siguiente texto"+ elemento.getAttribute("alt"));
                }
            }


           /*  ● Imprime por pantalla el titular de las noticias que haya en la página, seguido del texto
                     alternativo de la imagen que la acompaña.*/

            NodeList todosDivisores = doc.getElementsByTagName("div");

            for (int i = 0;i < todosDivisores.getLength();i++){
                Element elemento = (Element) todosDivisores.item(i);
                if (elemento.getAttribute("class").equals("noticia")){
                    String titular = elemento.getElementsByTagName("h2").item(0).getTextContent();
                    System.out.println(titular);
                    String textoAll = ((Element)elemento.getElementsByTagName("img").item(0).getAttributes());
                }
            }



            //● Imprime por pantalla las opciones del menú principal

             //● Muestra ahora todos los titulares de noticia, seguido en la línea de abajo del texto de la misma


        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error de lectura");
        }
    }
}