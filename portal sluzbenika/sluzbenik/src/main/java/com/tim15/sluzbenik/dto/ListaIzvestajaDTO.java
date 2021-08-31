package com.tim15.sluzbenik.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ListaIzvestajaDTO {
    private List<IzvestajDTO> lista = new ArrayList<IzvestajDTO>();

    public ListaIzvestajaDTO(List<IzvestajDTO> lista) {
        this.lista = lista;
    }

    public ListaIzvestajaDTO() {
    }

    public List<IzvestajDTO> getLista() {
        return lista;
    }

    public void setLista(List<IzvestajDTO> lista) {
        this.lista = lista;
    }
}
