package com.diplomas.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "graduate_work")
public class GraduateWork extends BaseEntity{
    
    @Type(type = "pg-uuid")
    @Column(name = "uuid", unique = true, nullable = false)
    private UUID uuid = UUID.randomUUID();
    
    @Column(name = "subject", nullable = false)
    private String subject;
    
    @Column(name = "self_href", nullable = false)
    private String selfHref;
    
    @Column(name = "year", nullable = false)
    private String year;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "degree_id", nullable = false)
    private Degree degree;
    
    @ManyToOne
    @JoinColumn(name = "head_work_id", nullable = false)
    private HeadWork headWork;
    
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSelfHref() {
        return selfHref;
    }

    public void setSelfHref(String selfHref) {
        this.selfHref = selfHref;
    }
    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public HeadWork getHeadWork() {
        return headWork;
    }

    public void setHeadWork(HeadWork headWork) {
        this.headWork = headWork;
    }

    @Override
    public String toString() {
	return "GraduateWork [subject=" + subject + ", selfHref=" + selfHref
		+ ", year=" + year + ", student=" + student + ", degree="
		+ degree + ", headWork=" + headWork + "]";
    }
}
