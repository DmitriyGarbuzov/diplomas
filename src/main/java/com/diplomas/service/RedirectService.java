package com.diplomas.service;

import com.diplomas.entity.Degree;
import com.diplomas.web.dto.GraduateWorkDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class RedirectService {

    public static final String ADD_EDIT_SUCCESS_MESSAGE = "addEditSuccessMess";
    public static final String REMOVE_SUCCESS_MESSAGE = "removeSuccessMess";
    public static final String REMOVE_ERROR_MESSAGE = "removeErrorMess";

    public String redirect(GraduateWorkDTO dto, boolean delete, RedirectAttributes redirectAttributes) {
        Long degreeId = dto.getDegree().getId();
        if (degreeId.equals(Degree.BACHELOR_DEGREE_PK)) {
            if (delete) {
                redirectAttributes.addFlashAttribute(REMOVE_SUCCESS_MESSAGE, "Дипломна работа виделена");
            } else {
                redirectAttributes.addFlashAttribute(ADD_EDIT_SUCCESS_MESSAGE, "Дипломна работа створена");
            }
            return "redirect:/bachelors";
        } else if (degreeId.equals(Degree.SPECIALIST_DEGREE_PK)) {
            if (delete) {
                redirectAttributes.addFlashAttribute(REMOVE_SUCCESS_MESSAGE, "Дипломна работа виделена");
            } else {
                redirectAttributes.addFlashAttribute(ADD_EDIT_SUCCESS_MESSAGE, "Дипломна работа створена");
            }
            return "redirect:/specialists";
        } else if (degreeId.equals(Degree.MASTER_DEGREE_PK)) {
            if (delete) {
                redirectAttributes.addFlashAttribute(REMOVE_SUCCESS_MESSAGE, "Дипломна работа виделена");
            } else {
                redirectAttributes.addFlashAttribute(ADD_EDIT_SUCCESS_MESSAGE, "Дипломна работа створена");
            }
            return "redirect:/masters";
        }
        return "redirect:/bachelors";
    }

    public String redirectOnError(GraduateWorkDTO dto) {
        if (dto.getUuid() != null) {
            return "redirect:/edit/" + dto.getUuid();
        } else {
            return "redirect:/add";
        }
    }

    public String redirectOnErrorMainPage(GraduateWorkDTO dto, Exception e, boolean delete, RedirectAttributes redirectAttributes) {
        if (dto != null) {
            Long degreeId = dto.getDegree().getId();
            if (degreeId.equals(Degree.BACHELOR_DEGREE_PK)) {
                return "redirect:/bachelors";
            } else if (degreeId.equals(Degree.SPECIALIST_DEGREE_PK)) {
                return "redirect:/specialists";
            } else if (degreeId.equals(Degree.MASTER_DEGREE_PK)) {
                return "redirect:/masters";
            }
        }
        if (delete) {
            redirectAttributes.addFlashAttribute(REMOVE_ERROR_MESSAGE, e.getMessage());
        } else {
            redirectAttributes.addFlashAttribute(REMOVE_ERROR_MESSAGE, e.getMessage());
        }
        return "redirect:/bachelors";
    }
}
