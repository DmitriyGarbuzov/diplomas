package com.diplomas.controller;

import java.util.UUID;

import com.diplomas.entity.Degree;
import com.diplomas.service.CheckService;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.diplomas.service.GraduateWorkService;
import com.diplomas.web.dto.GraduateWorkDTO;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RestController {

    @Autowired
    private GraduateWorkService graduateWorkService;

    @Autowired
    private CheckService checkService;

    public static final String ADD_EDIT_ERROR_MESSAGE = "addEditErrorMess";
    public static final String ADD_EDIT_SUCCESS_MESSAGE = "addEditSuccessMess";
    public static final String REMOVE_SUCCESS_MESSAGE = "removeSuccessMess";
    public static final String REMOVE_ERROR_MESSAGE = "removeErrorMess";

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addGraduateWork(@ModelAttribute("graduateWork") GraduateWorkDTO dto,
                                  @RequestParam(value = "file", required = false) MultipartFile file,
                                  RedirectAttributes redirectAttributes) {
        try {
            ImmutablePair<Boolean, String> checkResult = checkService.checkFile(file);
            if (checkResult.getLeft().equals(Boolean.FALSE)) {
                redirectAttributes.addFlashAttribute(ADD_EDIT_ERROR_MESSAGE, checkResult.getRight());
                return redirectOnError(dto);
            }
            dto.setFile(file);
            graduateWorkService.saveGraduateWork(dto);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(ADD_EDIT_ERROR_MESSAGE, e.getMessage());
            return redirectOnError(dto);
        }
        return redirect(dto, false, redirectAttributes);
    }

    @RequestMapping(value = "/remove/{uuid}", method = RequestMethod.POST)
    public String deleteGraduateWork(@PathVariable("uuid") UUID uuid,
                                     RedirectAttributes redirectAttributes) {
        GraduateWorkDTO dto = null;
        try {
            dto = graduateWorkService.deleteGraduateWork(uuid);
            return redirect(dto, true, redirectAttributes);
        } catch (Exception e) {
            return redirectOnErrorMainPage(dto, e, true, redirectAttributes);
        }
    }

    private String redirect(GraduateWorkDTO dto, boolean delete, RedirectAttributes redirectAttributes) {
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

    private String redirectOnError(GraduateWorkDTO dto) {
        if (dto.getUuid() != null) {
            return "redirect:/edit/" + dto.getUuid();
        } else {
            return "redirect:/add";
        }
    }

    private String redirectOnErrorMainPage(GraduateWorkDTO dto, Exception e, boolean delete, RedirectAttributes redirectAttributes) {
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
