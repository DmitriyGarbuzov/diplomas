package com.diplomas.web.dto;

public class CathedraDTO {
    
    private Long id;
    
    private String cathedraName;
    
    private FacultyDTO faculty;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCathedraName() {
        return cathedraName;
    }

    public void setCathedraName(String cathedraName) {
        this.cathedraName = cathedraName;
    }
    
    public FacultyDTO getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyDTO faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "CathedraDTO [id=" + id + ", cathedraName=" + cathedraName + ", faculty=" + faculty + "]";
	}
}
