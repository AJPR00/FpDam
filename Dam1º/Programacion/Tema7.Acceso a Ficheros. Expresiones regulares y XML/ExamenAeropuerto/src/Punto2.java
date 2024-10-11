import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Punto2 {
    /*2.
        El jefe del aeropuerto está pensando cambiar el formato del archivo y necesita una
         prueba de concepto. Se necesitan los siguientes cambios:

             a. El identificador ahora cambia de orden:
                   i. Primero irán los dígitos que representan a la aerolínea
                   ii. Después los que representan al vuelo.
                   iii. Después los del país
                    iv. Por último, el dígito del continente.

              b. No se necesita el nombre de la compañía.
                 Crea un nuevo fichero XML con los cambios solicitados tomando como base el
                 fichero original.
            */
    public static void main(String[] args) {

        //Inicializadores de XML.
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Creamos el documento(en memoria).
            Document doc = dBuilder.parse(".\\ExamenAeropuerto\\Aeropuerto.xml");
            doc.normalize();

            Pattern patron = Pattern.compile("(\\d)(\\d{2})(\\d{2})(\\d{3})");

            NodeList vuelos = doc.getElementsByTagName("vuelo");

            for (int i = 0; i < vuelos.getLength(); i++) {
                Element vuelo = (Element) vuelos.item(i);
                String id = vuelo.getElementsByTagName("id").item(0).getTextContent();
                // Para borrar es necesario hacerlo desde el padre
                vuelo.removeChild(vuelo.getElementsByTagName("compania").item(0));
                Matcher idNew = patron.matcher(id);
                // Restamos uno a la longitud de la lista

                if (idNew.matches()) {
                    vuelo.getElementsByTagName("id").item(0).setTextContent(idNew.replaceAll("$3$4$2$1"));
                }
            }

            guardaDoc(doc, ".\\ExamenAeropuerto\\AeropuertoIdModificado.xml");

        } catch (IOException e) {
            System.out.println("Error de entrada/salida durante la lectura del archivo XML.\n" + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error al analizar, no se puede crear un analizador XML con la configuración proporcionada.\n" + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error, XML no está bien formado, no sigue las reglas de la especificación XML\n" + e.getMessage());
        }
    }


    private static void guardaDoc(Document doc, String rutaSalida) {

        try {
            // Declaramos un nuevo Transformer
            Transformer t = TransformerFactory.newInstance().newTransformer();

            // Normalizamos el documento
            doc.normalize();

            // Asignamos las propiedas de salida para el transformador
            t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            t.setOutputProperty(OutputKeys.INDENT, "yes");

            // Declaramos el documento fuente
            DOMSource fuente = new DOMSource(doc);

            // Declaramos el flujo de salida
            StreamResult resultado = new StreamResult(rutaSalida);

            // Guardamos el documento cargado en memoria
            t.transform(fuente, resultado);

        } catch (TransformerConfigurationException e) {
            System.out.println("Error de configuración del transformer\n" + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Error al transformar\n" + e.getMessage());
        }
    }

}

