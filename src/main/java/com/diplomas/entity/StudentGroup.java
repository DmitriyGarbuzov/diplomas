package com.diplomas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student_group")
public class StudentGroup extends BaseEntity{
    
    @Column(name = "group_name", nullable = false)
    private String groupName;
    
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    @Override
    public String toString() {
	return "Group [groupName=" + groupName + "]";
    }
    
}
