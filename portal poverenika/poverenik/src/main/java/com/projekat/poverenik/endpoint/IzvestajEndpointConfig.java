package com.projekat.poverenik.endpoint;

import com.projekat.poverenik.soap.izjasnjenje.IzjasnjenjeServiceSoapBindingImpl;
import com.projekat.poverenik.soap.izvestaj.IzvestajServiceSoapBindingImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class IzvestajEndpointConfig {

    @Autowired
    private Bus bus;

    @Autowired
    IzvestajServiceSoapBindingImpl izvestajServiceSoapBindingImpl;

    @Autowired
    IzjasnjenjeServiceSoapBindingImpl izjasnjenjeServiceSoapBindingImpl;

    @Bean(name = "izvestajEndpointBean")
    public Endpoint izvestajEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, izvestajServiceSoapBindingImpl);
        endpoint.publish("/izvestaj");
        return endpoint;
    }

    @Bean(name = "izjasnjenjeEndpointBean")
    public Endpoint izjasnjenjeEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, izjasnjenjeServiceSoapBindingImpl);
        endpoint.publish("/izjasnjenje");
        return endpoint;
    }
}
