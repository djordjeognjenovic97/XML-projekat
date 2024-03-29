package com.projekat.poverenik.soap.izvestaj;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-09-01T01:49:55.839+02:00
 * Generated source version: 3.4.4
 *
 */
@WebService(targetNamespace = "https://github.com/djordjeognjenovic97/XML-projekat/izvestaj", name = "IzvestajServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface IzvestajServicePortType {

    @WebMethod(action = "http://izvestaj/ws/sendIzvestaj")
    public void sendIzvestaj(

        @WebParam(partName = "izvestaj", name = "izvestaj")
        Izvestaj izvestaj
    );
}
