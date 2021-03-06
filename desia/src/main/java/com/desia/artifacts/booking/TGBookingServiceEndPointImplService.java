
package com.desia.artifacts.booking;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TGBookingServiceEndPointImplService", targetNamespace = "http://endpoints.services.travelguru.com/", 
wsdlLocation = "http://stage-api.travelguru.com/services-2.0/tg-services/TGBookingServiceEndPoint?wsdl")
public class TGBookingServiceEndPointImplService
    extends Service
{

    private final static URL TGBOOKINGSERVICEENDPOINTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException TGBOOKINGSERVICEENDPOINTIMPLSERVICE_EXCEPTION;
    private final static QName TGBOOKINGSERVICEENDPOINTIMPLSERVICE_QNAME = new QName("http://endpoints.services.travelguru.com/", "TGBookingServiceEndPointImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://stage-api.travelguru.com/services-2.0/tg-services/TGBookingServiceEndPoint?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TGBOOKINGSERVICEENDPOINTIMPLSERVICE_WSDL_LOCATION = url;
        TGBOOKINGSERVICEENDPOINTIMPLSERVICE_EXCEPTION = e;
    }

    public TGBookingServiceEndPointImplService() {
        super(__getWsdlLocation(), TGBOOKINGSERVICEENDPOINTIMPLSERVICE_QNAME);
    }

    public TGBookingServiceEndPointImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TGBOOKINGSERVICEENDPOINTIMPLSERVICE_QNAME, features);
    }

    public TGBookingServiceEndPointImplService(URL wsdlLocation) {
        super(wsdlLocation, TGBOOKINGSERVICEENDPOINTIMPLSERVICE_QNAME);
    }

    public TGBookingServiceEndPointImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TGBOOKINGSERVICEENDPOINTIMPLSERVICE_QNAME, features);
    }

    public TGBookingServiceEndPointImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TGBookingServiceEndPointImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TGBookingServiceEndPoint
     */
    @WebEndpoint(name = "TGBookingServiceEndPointImplPort")
    public TGBookingServiceEndPoint getTGBookingServiceEndPointImplPort() {
        return super.getPort(new QName("http://endpoints.services.travelguru.com/", "TGBookingServiceEndPointImplPort"), TGBookingServiceEndPoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TGBookingServiceEndPoint
     */
    @WebEndpoint(name = "TGBookingServiceEndPointImplPort")
    public TGBookingServiceEndPoint getTGBookingServiceEndPointImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://endpoints.services.travelguru.com/", "TGBookingServiceEndPointImplPort"), TGBookingServiceEndPoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TGBOOKINGSERVICEENDPOINTIMPLSERVICE_EXCEPTION!= null) {
            throw TGBOOKINGSERVICEENDPOINTIMPLSERVICE_EXCEPTION;
        }
        return TGBOOKINGSERVICEENDPOINTIMPLSERVICE_WSDL_LOCATION;
    }

}
