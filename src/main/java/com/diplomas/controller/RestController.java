package com.diplomas.controller;

import java.util.UUID;

import com.diplomas.entity.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.diplomas.service.GraduateWorkService;
import com.diplomas.web.dto.GraduateWorkDTO;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RestController {

    @Autowired
    private GraduateWorkService graduateWorkService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addGraduateWork(@ModelAttribute("graduateWork") GraduateWorkDTO dto,
                                  @RequestParam(value = "file", required = true) MultipartFile file) {
        dto.setFileName(file.getName());
        graduateWorkService.saveGraduateWork(dto);
        return redirect(dto);
    }

    @RequestMapping(value = "/remove/{uuid}", method = RequestMethod.POST)
    public String deleteGraduateWork(@PathVariable("uuid") UUID uuid) {
        return redirect(graduateWorkService.deleteGraduateWork(uuid));
    }

    public String redirect(GraduateWorkDTO dto) {
        Long degreeId = dto.getDegree().getId();
        if (degreeId.equals(Degree.BACHELOR_DEGREE_PK)) {
            return "redirect:/bachelors";
        } else if (degreeId.equals(Degree.SPECIALIST_DEGREE_PK)) {
            return "redirect:/specialists";
        } else if (degreeId.equals(Degree.MASTER_DEGREE_PK)) {
            return "redirect:/masters";
        }
        return "redirect:/bachelors";
    }
}
