package com.diplomas.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diplomas.entity.HeadWork;

public interface HeadWorkRepository extends JpaRepository<HeadWork, Long>{
    
    Optional<HeadWork> findOneByUuid(UUID uuid);
}
