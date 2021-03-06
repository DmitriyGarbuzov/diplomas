package com.diplomas.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.diplomas.entity.GraduateWork;

@Repository
public interface GraduateWorkRepository extends JpaRepository<GraduateWork, Long> {

    List<GraduateWork> findAllBySubject(String subject);

    List<GraduateWork> findAllByDegreeId(Long degreeId);
    
    GraduateWork findOneByUuid(UUID uuid);
    
    @Modifying
    @Transactional
    Long deleteByUuid(UUID uuid);
}
