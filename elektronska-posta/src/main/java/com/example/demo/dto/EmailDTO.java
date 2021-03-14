package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "to",
        "subject",
        "text"
})
@XmlRootElement(name = "Email")
public class EmailDTO {

    @XmlElement(required = true, name = "to")
    @NotEmpty(message = "Email ne moze biti prazan.")
    @Email(message = "Nevalidan email.")
    protected String to;

    @XmlElement(required = true, name = "subject")
    @NotEmpty(message = "Naslov ne moze biti prazan.")
    protected String subject;

    @XmlElement(required = true, name = "text")
    @NotEmpty(message = "Poruka ne moze biti prazna.")
    protected String text;

    public EmailDTO(String to, String sub,String text) {
        this.to = to;
        this.subject = sub;
        this.text=text;
    }

    public EmailDTO() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

