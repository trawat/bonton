
package com.desia.artifacts.search;

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
@WebService(name = "TGServiceEndPoint", targetNamespace = "http://endpoints.services.travelguru.com/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TGServiceEndPoint {


    /**
     * 
     * @param otaHotelAvailRQ
     * @return
     *     returns com.desia.artifacts.search.OTAHotelAvailRS
     */
    @WebMethod
    @WebResult(name = "OTA_HotelAvailRS", targetNamespace = "http://www.opentravel.org/OTA/2003/05", partName = "OTA_HotelAvailRS")
    public OTAHotelAvailRS fetchResponse(
        @WebParam(name = "OTA_HotelAvailRQ", targetNamespace = "http://www.opentravel.org/OTA/2003/05", partName = "OTA_HotelAvailRQ")
        OTAHotelAvailRQ otaHotelAvailRQ);

}
