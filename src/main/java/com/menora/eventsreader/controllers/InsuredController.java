package com.menora.eventsreader.controllers;

import com.menora.eventsreader.controllers.dto.response.CompanyResponseDto;
import com.menora.eventsreader.services.db.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/insureds")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @GetMapping("/{id}")
    public List<CompanyResponseDto> getInsuredById(@PathVariable String id) {
        return insuredService.getInsuredById(id);
    }

}
