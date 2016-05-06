package com.diplomas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplomas.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>{
    
    Optional<Faculty> findOneByFacultyName(String facultyName);
}
