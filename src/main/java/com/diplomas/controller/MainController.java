package com.diplomas.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diplomas.Application;
import com.diplomas.entity.Degree;
import com.diplomas.service.GraduateWorkService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(Application.class);
	
	@Autowired
	private GraduateWorkService graduateWorkService;
	
	@RequestMapping(value = "/bachelors", method = RequestMethod.GET)
	public String bachelorsGraduateWorkList(Model model) {
		return graduateWorkList(model, Degree.BACHELOR_DEGREE_PK);
	}

	@RequestMapping(value = "/specialists", method = RequestMethod.GET)
	public String specialistsGraduateWorkList(Model model) {
		return graduateWorkList(model, Degree.SPECIALIST_DEGREE_PK);
	}

	@RequestMapping(value = "/masters", method = RequestMethod.GET)
	public String mastersGraduateWorkList(Model model) {
		return graduateWorkList(model, Degree.MASTER_DEGREE_PK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addGraduateWork(Model model) {
		return "graduatework";
	}
	
	@RequestMapping(value ="/search", method = RequestMethod.GET)
	public String searchGraduateWork(Model model) {
		return "searchwork";
	}

	@RequestMapping(value = "/edit/{uuid}", method = RequestMethod.GET)
	public String editGraduateWork(@PathVariable("uuid") UUID uuid, Model model) {
		model.addAttribute("graduateWork", graduateWorkService.getGraduateWork(uuid));
		return "graduatework";
	}

	private String graduateWorkList(Model model, Long degreeId) {
		logger.debug("Get all graduate works with degree_id = {}",degreeId);
		model.addAttribute("graduateWorkList", graduateWorkService.getGraduateWorksByDegreePK(degreeId));
		return "graduateworks";
	}
}
