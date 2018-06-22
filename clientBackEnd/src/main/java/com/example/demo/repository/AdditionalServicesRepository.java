package com.example.demo.repository;

import com.example.demo.model.AdditionalServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalServicesRepository extends JpaRepository<AdditionalServices,Long> {

    AdditionalServices getById(Long id);

    AdditionalServices getByName(String name);
}