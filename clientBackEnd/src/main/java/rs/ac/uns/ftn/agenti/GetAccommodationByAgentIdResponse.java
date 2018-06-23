//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.23 at 07:04:00 PM CEST 
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
 *         &lt;element name="accommodationUnitWs" type="{http://www.ftn.uns.ac.rs/agenti}AccommodationUnitWs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="messages" type="{http://www.ftn.uns.ac.rs/agenti}messageWs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reservations" type="{http://www.ftn.uns.ac.rs/agenti}reservationWs" maxOccurs="unbounded" minOccurs="0"/>
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
    "accommodationUnitWs",
    "messages",
    "reservations"
})
@XmlRootElement(name = "getAccommodationByAgentIdResponse")
public class GetAccommodationByAgentIdResponse {

    @XmlElement(nillable = true)
    protected List<AccommodationUnitWs> accommodationUnitWs;
    @XmlElement(nillable = true)
    protected List<MessageWs> messages;
    @XmlElement(nillable = true)
    protected List<ReservationWs> reservations;

    /**
     * Gets the value of the accommodationUnitWs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodationUnitWs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodationUnitWs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccommodationUnitWs }
     * 
     * 
     */
    public List<AccommodationUnitWs> getAccommodationUnitWs() {
        if (accommodationUnitWs == null) {
            accommodationUnitWs = new ArrayList<AccommodationUnitWs>();
        }
        return this.accommodationUnitWs;
    }

    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MessageWs }
     * 
     * 
     */
    public List<MessageWs> getMessages() {
        if (messages == null) {
            messages = new ArrayList<MessageWs>();
        }
        return this.messages;
    }

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

}
