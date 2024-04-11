package com.menora.eventsreader.services;

import com.menora.eventsreader.beans.Root;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Service
public class XmlParser {

    public Root parse(File fileToParse) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Root root = (Root) unmarshaller.unmarshal(fileToParse);

            return root;
        } catch (
                JAXBException e) {
            System.out.println("Error.Reason " + e.toString());
        }
        return null;
    }
}
