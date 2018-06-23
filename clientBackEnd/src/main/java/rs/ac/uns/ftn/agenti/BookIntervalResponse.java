//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.

// Generated on: 2018.06.23 at 04:32:37 PM CEST
//


package rs.ac.uns.ftn.agenti;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="reservations" type="{http://www.ftn.uns.ac.rs/agenti}reservationWs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="success" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "reservations",
    "success"
})
@XmlRootElement(name = "bookIntervalResponse")
public class BookIntervalResponse {

    protected List<ReservationWs> reservations;
    protected boolean success;

    /**
     * Gets the value of the reservations property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservations property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservations().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReservationWs }
     *
     *
     */
    public List<ReservationWs> getReservations() {
        if (reservations == null) {
            reservations = new ArrayList<ReservationWs>();
        }
        return this.reservations;
    }

    /**
     * Gets the value of the success property.
     *
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the value of the success property.
     *
     */
    public void setSuccess(boolean value) {
        this.success = value;
    }

}
