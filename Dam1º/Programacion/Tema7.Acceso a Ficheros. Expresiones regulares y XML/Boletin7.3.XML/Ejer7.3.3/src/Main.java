import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class Main {


   /* 3. Dado el archivo desayuno.xml:
            ● Muestra por pantalla el nombre de aquellos platos que cuesten menos de 5€.
            ● Muestra por pantalla el nombre de aquellos platos que tengan menos de 500 calorías.
            ● Añade a cada plato un atributo, con un identificador numérico comenzando en 1, desde el primero al último (des.
            ● Inventa un nuevo plato y añádelo al documento (debe guardarse).
            ● Elimina aquellos platos que tengan más de 500 calorías y guarda el resultado en un xml llamado desayuno_saludable.xml*/

    public static <DOMSource> void main(String[] args) {
        double productoPorMenos€ = 5;
        double productoPorMenosCalorias = 500;
        int contadorFor = 0;

        try {
            //Inicializadores de XML.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Creamos el documento(en memoria).
            Document doc = dBuilder.parse("D:\\Desktop\\Intellij\\Tema7.Acceso a Ficheros. Expresiones regulares y XML\\Boletin7.3.XML\\Ejer7.3.3\\desayuno.xml");

          /* Normalizamos el documento creado para que no haya espacios en blanco dentro de las etiquetas,
            dentro de los valores … se consigue que no haya errores.*/
            doc.normalize();

            Element elementoRaiz = doc.getDocumentElement();


            //● Muestra por pantalla el nombre de aquellos platos que cuesten menos de 5€.

            System.out.println("**** Platos por menos de " + productoPorMenos€ + "€ ****");
            NodeList platos = doc.getElementsByTagName("food");

//Todo averiguar si es posible recicler un for mediante flujo/hilos!!

            for (int i = 0; i < platos.getLength(); i++) {
                Element food = (Element) platos.item(i);

                /**
                 *
                 * Diferencia entre replaceAll usa regex com primer parámetro y replace solo cadena.
                 * Hay precios que tiene puntos y otros comas, reemplazamos los puntos por coma con setTextContent.
                 */
                String precio = food.getElementsByTagName("price").item(0).getTextContent();
                String precioComasPorPunto = precio.replace(",", ".");
                food.getElementsByTagName("price").item(0).setTextContent(precioComasPorPunto);
                double precioProducto = Double.parseDouble(food.getElementsByTagName("price").item(0).getTextContent().substring(0, precio.length() - 1));

                if (precioProducto < productoPorMenos€) {
                    System.out.println(food.getElementsByTagName("name").item(0).getTextContent() + " Pvp: " + precioProducto);
                }
            }

            //● Muestra por pantalla el nombre de aquellos platos que tengan menos de 500 calorías.

            System.out.println("**** Platos por debajo de  " + productoPorMenosCalorias + " calorías ****");

            for (int i = 0; i < platos.getLength(); i++) {
                Element food = (Element) platos.item(i);

                if (Double.parseDouble(food.getElementsByTagName("calories").item(0).getTextContent()) < productoPorMenosCalorias) {
                    System.out.println(food.getElementsByTagName("name").item(0).getTextContent());
                }
            }

            // ● Añade a cada plato un atributo, con un identificador numérico comenzando en 1, desde el primero al último (des.


            for (int i = 0; i < platos.getLength(); i++) {

                Element plato = (Element) platos.item(i);
                Attr idPlato = doc.createAttribute("id"); // Crear un nuevo atributo para cada plato
                idPlato.setValue(String.valueOf(i + 1)); // Establecer el valor del atributo "id"
                plato.setAttributeNode(idPlato); // Agregar el atributo "id" al elemento "plato"


                //Otra manera mas directa.
                //plato.setAttribute("id", String.valueOf(i + 1));
            }


            //● Inventa un nuevo plato y añádelo al documento (debe guardarse).


            /* Recorre y devuelve el valor de los atributos id

            for (int i = 0; i < platos.getLength(); i++) {
                Element plato = (Element) platos.item(i);
                System.out.println(plato.getAttributes().getNamedItem("id").getNodeValue());
            }*/


            Element ePlato = doc.createElement("food");
            Element eNombre = doc.createElement("name");
            Element ePrecio = doc.createElement("price");
            Element eDescripcion = doc.createElement("description");
            Element eCalorias = doc.createElement("calories");


            Attr idPlato = doc.createAttribute("id");
            idPlato.setValue(String.valueOf(platos.getLength() + 1));
            ePlato.setAttributeNode(idPlato);
            ePlato.appendChild(eNombre).setTextContent("Desayuno Mediterraneo, del Gitano");
            ePlato.appendChild(ePrecio).setTextContent("0.80€");
            ePlato.appendChild(eDescripcion).setTextContent("Bollo de Antequera con fina capa de una untado de plátano del dia");
            ePlato.appendChild(eCalorias).setTextContent("125");
            elementoRaiz.appendChild(ePlato);

            // Se guarda el documento
            guardaDoc(doc, "D:\\Desktop\\Intellij\\Tema7.Acceso a Ficheros. Expresiones regulares y XML\\Boletin7.3.XML\\Ejer7.3.3\\desayunoNuevoPlato.xml");


            /*
            1º Creamos una instancia de la clase File para acceder al archivo donde guardaremos el XML.
            File guardarXML = new File("D:\\Desktop\\Intellij\\Tema7.Acceso a Ficheros. Expresiones regulares y XML\\Boletin7.3.XML\\Ejer7.3.3\\desayunoNuevo.xml");


            // 2º Creamos una nueva instancia del transformador a través de la fábrica de
            // transformadores.

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            // 3º Establecemos algunas opciones de salida, como por ejemplo, la codificación
            // de salida.


            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            // 4º Creamos el StreamResult, que intermediará entre el transformador y el
            // archivo de destino.

            StreamResult result = new StreamResult(guardarXML);

            // 5º Creamos el DOMSource, que intermediará entre el transformador y el árbol
            // DOM.

            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);

            // 6º Realizamos la transformación.

            transformer.transform(source, result);

        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {

            System.out.println("¡Error! No se ha podido cargar el documento XML: " + ex.getMessage());

        } catch (TransformerException e) {

            System.out.println("¡Error! No se ha podido llevar a cabo la transformación.");

        }*/
        } catch (ParserConfigurationException e) {
            System.err.println("Error de configuración del parser: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (SAXException e) {
            System.err.println("Error durante el análisis del XML: " + e.getMessage());
            throw new RuntimeException(e);

        }
    }

    /**
     * Método que guarda el documento recibido por parámetros en la ruta de salida
     * especificada
     *
     * @param doc
     * @param rutaSalida
     */

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