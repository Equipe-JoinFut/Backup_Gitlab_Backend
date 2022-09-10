package com.ages.joinfut.controller;

import com.ages.joinfut.dto.AtleteDTO;
import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.repository.AtleteRepository;
import com.ages.joinfut.service.AtleteService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class AtleteController {

    private static final String URL_PLURAL = "/atletes";
    private static final String URL_SINGULAR = "/atlete/{id}";

    @Autowired
    private AtleteRepository atleteRepository;

    @Autowired
    private AtleteService atleteService;

    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os Atletas cadastrados")
    public ResponseEntity<List<AtleteDTO>> readAllAtletes() {
        List<Atlete> atletes = atleteRepository.findAll();
        List<AtleteDTO> atletesDTO = atleteService.convertList(atletes);
        return new ResponseEntity<>(atletesDTO, HttpStatus.OK);
    }
}
