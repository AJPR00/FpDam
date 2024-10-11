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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Punto3 {
    /*3. Crea un nuevo documento xml, ayudado del fichero aeropuerto xml, con el nombre
            de las compañías sin repetir, que contenga la siguiente información:
                    <xml>
                    <compañías>
                    <compañía nombre=”Iberia” />
                    <compañía nombre=”British Airways” />
                    </compañías>*/
    public static void main(String[] args) {

        //Inicializadores de XML.
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Creamos el documento(en memoria).
            Document docOrigen = dBuilder.parse(".\\ExamenAeropuerto\\Aeropuerto.xml");
            docOrigen.normalizeDocument();
            //Devuelve el nodo Rey del docuentoXML
            Element elementoPadreOriguen = docOrigen.getDocumentElement();

            // Creamos el 2º Document
            Document docNew = dBuilder.newDocument();
            docNew.appendChild(docNew.createElement("companias"));

            /**
             * docNew.importNode importa el elemento raíz del Document principal al Document destino (docNew) y devuelve en Node nodoImport.
             * @ Node nodoImport, esta variable permite copiar el elemento raíz y su contenido de un documento a otro.
             */
            //Node nodoImport = docNew.importNode(elementoPadreOriguen, true); // Se guaarda en memoria, ahora hay que especificar en que parte del nuevo Document lo queremos.
            //Establecemos el nodo extraido se lo agregamos al nuevo documents
//docNew.appendChild(nodoImport);

            NodeList companias = docOrigen.getElementsByTagName("compania");
            HashSet<String> setCompnia = new HashSet<>();

            for (int i = 0; i < companias.getLength(); i++) {
                setCompnia.add(companias.item(i).getTextContent());
            }
            for (String c : setCompnia) {
                Element compania = docNew.createElement("compania");
                compania.setAttribute("nombre",c);
                docNew.getDocumentElement().appendChild(compania);
            }


            guardaDoc(docNew, ".\\ExamenAeropuerto\\AeropuertoCompañias.xml");

        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
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
