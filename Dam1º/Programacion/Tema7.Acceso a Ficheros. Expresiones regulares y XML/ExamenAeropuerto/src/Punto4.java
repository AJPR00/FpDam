import jdk.dynalink.NamedOperation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Punto4 {
  /*  4. Extra: Crea un nuevo fichero de vuelos en XML por cada continente (sin importar el
            nombre del continente) de la aerolínea y guarda en él todos los vuelos (con su
            información) asociados a dicho continente, sin importar el orden. Para aclarar, en el
            mismo formato que el fichero original. Puedes suponer que el código del aeropuerto
            es una constante.*/


    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Creamos el documento(en memoria).
            Document doc = dBuilder.parse(".\\ExamenAeropuerto\\Aeropuerto.xml");
            String directorioOut = ".\\ExamenAeropuerto\\";
            doc.normalize();

            Document vuelosPorContienentes = dBuilder.newDocument();
            Element continentes = vuelosPorContienentes.createElement("continetes");
            vuelosPorContienentes.appendChild(continentes);


            NodeList listaVuelos = doc.getElementsByTagName("vuelo");
            HashMap<String, ArrayList<Element>> continenteVuelos = new HashMap<>();


            // For recore la lista de Node del documento principal y almacenar las key e inicializar la lista, con su respective key
            for (int i = 0; i < listaVuelos.getLength(); i++) {
                /**
                 * Almacenamos en una variable el element vuelo.
                 * Extraemos el primer dígito del ID del vuelo y lo almacenamos en idContinente
                 * Comprobamso mediante el método computeIfAbsent() si la key existe y si tiene valor, si no
                 * existe la crea y lo almacena
                 */
                Element vuelo = (Element) listaVuelos.item(i);
                String idContinente = vuelo.getElementsByTagName("id").item(0).getTextContent().substring(0, 1);
                continenteVuelos.computeIfAbsent(idContinente, e -> new ArrayList<>()).add(vuelo);
            }

            for (String id : continenteVuelos.keySet()) {
                Element continenteElement = vuelosPorContienentes.createElement("continente");
                continenteElement.setAttribute("id", id);
                continentes.appendChild(continenteElement);

                for (Element vuelo : continenteVuelos.get(id)) {
                    vuelo.removeChild(vuelo.getElementsByTagName("id").item(0));
                    Element eVueloClonado = (Element) vuelosPorContienentes.importNode(vuelo, true);
                    continenteElement.appendChild(eVueloClonado);
                }

                // Guardar el documento XML en un archivo por continente
                guardaDoc(vuelosPorContienentes, directorioOut + "Continente." + id + ".xml");
                continenteElement.getParentNode().removeChild(continenteElement); // Limpiar el documento para el próximo continente
            }
            continenteVuelos.get("1").forEach(v -> System.out.println(v.getElementsByTagName("codigo").item(0).getTextContent()));


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
            doc.normalizeDocument();

            // Asignamos las propiedas de salida para el transformador
            t.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            t.setOutputProperty(OutputKeys.INDENT, "yes");

            // Declaramos el documento fuente
            DOMSource fuente = new DOMSource(doc);

            // Declaramos el flujo de salida
            StreamResult resultado = new StreamResult(rutaSalida);

            // Guardamos el documento cargado en memoria
            t.transform(fuente, resultado);

        } catch (TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
    }
}
