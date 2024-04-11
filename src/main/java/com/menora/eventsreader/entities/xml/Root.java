package com.menora.eventsreader.entities.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Root {

    @XmlElement(name = "requestDetails")
    private RequestDetails requestDetails;

    @XmlElementWrapper(name = "events")
    @XmlElement(name = "event")
    private List<Event> events;


}





