package com.tim15.sluzbenik.soap.zahtev;
import com.tim15.sluzbenik.model.zahtevcir.ObjectFactory;
import com.tim15.sluzbenik.model.zahtevcir.Zahtev;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.4.4
 * 2021-08-09T15:56:26.452+02:00
 * Generated source version: 3.4.4
 *
 */
@WebService(targetNamespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", name = "ZahtevServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ZahtevServicePortType {

    @WebMethod(action = "http://zahtev/ws/getZahtev")
    @WebResult(name = "zahtev", targetNamespace = "https://github.com/djordjeognjenovic97/XML-projekat/zahtev", partName = "zahtev")
    public Zahtev getZahtev(

            @WebParam(partName = "id", name = "id")
                    java.lang.String id
    );
}

