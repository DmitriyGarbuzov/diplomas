package com.diplomas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cathedra")
public class Cathedra extends BaseEntity {
    
    @Column(name = "cathedra_name", nullable = false)
    private String cathedraName;
    
    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;
    
    public String getCathedraName() {
        return cathedraName;
    }

    public void setCathedraName(String cathedraName) {
        this.cathedraName = cathedraName;
    }
    
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

	@Override
	public String toString() {
		return "Cathedra [cathedraName=" + cathedraName + ", faculty=" + faculty + "]";
	}

}
