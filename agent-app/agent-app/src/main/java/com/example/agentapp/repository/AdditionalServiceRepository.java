package com.example.agentapp.repository;

import com.example.agentapp.domain.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Long> {

    AdditionalService findByNameIgnoreCase(String name);

    List<AdditionalService> findByNameInIgnoreCase(List<String> names);
}
