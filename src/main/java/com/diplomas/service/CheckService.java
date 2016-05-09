package com.diplomas.service;

import com.diplomas.entity.*;
import com.diplomas.web.dto.*;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.BooleanComparator;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class CheckService {

    public static final String PDF_EXTENSION = "pdf";
    public static final String DOC_EXTENSION = "doc";

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

    public ImmutablePair<Boolean, String> checkFile(MultipartFile file) {
        if (!file.isEmpty()) {
            if(file.getOriginalFilename().contains(DOC_EXTENSION)
                    || file.getOriginalFilename().contains(PDF_EXTENSION)) {
                return new ImmutablePair<>(true,"");
            }
            return new ImmutablePair<>(false,"Неправильний формат файлу, доступні формати це 'doc' або 'pdf'!");
        } else {
            return new ImmutablePair<>(false, "Файл дипломної роботи обов'язковий!");
        }
    }
}
