//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.23 at 10:59:50 PM CEST 
//


package rs.ac.uns.ftn.agenti;

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
 *         &lt;element name="staos" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "staos"
})
@XmlRootElement(name = "getAccommodationParametersRequest")
public class GetAccommodationParametersRequest {

    @XmlElement(required = true)
    protected String staos;

    /**
     * Gets the value of the staos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaos() {
        return staos;
    }

    /**
     * Sets the value of the staos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaos(String value) {
        this.staos = value;
    }

}
