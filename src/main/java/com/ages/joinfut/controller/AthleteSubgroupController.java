package com.ages.joinfut.controller;

import com.ages.joinfut.config.mappers.AthleteSubgroupMapper;
import com.ages.joinfut.dto.AthleteSubgroupDTO;
import com.ages.joinfut.model.AthleteSubgroup;
import com.ages.joinfut.repository.AthleteSubgroupRepository;
import com.ages.joinfut.service.AthleteSubgroupService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/informations")

public class AthleteSubgroupController {

    private static final String URL_PLURAL = "/athletes-subgroups";
    private static final String URL_SINGULAR = "/athletes-subgroups/{id}";

    private AthleteSubgroupService athleteSubgroupService;
    private AthleteSubgroupRepository athleteSubgroupRepository;

    @Autowired
    public AthleteSubgroupController(
            AthleteSubgroupRepository athleteSubgroupRepository,
            AthleteSubgroupService athleteSubgroupService
    ) {
        this.athleteSubgroupRepository = athleteSubgroupRepository;
        this.athleteSubgroupService = athleteSubgroupService;
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo atleta no subgrupo")
    @Transactional
    public ResponseEntity<AthleteSubgroupDTO> createAthleteSubgroup(@RequestBody @Valid AthleteSubgroupDTO athleteSubgroupDTO, UriComponentsBuilder uriComponentsBuilder) {
        AthleteSubgroup athleteSubgroup = athleteSubgroupService.save(athleteSubgroupDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(athleteSubgroup.getId()).toUri();
        return ResponseEntity.created(uri).body(AthleteSubgroupMapper.MAPPER.AthleteSubgroupToAthleteSubgroupDTO(athleteSubgroup));
    }
}
