package com.diplomas.controller;

import java.util.UUID;

import com.diplomas.entity.Degree;
import com.diplomas.service.CheckService;
import com.diplomas.service.RedirectService;
import com.diplomas.service.SearchService;
import com.diplomas.web.dto.SearchDTO;
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

    @Autowired
    private SearchService searchService;

    @Autowired
    private RedirectService redirectService;

    public static final String ADD_EDIT_ERROR_MESSAGE = "addEditErrorMess";

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addGraduateWork(@ModelAttribute("graduateWork") GraduateWorkDTO dto,
                                  @RequestParam(value = "file", required = false) MultipartFile file,
                                  RedirectAttributes redirectAttributes) {
        try {
            ImmutablePair<Boolean, String> checkResult = checkService.checkFile(file);
            if (checkResult.getLeft().equals(Boolean.FALSE)) {
                redirectAttributes.addFlashAttribute(ADD_EDIT_ERROR_MESSAGE, checkResult.getRight());
                return redirectService.redirectOnError(dto);
            }
            dto.setFile(file);
            graduateWorkService.saveGraduateWork(dto);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(ADD_EDIT_ERROR_MESSAGE, e.getMessage());
            return redirectService.redirectOnError(dto);
        }
        return redirectService.redirect(dto, false, redirectAttributes);
    }

    @RequestMapping(value = "/remove/{uuid}", method = RequestMethod.POST)
    public String deleteGraduateWork(@PathVariable("uuid") UUID uuid,
                                     RedirectAttributes redirectAttributes) {
        GraduateWorkDTO dto = null;
        try {
            dto = graduateWorkService.deleteGraduateWork(uuid);
            return redirectService.redirect(dto, true, redirectAttributes);
        } catch (Exception e) {
            return redirectService.redirectOnErrorMainPage(dto, e, true, redirectAttributes);
        }
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute("searchDto") SearchDTO dto,
                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("searchDto",dto);
        redirectAttributes.addFlashAttribute("graduateWorkList", searchService.searchGraduateWorks(dto));
        return "redirect:/search";
    }
}
