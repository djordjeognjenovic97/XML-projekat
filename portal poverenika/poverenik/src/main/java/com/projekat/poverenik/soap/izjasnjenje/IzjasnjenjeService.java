package com.projekat.poverenik.soap.izjasnjenje;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-09-03T16:29:55.269+02:00
 * Generated source version: 3.4.4
 *
 */
@WebServiceClient(name = "IzjasnjenjeService",
                  wsdlLocation = "classpath:wsdl/izjasnjenje.wsdl",
                  targetNamespace = "http://izjasnjenje")
public class IzjasnjenjeService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://izjasnjenje", "IzjasnjenjeService");
    public final static QName IzjasnjenjeServiceSoapBinding = new QName("http://izjasnjenje", "IzjasnjenjeServiceSoapBinding");
    static {
        URL url = IzjasnjenjeService.class.getClassLoader().getResource("wsdl/izjasnjenje.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(IzjasnjenjeService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/izjasnjenje.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public IzjasnjenjeService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public IzjasnjenjeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IzjasnjenjeService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public IzjasnjenjeService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public IzjasnjenjeService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public IzjasnjenjeService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns IzjasnjenjeServicePortType
     */
    @WebEndpoint(name = "IzjasnjenjeServiceSoapBinding")
    public IzjasnjenjeServicePortType getIzjasnjenjeServiceSoapBinding() {
        return super.getPort(IzjasnjenjeServiceSoapBinding, IzjasnjenjeServicePortType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IzjasnjenjeServicePortType
     */
    @WebEndpoint(name = "IzjasnjenjeServiceSoapBinding")
    public IzjasnjenjeServicePortType getIzjasnjenjeServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(IzjasnjenjeServiceSoapBinding, IzjasnjenjeServicePortType.class, features);
    }

}
