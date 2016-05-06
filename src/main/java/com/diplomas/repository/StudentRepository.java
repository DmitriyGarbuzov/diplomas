package com.diplomas.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplomas.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
    Optional<Student> findOneByUuid(UUID uuid);
}
