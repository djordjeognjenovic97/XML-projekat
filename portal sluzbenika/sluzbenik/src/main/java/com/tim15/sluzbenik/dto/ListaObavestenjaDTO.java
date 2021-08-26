package com.tim15.sluzbenik.dto;


import com.tim15.sluzbenik.model.obavestenjecir.Obavestenje;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ListaObavestenjaDTO {
    private List<ObavestenjeDTO> lista = new ArrayList<ObavestenjeDTO>();

    public ListaObavestenjaDTO(List<ObavestenjeDTO> lista) {
        this.lista = lista;
    }

    public ListaObavestenjaDTO() {
    }

    public List<ObavestenjeDTO> getLista() {
        return lista;
    }

    public void setLista(List<ObavestenjeDTO> lista) {
        this.lista = lista;
    }
}