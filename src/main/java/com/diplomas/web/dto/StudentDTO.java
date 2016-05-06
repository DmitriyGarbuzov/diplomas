package com.diplomas.web.dto;

import java.util.UUID;

public class StudentDTO {
    
    private UUID uuid;
    
    private String firstName;

    private String patronymic;

    private String surname;
    
    private StudentGroupDTO group;
    
    private HeadWorkDTO headWork;
    
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

    public StudentGroupDTO getGroup() {
        return group;
    }

    public void setGroup(StudentGroupDTO group) {
        this.group = group;
    }

    public HeadWorkDTO getHeadWork() {
        return headWork;
    }

    public void setHeadWork(HeadWorkDTO headWork) {
        this.headWork = headWork;
    }

    @Override
    public String toString() {
	return "StudentDTO [firstName=" + firstName + ", patronymic="
		+ patronymic + ", surname=" + surname + ", group=" + group
		+ ", headWork=" + headWork + "]";
    }
    
    
}
