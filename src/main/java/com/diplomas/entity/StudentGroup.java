package com.diplomas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_group")
public class StudentGroup extends BaseEntity{
    
    @Column(name = "group_name", nullable = false)
    private String groupName;
    
    @ManyToOne
    @JoinColumn(name = "cathedra_id", nullable = false)
    private Cathedra cathedra; 
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public Cathedra getCathedra() {
        return cathedra;
    }

    public void setCathedra(Cathedra cathedra) {
        this.cathedra = cathedra;
    }

    @Override
    public String toString() {
	return "Group [groupName=" + groupName + "]";
    }
    
}
