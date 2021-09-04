package com.tim15.sluzbenik.soap;

import com.tim15.sluzbenik.soap.izjasnjenje.IzjasnjenjeServiceSoapBindingImpl;
import com.tim15.sluzbenik.soap.zahtev.ZahtevServiceSoapBindingImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;

    @Autowired
    ZahtevServiceSoapBindingImpl zahtevServiceSoapBinding;

    @Autowired
    IzjasnjenjeServiceSoapBindingImpl izjasnjenjeServiceSoapBindingImpl;

    @Bean
    public Endpoint izvestajEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, zahtevServiceSoapBinding);
        endpoint.publish("/zahtev");
        return endpoint;
    }

    @Bean(name = "izjasnjenjeEndpointBean")
    public Endpoint izjasnjenjeEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, izjasnjenjeServiceSoapBindingImpl);
        endpoint.publish("/izjasnjenje");
        return endpoint;
    }


}
