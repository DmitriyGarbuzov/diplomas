package com.diplomas.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diplomas.service.GraduateWorkService;
import com.diplomas.web.dto.GraduateWorkDTO;

@Controller
public class RestController {

	@Autowired
	private GraduateWorkService graduateWorkService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addGraduateWork(@ModelAttribute("graduateWork") GraduateWorkDTO dto) {
		if (dto.getUuid() == null) {
			graduateWorkService.saveGraduateWork(dto);
		} else {
			graduateWorkService.updateGraduateWork(dto);
		}
		return "redirect:/bachelors";
	}

	@RequestMapping("/remove/{uuid}")
	public String deleteGraduateWork(@PathVariable("uuid") UUID uuid) {
		graduateWorkService.deleteGraduateWork(uuid);
		return "redirect:/bachelors";
	}
}
