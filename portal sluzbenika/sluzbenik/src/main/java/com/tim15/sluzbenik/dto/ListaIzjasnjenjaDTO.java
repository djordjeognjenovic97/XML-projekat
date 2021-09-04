package com.tim15.sluzbenik.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ListaIzjasnjenjaDTO {
    private List<String> lista = new ArrayList<String>();

    public ListaIzjasnjenjaDTO(List<String> lista) {
        this.lista = lista;
    }

    public ListaIzjasnjenjaDTO() {
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}
