import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class Ejer2 {

    /*Ejercicio 2. 4,75 puntos. Utilizando el fichero simpsons.xml, escribe un programa
            en Java que realice las siguientes acciones:
            ● 1.25 puntos. Muestra por pantalla el título y fecha de emisión de aquellos episodios posteriores a 1992.
            ● 1.5 puntos. Genera un nuevo fichero en el que guardes aquellos episodios cuya sinopsis tenga más de 30 palabras.
            ● 2 puntos. Genera un nuevo fichero con todos los episodios donde, cada vez que aparezca un nombre de los personajes principales en la sinopsis (Homer,

                Marge, Bart, Lisa o Maggie), se sustituya por el mismo nombre rodeado de **.
                Es decir, en el siguiente ejemplo:
                    <sinopsis>Esto es una prueba donde aparece Bart y se acaba</sinopsis>
                        En el fichero nuevo debería aparecer:
                        
                            <sinopsis>Esto es una prueba donde aparece **Bart** y se acaba</sinopsis>

                             Nota: la puntuación máxima de cada apartado se dará a las soluciones que
                             sean más genéricas y eficientes. Por ejemplo, en el último punto, encontrar
                             una expresión regular que sustituya cualquier nombre de los dados en lugar
                             de escribir una a una las sustituciones*/

    public static void main(String[] args) {

        //Inicializadores de XML.
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Creamos el documento(en memoria).
            Document doc = dBuilder.parse("C:\\Users\\Alumno\\Desktop\\Programacion\\Tema7.Acceso a Ficheros. Expresiones regulares y XML\\ExamenSimpson\\simson.xml");
            doc.normalize();

            Element elementoRaiz = doc.getDocumentElement();

        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

          /* Normalizamos el documento creado para que no haya espacios en blanco dentro de las etiquetas,
            dentro de los valores … se consigue que no haya errores.*/

       /*  Contar palabars

       Pattern p = Pattern.compile("\\p{L}+");
        for (int i = 0; i < capitulos.getLength(); i++){
            Element capitulo = (Element) capitulos.item(i);

            Element sinopsis = (Element) capitulo.getElementsByTagName("sinopsis").item(0);
            Matcher m = p.matcher(sinopsis.getTextContent());

            if(m.results().count() <= 30){
                raiz.removeChild(capitulo);
                i--;
            }
        }*/


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
