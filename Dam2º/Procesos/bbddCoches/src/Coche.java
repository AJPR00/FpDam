import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"Matrícula","Marca","Modelo" })

public class Coche {
    private String matricula,marca,modelo,color;


}
