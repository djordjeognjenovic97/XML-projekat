package com.tim15.sluzbenik.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ListaZahtevaDTO {
    private List<ZahtevDTO> lista = new ArrayList<ZahtevDTO>();

    public ListaZahtevaDTO(List<ZahtevDTO> lista) {
        this.lista = lista;
    }

    public ListaZahtevaDTO() {
    }

    public List<ZahtevDTO> getLista() {
        return lista;
    }

    public void setLista(List<ZahtevDTO> lista) {
        this.lista = lista;
    }
}
