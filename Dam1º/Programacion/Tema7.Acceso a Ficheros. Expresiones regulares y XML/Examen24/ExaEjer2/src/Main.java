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
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * Fíjate en el archivo productos.xml. Necesitamos reconfigurar su estructura. Para ello:
     * Crea un nuevo archivo productosCategorizados.xml, en el que metas los productos agrupados por categorías.
     * Es decir, habrá un nodo raíz llamado categorías, dentro del mismo, una categoría con un atributo nombre,
     * y dentro de la misma, todos los productos que compartan dicha categoría y que cumplan las siguientes condiciones:
     * Su nombre no debe tener menos de 5 ni más de 45 caracteres. Se permite CUALQUIER carácter, incluidos letras,
     * símbolos, espacios, etc.
     * La descripción debe tener entre 10 y 50 palabras.
     * Debe tener categoría.
     * La categoría deberá desaparecer del elemento producto, pues ahora estarán agrupados bajo un elemento categoría.
     * Los precios vienen indistintamente con un punto o una coma. En el nuevo fichero todos los productos deben tener un punto.
     * Eso no significa que los productos con una coma sean incorrectos.
     * Aquellos productos que no cumplan con algún requisito, deberán ir a otro fichero llamado productosIncompletos.xml.
     * En el mismo, deberás introducir los productos también separados por categorías, igual que el original.
     * Aquellos productos sin categoría deben agruparse bajo una categoría llamada “Sin categoría”.
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(".\\Examen24\\ExaEjer2\\src\\productos.xml");
            doc.normalize();

            Document docProductosValidos = dBuilder.newDocument();
            Element categorias = docProductosValidos.createElement("categorias");
            docProductosValidos.appendChild(categorias);

            Document docProductosNoValidos = dBuilder.newDocument();
            Element sinCategoria = docProductosNoValidos.createElement("Sin_categorias");
            docProductosNoValidos.appendChild(sinCategoria);

            String directorioOut = ".\\";


            HashMap<String, ArrayList<Element>> mapCategoriaProducto = new HashMap<>();
            NodeList productos = doc.getElementsByTagName("producto");

            for (int i = 0; i < productos.getLength(); i++) {
                Element producto = (Element) productos.item(i);
                String nombreCategoria = producto.getElementsByTagName("categoria").item(0).getTextContent();

                if (validarElemento(producto)) {
                    Element productoNoValido = (Element) docProductosNoValidos.importNode(producto, true);
                    sinCategoria.appendChild(productoNoValido);
                    productoNoValido.removeChild(productoNoValido.getElementsByTagName("categoria").item(0));
                    continue; //Si isBlank devuelve true por no contener caracteres, saltamos un ciclo del for
                }

                mapCategoriaProducto.computeIfAbsent(nombreCategoria, c -> new ArrayList<>()).add((Element) docProductosNoValidos.importNode(producto, true));
            }

            for (String key : mapCategoriaProducto.keySet()) {
                Element categoria = docProductosValidos.createElement("categoria");
                categoria.setAttribute("nombre", key);
                docProductosValidos.getDocumentElement().appendChild(categoria);

                /*for (ArrayList<Element> arrayElement : mapCategoriaProducto.values()) {
                    for (Element elem : arrayElement) {
                        categoria.appendChild(elem);
                    }

                */}



            guardarDocumento(docProductosNoValidos, ".\\Examen24\\ExaEjer2\\src\\productosNoValido.xml");
            guardarDocumento(docProductosValidos, ".\\Examen24\\ExaEjer2\\src\\productosValido.xml");


        } catch (ParserConfigurationException e) {
            System.out.println("Error, al parsear la entrada");
        } catch (IOException e) {
            System.out.println("Error, al parsear la entrada");

        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean validarElemento(Element elemento) {
        int tamanaNombre = elemento.getElementsByTagName("nombre").item(0).getTextContent().length();
        int tamanoDescripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent().length();
        boolean isCategoria = elemento.getElementsByTagName("categoria").item(0).getTextContent().isBlank();

        if (tamanaNombre >= 5 && tamanaNombre <= 45 && tamanoDescripcion >= 10 && tamanoDescripcion <= 50 && !isCategoria)
            return true;

        return false;
    }

    private static void guardarDocumento(Document doc, String nombreFichero) {
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
            StreamResult resultado = new StreamResult(nombreFichero);

            // Guardamos el documento cargado en memoria
            t.transform(fuente, resultado);

        } catch (TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }

    }

    /**
     * Método que clona un elemento de un documento a otro
     *
     * @param doc
     * @param element
     * @return
     */
    /*private static <Element> Element cloneElement(Document doc, Element element) {
        Element nuevoElemento = doc.createElement(element.getTagName());
        for (int i = 0; i < element.getAttributes().getLength(); i++) {
            nuevoElemento.setAttribute(element.getAttributes().item(i).getNodeName(), element.getAttributes().item(i).getNodeValue());
        }
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i).getNodeType() == Element.ELEMENT_NODE) {
                nuevoElemento.appendChild(cloneElement(doc, (Element) element.getChildNodes().item(i)));
            } else {
                if (!element.getChildNodes().item(i).getTextContent().isBlank())
                    nuevoElemento.appendChild(doc.createTextNode(element.getChildNodes().item(i).getTextContent()));
            }
        }
        return nuevoElemento;
    }*/
}
