package com.example.notes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.notes.entity.Partner;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
}
