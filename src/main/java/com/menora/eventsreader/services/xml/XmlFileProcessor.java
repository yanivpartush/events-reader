package com.menora.eventsreader.services.xml;

import com.menora.eventsreader.entities.xml.Root;
import com.menora.eventsreader.repositories.InsuredRepository;
import com.menora.eventsreader.services.db.XmlRootPersistHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Instant;

@Component
public class XmlFileProcessor {

    @Value("${xml.file.name}")
    private String fileNameToProcess;

    @Autowired
    private XmlParser xmlParser;

    @Autowired
    private InsuredRepository insuredRepository;

    private Root rootObject;

    @Autowired
    private XmlRootPersistHandler xmlRootPersistHandler;

    @Scheduled(cron = "${cron.expression}")
    public void execute() {
        System.out.println("Processing started at [ " + Instant.now() + "]");
        process();
        String companyId = xmlRootPersistHandler.persist(rootObject);
        System.out.println("File processed for company id = [ " + companyId + "]");
    }

    private void process() {
        System.out.println("Reading file [ " + fileNameToProcess + "]");
        File fileToProcess = new File(fileNameToProcess);
        rootObject = xmlParser.parse(fileToProcess);
    }

}
