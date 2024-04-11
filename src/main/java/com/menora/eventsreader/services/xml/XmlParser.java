package com.menora.eventsreader.services.xml;

import com.menora.eventsreader.entities.xml.Root;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class XmlParser  {

    public Root parse(File fileToParse) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Root root = (Root) unmarshaller.unmarshal(fileToParse);

            return root;
        } catch (
                JAXBException e) {
            System.out.println("Parsing error.Reason : " + e);
        }
        return null;
    }
}
