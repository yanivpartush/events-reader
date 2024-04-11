package com.menora.eventsreader.entities.xml;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Event {
    private String id;
    private String type;
    private String insuredId;

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    private List<Product> products;


}
