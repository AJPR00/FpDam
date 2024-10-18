import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class Catalogo {
    private String nombre;
    private List<Book> listaBooks;

    public Catalogo(String nombre) {
        this.nombre = nombre;
        this.listaBooks = new LinkedList<>();
    }

    @XmlElement(name = "Book")
    public List<Book> getListaBooks() {
        return listaBooks;
    }

    public void addBookCatalogo(Book book) {
        listaBooks.add(book);
    }
}
