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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Punto1 {

    /*Se pide crear un nuevo archivo java para cada uno de los siguientes puntos, con nombre
    Ejercicio1.java, Ejercicio2.java, etc. No se pedirá nada por teclado.
            1. Exporta el contenido del fichero XML a un fichero en formato registros, con el
    siguiente formato:

    identificador:codigo_vuelo:nombre_compañía:hora_salida:destino

*/
    public static void main(String[] args) {


        //Inicializadores de XML.
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Creamos el documento(en memoria).
            Document doc = dBuilder.parse("C:\\Users\\Alumno\\Desktop\\Programacion\\Tema7.Acceso a Ficheros. Expresiones regulares y XML\\ExamenAeropuerto\\Aeropuerto.xml");
            doc.normalize();

            Element elementoRaiz = doc.getDocumentElement();

               /* 1. Exporta el contenido del fichero XML a un fichero en formato registros, con el
                siguiente formato:
                identificador:codigo_vuelo:nombre_compañía:hora_salida:destino*/


            try (PrintWriter pW = new PrintWriter(new FileWriter("C:\\Users\\Alumno\\Desktop\\Programacion\\Tema7.Acceso a Ficheros. Expresiones regulares y XML\\ExamenAeropuerto\\Aeropuerto.txt"))) {

                NodeList vuelos = doc.getElementsByTagName("vuelo");

                for (int i = 0; i < vuelos.getLength(); i++) {
                    Element vuelo = (Element) vuelos.item(i);

                    String id = vuelo.getElementsByTagName("id").item(0).getTextContent();
                    String codigo = vuelo.getElementsByTagName("codigo").item(0).getTextContent();
                    String compania = vuelo.getElementsByTagName("compania").item(0).getTextContent();
                    String horaSalida = vuelo.getElementsByTagName("hora_salida").item(0).getTextContent().replace(":", "_");
                    String destino = vuelo.getElementsByTagName("destino").item(0).getTextContent();


                    StringBuilder sB = new StringBuilder();
                    sB.append(id).append(":").append(codigo).append(":").append(compania).append(":").append(horaSalida).append(":").append(destino);

                    pW.println(sB);
                }

            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida durante la lectura del archivo XML." + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Error al analizar o no se puede crear un analizador XML con la configuración proporcionada." + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error, XML no está bien formado, no sigue las reglas de la especificación XML");
        }
    }

}
