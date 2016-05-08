package com.diplomas.web.dto;

import java.util.UUID;

public class StudentDTO {
    
    private UUID uuid;
    
    private String firstName;

    private String patronymic;

    private String surname;
    
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

	@Override
	public String toString() {
		return "StudentDTO [uuid=" + uuid + ", firstName=" + firstName + ", patronymic=" + patronymic + ", surname="
				+ surname + "]";
	}
}
