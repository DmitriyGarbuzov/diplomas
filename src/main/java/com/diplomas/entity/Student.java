package com.diplomas.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "student")
public class Student extends BaseEntity {
    
    @Type(type = "pg-uuid")
    @Column(name = "uuid", unique = true, nullable = false)
    private UUID uuid = UUID.randomUUID();
    
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "surname", nullable = false)
    private String surname;
    
    @ManyToOne
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup group;
    
    @ManyToOne
    @JoinColumn(name = "head_work_id", nullable = false)
    private HeadWork headWork;
    
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getPatronymic() {
	return patronymic;
    }

    public void setPatronymic(String patronymic) {
	this.patronymic = patronymic;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public HeadWork getHeadWork() {
        return headWork;
    }

    public void setHeadWork(HeadWork headWork) {
        this.headWork = headWork;
    }
}
