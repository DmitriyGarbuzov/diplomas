package com.diplomas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty extends BaseEntity {
    
    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
	return "Faculty [facultyName=" + facultyName + "]";
    }
   
}
