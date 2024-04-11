package com.menora.eventsreader.entities.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Product {

    private String type;
    private int price;
    private String startDate;
    private String endDate;

}