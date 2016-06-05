package com.diplomas.controller;

import java.util.Map;
import java.util.UUID;

import com.diplomas.web.dto.SearchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diplomas.entity.Degree;
import com.diplomas.service.CathedraService;
import com.diplomas.service.DegreeService;
import com.diplomas.service.FacultyService;
import com.diplomas.service.GraduateWorkService;
import com.diplomas.web.dto.GraduateWorkDTO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private static final Logger logger = LoggerFactory
            .getLogger(MainController.class);

    @Autowired
    private GraduateWorkService graduateWorkService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private CathedraService cathedraService;

    @Autowired
    private DegreeService degreeService;

    @RequestMapping(value="/" , method= RequestMethod.GET)
    public String home() {
        return "redirect:/bachelors";
    }

    @RequestMapping(value = "/bachelors", method = RequestMethod.GET)
    public String bachelorsGraduateWorkList(Model model) {
        return graduateWorkList(model, Degree.BACHELOR_DEGREE_PK);
    }

    @RequestMapping(value = {  "/403**" }, method = RequestMethod.GET)
	public ModelAndView error() {
 
		ModelAndView model = new ModelAndView();
		
		model.setViewName("403");
		return model;
 
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
        model.addAttribute("graduateWork", new GraduateWorkDTO());
        model.addAttribute("faculties", facultyService.getAllFaculties());
        model.addAttribute("cathedras", cathedraService.getAllCathedras());
        model.addAttribute("degress", degreeService.getAllDegrees());
        return "graduatework";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchGraduateWork(Model model) {
        if (((BindingAwareModelMap) model).get("searchDto") == null) {
            model.addAttribute("searchDto", new SearchDTO());
        }
        return "searchwork";
    }

    @RequestMapping(value = "/edit/{uuid}", method = RequestMethod.GET)
    public String editGraduateWork(@PathVariable("uuid") UUID uuid, Model model) {
        GraduateWorkDTO dto = graduateWorkService.getGraduateWork(uuid);
        model.addAttribute("graduateWork", dto);
        model.addAttribute("faculties", facultyService.getAllFaculties());
        model.addAttribute("cathedras", cathedraService.getAllCathedras());
        model.addAttribute("degress", degreeService.getAllDegrees());
        model.addAttribute("selectedDegree", dto.getDegree());
        model.addAttribute("selectedCathedra", dto.getCathedra());
        return "graduatework";
    }

    private String graduateWorkList(Model model, Long degreeId) {
        logger.debug("Get all graduate works with degree_id = {}", degreeId);
        model.addAttribute("graduateWorkList", graduateWorkService.getGraduateWorksByDegreePK(degreeId));
        return "graduateworks";
    }
}
