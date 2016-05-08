package com.diplomas.service;

import com.diplomas.entity.*;
import com.diplomas.web.dto.*;
import org.springframework.stereotype.Service;

@Service
public class CheckService {

    public boolean equals(StudentDTO dto, Student entity) {
        return dto.getFirstName().equals(entity.getFirstName())
                && dto.getPatronymic().equals(entity.getPatronymic())
                && dto.getSurname().equals(entity.getSurname());
    }

    public boolean equals(DegreeDTO dto, Degree entity) {
        return dto.getId().equals(entity.getId());
    }

    public boolean equals(CathedraDTO dto, Cathedra entity) {
        return dto.getId().equals(entity.getId());
    }

    public boolean equals(StudentGroupDTO dto, StudentGroup entity) {
        return dto.getGroupName().equals(entity.getGroupName());
    }

    public boolean equals(HeadWorkDTO dto, HeadWork entity) {
        return dto.getFirstName().equals(entity.getFirstName())
                && dto.getPatronymic().equals(entity.getPatronymic())
                && dto.getSurname().equals(entity.getSurname());
    }

    public boolean equals(String dto, String entity) {
        return dto.equals(entity);
    }
}
