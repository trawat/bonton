
package com.desia.artifacts.booking;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TGBookingServiceEndPoint", targetNamespace = "http://endpoints.services.travelguru.com/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TGBookingServiceEndPoint {


    /**
     * 
     * @param otaHotelResRQ
     * @return
     *     returns com.desia.artifacts.booking.OTAHotelResRS
     */
    @WebMethod
    @WebResult(name = "OTA_HotelResRS", targetNamespace = "http://www.opentravel.org/OTA/2003/05", partName = "OTA_HotelResRS")
    public OTAHotelResRS createBooking(
        @WebParam(name = "OTA_HotelResRQ", targetNamespace = "http://www.opentravel.org/OTA/2003/05", partName = "OTA_HotelResRQ")
        OTAHotelResRQ otaHotelResRQ);

    /**
     * 
     * @param otaCancelRQ
     * @return
     *     returns com.desia.artifacts.booking.OTACancelRS
     */
    @WebMethod
    @WebResult(name = "OTA_CancelRS", targetNamespace = "http://www.opentravel.org/OTA/2003/05", partName = "OTA_CancelRS")
    public OTACancelRS cancelBooking(
        @WebParam(name = "OTA_CancelRQ", targetNamespace = "http://www.opentravel.org/OTA/2003/05", partName = "OTA_CancelRQ")
        OTACancelRQ otaCancelRQ);

    /**
     * 
     * @param otaHotelResModifyNotifRQ
     * @return
     *     returns com.desia.artifacts.booking.HotelResModifyResponseType
     */
    @WebMethod
    @WebResult(name = "OTA_HotelResModifyNotifRS", targetNamespace = "http://www.opentravel.org/OTA/2003/05", partName = "OTA_HotelResModifyNotifRS")
    public HotelResModifyResponseType modifyReservation(
        @WebParam(name = "OTA_HotelResModifyNotifRQ", targetNamespace = "http://www.opentravel.org/OTA/2003/05", partName = "OTA_HotelResModifyNotifRQ")
        HotelResModifyRequestType otaHotelResModifyNotifRQ);

}