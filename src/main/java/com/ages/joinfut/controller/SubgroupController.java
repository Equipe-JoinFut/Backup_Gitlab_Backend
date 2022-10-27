package com.ages.joinfut.controller;

import com.ages.joinfut.dto.SubgroupDTO;
import com.ages.joinfut.model.Subgroup;
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

    @Autowired
    private SubgroupRepository subgroupRepository;

    @Autowired
    private SubgroupService subgroupService;

    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os Subgrupos cadastrados")
    public ResponseEntity<List<SubgroupDTO>> readAllSubgroups() {
        List<Subgroup> subgroups = subgroupRepository.findAll();
        List<SubgroupDTO> subgroupsDTO = subgroupService.convertList(subgroups);
        return new ResponseEntity<>(subgroupsDTO, HttpStatus.OK);
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Subgrupo pelo seu ID")
    public ResponseEntity<SubgroupDTO> readSubgroupById(@PathVariable Long id) {
        Optional<Subgroup> subgroup = subgroupRepository.findById(id);
        return subgroup.map(value -> ResponseEntity.ok(new SubgroupDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo Subgrupo")
    @Transactional
    public ResponseEntity<SubgroupDTO> createSubgroup(@RequestBody @Valid SubgroupDTO subgroupDTO, UriComponentsBuilder uriComponentsBuilder){
        Subgroup subgroup = subgroupService.desconvertObject(subgroupDTO);
        subgroupService.save(subgroup);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(subgroup.getId()).toUri();
        return ResponseEntity.created(uri).body(new SubgroupDTO(subgroup));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um Subgrupo")
    @Transactional
    public ResponseEntity<SubgroupDTO> updateSubgroup(@PathVariable Long id, @RequestBody @Valid SubgroupDTO subgroupDTO) {
        Optional<Subgroup> verifyId = subgroupRepository.findById(id);
        if (verifyId.isPresent()) {
            Subgroup updatedSubgroup = subgroupService.desconvertObject(subgroupDTO);
            Subgroup subgroup = subgroupService.update(id, updatedSubgroup, subgroupRepository);
            return ResponseEntity.ok(new SubgroupDTO(subgroup));
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
