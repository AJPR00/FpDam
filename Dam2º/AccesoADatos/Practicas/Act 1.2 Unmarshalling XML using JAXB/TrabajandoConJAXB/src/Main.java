import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        try {

            //Marshalling Coche;

            Catalogo catalog = new Catalogo("Catalogo");
            catalog.addBookCatalogo(new Book("bk101","XML Developer's Guide", Date.from(),"Computer"));
            JAXBContext context = JAXBContext.newInstance(Catalogo.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(catalog, new File("Catalogo.xml"));

            // Coche;
           /* JAXBContext context = JAXBContext.newInstance(Coche.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Coche nuevoCocheUnmarshalled = (Coche) unmarshaller.unmarshal(new File("nuevoCoche.xml"));
            System.out.println("Tenemos un " + nuevoCocheUnmarshalled.getMarca() +
                    " " + nuevoCocheUnmarshalled.getModelo() +
                    " y tiene la matrícula: " + nuevoCocheUnmarshalled.getMatricula());

           // Marshalling BBDD coches;
            JAXBContext context = JAXBContext.newInstance(BBDDCoches.class);
            Coche nuevoCoche = new Coche("1234ABD", "Seat", "Leon");
            Coche nuevoCoche2 = new Coche("4356BBC", "Toyota", "Corolla");
            ArrayList<Coche> coches = new ArrayList<>();
            coches.add(nuevoCoche);
            coches.add(nuevoCoche2);
            BBDDCoches bbddCoches = new BBDDCoches(coches);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bbddCoches, new File("coches.xml"));
*/
            //XML to JSON

        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
