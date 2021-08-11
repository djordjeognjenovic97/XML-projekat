package com.tim15.sluzbenik.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "idList")
public class IdList {

    @XmlElement(required = true)
    private List<String> id;

    public IdList() {
    }

    public IdList(ArrayList<String> id) {
        this.id = id;
    }

    public List<String> getIds() {
        return id;
    }

    public void setIds(List<String> id) {
        this.id= id;
    }
}
