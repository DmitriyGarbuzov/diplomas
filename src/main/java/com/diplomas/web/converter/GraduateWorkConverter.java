package com.diplomas.web.converter;

import java.util.Optional;

import com.diplomas.controller.MainController;
import com.diplomas.repository.HeadWorkRepository;
import com.diplomas.repository.StudentGroupRepository;
import com.diplomas.repository.StudentRepository;
import com.diplomas.service.CheckService;
import com.diplomas.service.GoogleDriveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diplomas.entity.GraduateWork;
import com.diplomas.repository.GraduateWorkRepository;
import com.diplomas.web.dto.GraduateWorkDTO;
import com.google.common.base.Converter;

@Component
public class GraduateWorkConverter extends Converter<GraduateWork, GraduateWorkDTO> {

    private static final Logger logger = LoggerFactory
            .getLogger(GraduateWorkConverter.class);

    @Autowired
    private CathedraConverter cathedraConverter;

    @Autowired
    private DegreeConverter degreeConverter;

    @Autowired
    private StudentConverter studentConverter;

    @Autowired
    private HeadWorkConverter headWorkConverter;

    @Autowired
    private StudentGroupConverter studentGroupConverter;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private HeadWorkRepository headWorkRepository;

    @Autowired
    private GraduateWorkRepository graduateWorkRepository;

    @Autowired
    private CheckService checkService;

    @Autowired
    private GoogleDriveService googleDriveService;

    @Override
    protected GraduateWork doBackward(GraduateWorkDTO dto) {
        GraduateWork entity = null;
        if (dto.getUuid() != null) {
            entity = graduateWorkRepository.findOneByUuid(dto.getUuid());
            entity = perfomUpdate(dto, entity);
        } else {
            entity = perfomNewEntity(dto);
        }
        return entity;
    }

    @Override
    protected GraduateWorkDTO doForward(GraduateWork entity) {
        GraduateWorkDTO dto = new GraduateWorkDTO();
        dto.setUuid(entity.getUuid());
        dto.setSubject(entity.getSubject());
        dto.setSelfHref(entity.getSelfHref());
        dto.setFileName(entity.getFileName());
        dto.setYear(entity.getYear());
        dto.setHeadWork(Optional.ofNullable(entity.getHeadWork()).map(headWorkConverter::convert).orElse(null));
        dto.setDegree(Optional.ofNullable(entity.getDegree()).map(degreeConverter::convert).orElse(null));
        dto.setCathedra(Optional.ofNullable(entity.getCathedra()).map(cathedraConverter::convert).orElse(null));
        dto.setGroup(Optional.ofNullable(entity.getGroup()).map(studentGroupConverter::convert).orElse(null));
        dto.setStudent(Optional.ofNullable(entity.getStudent()).map(studentConverter::convert).orElse(null));
        return dto;
    }

    private GraduateWork perfomUpdate(GraduateWorkDTO dto, GraduateWork oldEntity) {
        if (!checkService.equals(dto.getSubject(), oldEntity.getSubject())) {
            oldEntity.setSubject(dto.getSubject());
        }
        if (!checkService.equals(dto.getYear(), oldEntity.getYear())) {
            oldEntity.setYear(oldEntity.getYear());
        }
        if (!checkService.equals(dto.getDegree(), oldEntity.getDegree())) {
            oldEntity.setDegree(Optional.ofNullable(dto.getDegree()).map(degreeConverter.reverse()::convert).orElse(null));
        }
        if (!checkService.equals(dto.getCathedra(), oldEntity.getCathedra())) {
            oldEntity.setCathedra(Optional.ofNullable(dto.getCathedra()).map(cathedraConverter.reverse()::convert).orElse(null));
        }
        if (!checkService.equals(dto.getStudent(), oldEntity.getStudent())) {
            try {
                studentRepository.delete(oldEntity.getStudent());
            } catch (Exception e) {
                logger.error("An error has been occured!", e);
            }
            oldEntity.setStudent(Optional.ofNullable(dto.getStudent()).map(studentConverter.reverse()::convert).orElse(null));
        }
        if (!checkService.equals(dto.getGroup(), oldEntity.getGroup())) {
            try {
                studentGroupRepository.delete(oldEntity.getGroup());
            } catch (Exception e) {
                logger.error("An error has been occured!", e);
            }
            oldEntity.setGroup(Optional.ofNullable(dto.getGroup()).map(studentGroupConverter.reverse()::convert).orElse(null));
        }
        if (!checkService.equals(dto.getHeadWork(), oldEntity.getHeadWork())) {
            try {
                headWorkRepository.delete(oldEntity.getHeadWork());
            } catch (Exception e) {
                logger.error("An error has been occured!", e);
            }
            oldEntity.setHeadWork(Optional.ofNullable(dto.getHeadWork()).map(headWorkConverter.reverse()::convert).orElse(null));
        }
        if (!checkService.equals(dto.getFile().getOriginalFilename(),oldEntity.getFileName())) {
            googleDriveService.removeFile(oldEntity.getSelfHref());
            oldEntity.setFileName(dto.getFile().getOriginalFilename());
            oldEntity.setSelfHref(googleDriveService.uploadGraduateWork(dto.getFile()));
        }
        return oldEntity;
    }

    private GraduateWork perfomNewEntity(GraduateWorkDTO dto) {
        GraduateWork entity = new GraduateWork();
        entity.setSubject(dto.getSubject());
        entity.setYear(dto.getYear());
        entity.setDegree(Optional.ofNullable(dto.getDegree()).map(degreeConverter.reverse()::convert).orElse(null));
        entity.setStudent(Optional.ofNullable(dto.getStudent()).map(studentConverter.reverse()::convert).orElse(null));
        entity.setCathedra(Optional.ofNullable(dto.getCathedra()).map(cathedraConverter.reverse()::convert).orElse(null));
        entity.setGroup(Optional.ofNullable(dto.getGroup()).map(studentGroupConverter.reverse()::convert).orElse(null));
        entity.setHeadWork(Optional.ofNullable(dto.getHeadWork()).map(headWorkConverter.reverse()::convert).orElse(null));
        entity.setFileName(dto.getFile().getOriginalFilename());
        entity.setSelfHref(googleDriveService.uploadGraduateWork(dto.getFile()));
        return entity;
    }
}
