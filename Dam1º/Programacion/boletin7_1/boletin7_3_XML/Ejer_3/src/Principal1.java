import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Principal1 {
    public static void main(String[] args) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("C:\\Users\\Alumno\\Desktop\\Programacion\\boletin7_1\\boletin7_3_XML\\Documents\\desayuno.xml");
            NodeList platos = doc.getElementsByTagName("food");

            double precioBase = 5;
            for (int i = 0; i < platos.getLength(); i++) {
                Element plato = (Element) platos.item(i);
                String textoPrecio = plato.getElementsByTagName("price")
                        .item(i)
                        .getTextContent()
                        .replace(",", ".");
                double precio = Double.parseDouble(textoPrecio.substring(0, textoPrecio.length() - 1));

                if (precio < precioBase) {
                    System.out.println(plato.getElementsByTagName("name").item(0).getTextContent());
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}