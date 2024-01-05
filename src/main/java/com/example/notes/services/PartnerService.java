package com.example.notes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notes.entity.Partner;
import com.example.notes.repos.PartnerRepository;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public List<Partner> getAllPartners(){
        return partnerRepository.findAll();
    }
}

