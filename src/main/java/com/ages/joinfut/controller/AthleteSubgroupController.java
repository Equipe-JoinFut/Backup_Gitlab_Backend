package com.ages.joinfut.controller;

    import com.ages.joinfut.dto.AthleteSubgroupDTO;
    import com.ages.joinfut.dto.AtleteDTO;
    import com.ages.joinfut.model.AthleteSubgroup;
    import com.ages.joinfut.model.Atlete;
    import com.ages.joinfut.repository.AthleteSubgroupRepository;
import com.ages.joinfut.service.AthleteSubgroupService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/informations")

public class AthleteSubgroupController {

    private static final String URL_PLURAL = "/athletes_subgroups";
    private static final String URL_SINGULAR = "/athletes_subgroups/{id}";

    @Autowired
    private AthleteSubgroupService athleteSubgroupService;

    @Autowired
    private AthleteSubgroupRepository athleteSubgroupRepository;

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo subgrupo")
    @Transactional
    public ResponseEntity<AthleteSubgroupDTO> createAthleteSubgroup(@RequestBody @Valid AthleteSubgroupDTO athleteSubgroupDTO, UriComponentsBuilder uriComponentsBuilder) {
        AthleteSubgroup athleteSubgroup = athleteSubgroupService.desconvertObject(athleteSubgroupDTO);
        athleteSubgroupService.save(athleteSubgroup);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(athleteSubgroup.getId()).toUri();
        return ResponseEntity.created(uri).body(new AthleteSubgroupDTO(athleteSubgroup));
    }

}
