package com.diplomas.service;

import com.diplomas.entity.GraduateWork;
import com.diplomas.repository.GraduateWorkRepository;
import com.diplomas.web.converter.GraduateWorkConverter;
import com.diplomas.web.dto.GraduateWorkDTO;
import com.diplomas.web.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private DropBoxService dropBoxService;

    @Autowired
    private GraduateWorkRepository graduateWorkRepository;

    @Autowired
    private GraduateWorkConverter graduateWorkConverter;

    public static final int SEARCH_BY_SUBJECT = 1;
    public static final int SEARCH_BY_KEYS = 2;
    public static final int SEARCH_BY_TEXT = 3;

    public List<GraduateWorkDTO> searchGraduateWorks(SearchDTO dto) {
        return search(dto)
                .stream()
                .map(graduateWorkConverter::convert)
                .collect(Collectors.toList());
    }

    private List<GraduateWork> search(SearchDTO dto) {
        List<GraduateWork> result = null;
        if (dto.getSearchType() == SEARCH_BY_SUBJECT) {
            result = searchBySubject(dto.getSearchText());
        } else if (dto.getSearchType() == SEARCH_BY_KEYS) {
            result = searchByKeys(dto.getSearchText());
        } else if (dto.getSearchType() == SEARCH_BY_TEXT) {
            result = searchByText(dto.getSearchText());
        }
        return result;
    }

    private List<GraduateWork> searchBySubject(String text) {
        return graduateWorkRepository.findAllBySubject(text);
    }

    private List<GraduateWork> searchByKeys(String searchText) {
        return new ArrayList<>();
    }

    private List<GraduateWork> searchByText(String searchText) {
        return dropBoxService.searchGraduateWorks(searchText);
    }
}
