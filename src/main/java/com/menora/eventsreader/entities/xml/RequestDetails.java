package com.menora.eventsreader.entities.xml;


import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class RequestDetails {

    private String id;
    private String acceptDate;
    private String sourceCompany;

}
