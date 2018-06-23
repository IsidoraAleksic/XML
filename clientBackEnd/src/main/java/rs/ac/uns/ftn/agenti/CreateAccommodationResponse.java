//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.23 at 06:15:52 PM CEST 
//


package rs.ac.uns.ftn.agenti;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAccommodation" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idImage" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
 *         &lt;element name="idPricing" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "idAccommodation",
    "idImage",
    "idPricing"
})
@XmlRootElement(name = "createAccommodationResponse")
public class CreateAccommodationResponse {

    protected long idAccommodation;
    @XmlElement(type = Long.class)
    protected List<Long> idImage;
    protected long idPricing;

    /**
     * Gets the value of the idAccommodation property.
     * 
     */
    public long getIdAccommodation() {
        return idAccommodation;
    }

    /**
     * Sets the value of the idAccommodation property.
     * 
     */
    public void setIdAccommodation(long value) {
        this.idAccommodation = value;
    }

    /**
     * Gets the value of the idImage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idImage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdImage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getIdImage() {
        if (idImage == null) {
            idImage = new ArrayList<Long>();
        }
        return this.idImage;
    }

    /**
     * Gets the value of the idPricing property.
     * 
     */
    public long getIdPricing() {
        return idPricing;
    }

    /**
     * Sets the value of the idPricing property.
     * 
     */
    public void setIdPricing(long value) {
        this.idPricing = value;
    }

}
