package com.ages.joinfut.controller;

import com.ages.joinfut.dto.AtleteDTO;
import com.ages.joinfut.dto.SubgroupDTO;
import com.ages.joinfut.model.Subgroup;
import com.ages.joinfut.repository.SubgroupRepository;
import com.ages.joinfut.service.AtleteService;
import com.ages.joinfut.service.SubgroupService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/selections")
public class SubgroupController {

    private static final String URL_PLURAL = "/subgroups";

    private static final String URL_SINGULAR = "/subgroup/{id}";

    @Autowired
    private SubgroupRepository subgroupRepository;
    @Autowired
    private SubgroupService subgroupService;

    @Autowired
    private AtleteService atleteService;

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo Atleta")
    @Transactional
    public ResponseEntity<SubgroupDTO> createSubgroup(@RequestBody @Valid SubgroupDTO subgroupDTO, UriComponentsBuilder uriComponentsBuilder){
        Subgroup subgroup = subgroupService.desconvertObject(subgroupDTO);
        subgroupService.save(subgroup);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(subgroup.getId()).toUri();
        return ResponseEntity.created(uri).body(new SubgroupDTO(subgroup));
    }


}
