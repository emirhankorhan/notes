package com.example.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.notes.services.PartnerService;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping
    @CrossOrigin(origins = "https://toddo.co", methods = {RequestMethod.GET}, allowCredentials = "true")
    public ResponseEntity<?> getAllPartners() {
        var partners = partnerService.getAllPartners();
        return new ResponseEntity<>(partners, HttpStatus.OK);
    }
}
