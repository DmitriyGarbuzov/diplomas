package com.diplomas.web.dto;

public class FacultyDTO {
    
    private Long id;
    
    private String facultyName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
	return facultyName;
    }

    public void setFacultyName(String facultyName) {
	this.facultyName = facultyName;
    }

    @Override
    public String toString() {
	return "FacultyDTO [id=" + id + ", facultyName=" + facultyName + "]";
    }
}
