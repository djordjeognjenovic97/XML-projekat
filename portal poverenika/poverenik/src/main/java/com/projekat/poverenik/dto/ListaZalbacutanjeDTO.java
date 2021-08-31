package com.projekat.poverenik.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ListaZalbacutanjeDTO {
    private List<ZalbacutanjeDTO> lista = new ArrayList<ZalbacutanjeDTO>();

    public ListaZalbacutanjeDTO() {
    }

    public ListaZalbacutanjeDTO(List<ZalbacutanjeDTO> lista) {
        this.lista = lista;
    }

    public List<ZalbacutanjeDTO> getLista() {
        return lista;
    }

    public void setLista(List<ZalbacutanjeDTO> lista) {
        this.lista = lista;
    }
}
