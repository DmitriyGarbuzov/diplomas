package com.diplomas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "degree")
public class Degree extends BaseEntity {
    
    @Transient
    public final static Long BACHELOR_DEGREE_PK = 1L;
    @Transient
    public final static Long SPECIALIST_DEGREE_PK = 2L;
    @Transient
    public final static Long MASTER_DEGREE_PK = 3L;
    
    
    @Column(name = "degree_key", nullable = false)
    private String degreeKey;

    public String getDegreeKey() {
        return degreeKey;
    }

    public void setDegreeKey(String degreeKey) {
        this.degreeKey = degreeKey;
    }

    @Override
    public String toString() {
	return "Degree [degreeKey=" + degreeKey + "]";
    }
}
