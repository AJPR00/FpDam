import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Date;


public class Book {
    private int id;
    private String title;
    private String author;
    private String publisherDate;
    private String genero;
    private String description;
    private Double pvp;

    public Book(int id, String title, Date publisherDate, String author, String genero, String description, Double pvp) {
        this.id = id;
        this.title = title;
        this.publisherDate = publisherDate;
        this.author = author;
        this.genero = genero;
        this.description = description;
        this.pvp = pvp;
    }
@XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    @XmlElement

    public String getAuthor() {
        return author;
    }

    @XmlElement

    public Date getPublisherDate() {
        return publisherDate;
    }

    @XmlElement

    public String getGenero() {
        return genero;
    }

    @XmlElement

    public String getDescription() {
        return description;
    }

    @XmlElement

    public Double getPvp() {
        return pvp;
    }
}
