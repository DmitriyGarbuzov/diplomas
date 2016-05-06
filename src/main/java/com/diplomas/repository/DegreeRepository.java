package com.diplomas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplomas.entity.Degree;
@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long>{

}
