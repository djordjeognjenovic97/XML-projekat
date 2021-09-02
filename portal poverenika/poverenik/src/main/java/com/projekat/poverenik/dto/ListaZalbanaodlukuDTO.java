package com.projekat.poverenik.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ListaZalbanaodlukuDTO {
    private List<ZalbanaodlukuDTO> lista = new ArrayList<ZalbanaodlukuDTO>();

    public ListaZalbanaodlukuDTO() {
    }

    public ListaZalbanaodlukuDTO(List<ZalbanaodlukuDTO> lista) {
        this.lista = lista;
    }

    public List<ZalbanaodlukuDTO> getLista() {
        return lista;
    }

    public void setLista(List<ZalbanaodlukuDTO> lista) {
        this.lista = lista;
    }
}
