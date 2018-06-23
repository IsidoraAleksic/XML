//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.23 at 10:59:50 PM CEST 
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
 *         &lt;element name="additionalServices" type="{http://www.ftn.uns.ac.rs/agenti}additionalServicesWs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accommodationCategories" type="{http://www.ftn.uns.ac.rs/agenti}accommodationCategoryWs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accommodationTypes" type="{http://www.ftn.uns.ac.rs/agenti}accommodationTypeWs" maxOccurs="unbounded" minOccurs="0"/>
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
    "additionalServices",
    "accommodationCategories",
    "accommodationTypes"
})
@XmlRootElement(name = "getAccommodationParametersResponse")
public class GetAccommodationParametersResponse {

    protected List<AdditionalServicesWs> additionalServices;
    protected List<AccommodationCategoryWs> accommodationCategories;
    protected List<AccommodationTypeWs> accommodationTypes;

    /**
     * Gets the value of the additionalServices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalServices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalServicesWs }
     * 
     * 
     */
    public List<AdditionalServicesWs> getAdditionalServices() {
        if (additionalServices == null) {
            additionalServices = new ArrayList<AdditionalServicesWs>();
        }
        return this.additionalServices;
    }

    /**
     * Gets the value of the accommodationCategories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodationCategories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodationCategories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccommodationCategoryWs }
     * 
     * 
     */
    public List<AccommodationCategoryWs> getAccommodationCategories() {
        if (accommodationCategories == null) {
            accommodationCategories = new ArrayList<AccommodationCategoryWs>();
        }
        return this.accommodationCategories;
    }

    /**
     * Gets the value of the accommodationTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodationTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodationTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccommodationTypeWs }
     * 
     * 
     */
    public List<AccommodationTypeWs> getAccommodationTypes() {
        if (accommodationTypes == null) {
            accommodationTypes = new ArrayList<AccommodationTypeWs>();
        }
        return this.accommodationTypes;
    }

}
