//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.10.17 a las 01:24:31 PM CEST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="marca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="10"/>
 *         &lt;element name="combustible" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cilindrada" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="potencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transmision" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="peso" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ancho" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="alto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="largo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deposito" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="puertas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="baul" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="velocidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "marca",
    "modelo",
    "combustible",
    "cilindrada",
    "potencia",
    "transmision",
    "peso",
    "ancho",
    "alto",
    "largo",
    "deposito",
    "puertas",
    "baul",
    "velocidad",
    "precio",
    "descripcion"
})
@XmlRootElement(name = "coche")
public class Coche {

    @XmlElement(required = true)
    protected String marca;
    @XmlElement(required = true)
    protected List<String> modelo;
    @XmlElement(required = true)
    protected String combustible;
    @XmlElement(required = true)
    protected String cilindrada;
    @XmlElement(required = true)
    protected String potencia;
    @XmlElement(required = true)
    protected String transmision;
    @XmlElement(required = true)
    protected String peso;
    @XmlElement(required = true)
    protected String ancho;
    @XmlElement(required = true)
    protected String alto;
    @XmlElement(required = true)
    protected String largo;
    @XmlElement(required = true)
    protected String deposito;
    @XmlElement(required = true)
    protected String puertas;
    @XmlElement(required = true)
    protected String baul;
    @XmlElement(required = true)
    protected String velocidad;
    protected double precio;
    @XmlElement(required = true)
    protected String descripcion;

    /**
     * Obtiene el valor de la propiedad marca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define el valor de la propiedad marca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarca(String value) {
        this.marca = value;
    }

    /**
     * Gets the value of the modelo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modelo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModelo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getModelo() {
        if (modelo == null) {
            modelo = new ArrayList<String>();
        }
        return this.modelo;
    }

    /**
     * Obtiene el valor de la propiedad combustible.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCombustible() {
        return combustible;
    }

    /**
     * Define el valor de la propiedad combustible.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCombustible(String value) {
        this.combustible = value;
    }

    /**
     * Obtiene el valor de la propiedad cilindrada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCilindrada() {
        return cilindrada;
    }

    /**
     * Define el valor de la propiedad cilindrada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCilindrada(String value) {
        this.cilindrada = value;
    }

    /**
     * Obtiene el valor de la propiedad potencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPotencia() {
        return potencia;
    }

    /**
     * Define el valor de la propiedad potencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPotencia(String value) {
        this.potencia = value;
    }

    /**
     * Obtiene el valor de la propiedad transmision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmision() {
        return transmision;
    }

    /**
     * Define el valor de la propiedad transmision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmision(String value) {
        this.transmision = value;
    }

    /**
     * Obtiene el valor de la propiedad peso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeso() {
        return peso;
    }

    /**
     * Define el valor de la propiedad peso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeso(String value) {
        this.peso = value;
    }

    /**
     * Obtiene el valor de la propiedad ancho.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAncho() {
        return ancho;
    }

    /**
     * Define el valor de la propiedad ancho.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAncho(String value) {
        this.ancho = value;
    }

    /**
     * Obtiene el valor de la propiedad alto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlto() {
        return alto;
    }

    /**
     * Define el valor de la propiedad alto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlto(String value) {
        this.alto = value;
    }

    /**
     * Obtiene el valor de la propiedad largo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLargo() {
        return largo;
    }

    /**
     * Define el valor de la propiedad largo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLargo(String value) {
        this.largo = value;
    }

    /**
     * Obtiene el valor de la propiedad deposito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeposito() {
        return deposito;
    }

    /**
     * Define el valor de la propiedad deposito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeposito(String value) {
        this.deposito = value;
    }

    /**
     * Obtiene el valor de la propiedad puertas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuertas() {
        return puertas;
    }

    /**
     * Define el valor de la propiedad puertas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuertas(String value) {
        this.puertas = value;
    }

    /**
     * Obtiene el valor de la propiedad baul.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaul() {
        return baul;
    }

    /**
     * Define el valor de la propiedad baul.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaul(String value) {
        this.baul = value;
    }

    /**
     * Obtiene el valor de la propiedad velocidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVelocidad() {
        return velocidad;
    }

    /**
     * Define el valor de la propiedad velocidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVelocidad(String value) {
        this.velocidad = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     */
    public void setPrecio(double value) {
        this.precio = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

}
