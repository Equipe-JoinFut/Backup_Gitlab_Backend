package com.ages.joinfut.controller;

import com.ages.joinfut.config.mappers.SubgroupMapper;
import com.ages.joinfut.dto.SubgroupDTO;
import com.ages.joinfut.model.Club;
import com.ages.joinfut.model.Subgroup;
import com.ages.joinfut.repository.ClubRepository;
import com.ages.joinfut.repository.SubgroupRepository;
import com.ages.joinfut.service.SubgroupService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/selections")
public class SubgroupController {

    private static final String URL_PLURAL = "/subgroups";

    private static final String URL_SINGULAR = "/subgroup/{id}";

    private SubgroupRepository subgroupRepository;
    private ClubRepository clubRepository;
    private SubgroupService subgroupService;

    @Autowired
    public SubgroupController(
            SubgroupRepository subgroupRepository,
            ClubRepository clubRepository,
            SubgroupService subgroupService
    ){
        this.subgroupRepository = subgroupRepository;
        this.clubRepository = clubRepository;
        this.subgroupService = subgroupService;
    }

    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de Subgrupos pelo Clube")
    public ResponseEntity<List<SubgroupDTO>>readAllSubgroups(@RequestParam(value = "idClub", required = false) Long idClub) {

        if (idClub != null) {
            Club club = clubRepository.findByidClub(idClub);
            List<Subgroup> subgroups = subgroupRepository.findByClub(club);
            List<SubgroupDTO> subgroupsDTO = subgroupService.convertList(subgroups);
            return new ResponseEntity<>(subgroupsDTO, HttpStatus.OK);
        } else {
            List<Subgroup> subgroups = subgroupRepository.findAll();
            List<SubgroupDTO> subgroupsDTO = subgroupService.convertList(subgroups);
            return new ResponseEntity<>(subgroupsDTO, HttpStatus.OK);
        }
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Subgrupo pelo seu ID")
    public ResponseEntity<SubgroupDTO> readSubgroupById(@PathVariable Long id) {
        Optional<Subgroup> subgroup = subgroupRepository.findById(id);
        return subgroup.map(value -> ResponseEntity.ok(SubgroupMapper.MAPPER.SubgroupToSubgroupDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo Subgrupo")
    @Transactional
    public ResponseEntity<SubgroupDTO> createSubgroup(@RequestBody @Valid SubgroupDTO subgroupDTO, UriComponentsBuilder uriComponentsBuilder){
        Subgroup subgroup = subgroupService.save(subgroupDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(subgroup.getId()).toUri();
        return ResponseEntity.created(uri).body(SubgroupMapper.MAPPER.SubgroupToSubgroupDTO(subgroup));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um Subgrupo")
    @Transactional
    public ResponseEntity<SubgroupDTO> updateSubgroup(@PathVariable Long id, @RequestBody @Valid SubgroupDTO subgroupDTO) {
        Optional<Subgroup> verifyId = subgroupRepository.findById(id);
        if (verifyId.isPresent()) {
            Subgroup subgroup = subgroupService.update(id, subgroupDTO, subgroupRepository);
            return ResponseEntity.ok(SubgroupMapper.MAPPER.SubgroupToSubgroupDTO(subgroup));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um subgrupo salvo")
    @Transactional
    public ResponseEntity<Long> deleteSubgroup(@PathVariable Long id) {
        Optional<Subgroup> verifyId = subgroupRepository.findById(id);
        if (verifyId.isPresent()) {
            subgroupService.delete(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }


}
