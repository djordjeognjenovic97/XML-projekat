package com.projekat.poverenik.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ListaResenjeDTO {
    private List<ResenjeDTO> lista = new ArrayList<>();

    public ListaResenjeDTO() {
    }

    public ListaResenjeDTO(List<ResenjeDTO> lista) {
        this.lista = lista;
    }

    public List<ResenjeDTO> getLista() {
        return lista;
    }

    public void setLista(List<ResenjeDTO> lista) {
        this.lista = lista;
    }
}
