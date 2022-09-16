package com.ages.joinfut.controller;

import com.ages.joinfut.dto.AtleteDTO;
import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.repository.AtleteRepository;
import com.ages.joinfut.service.AtleteService;
import io.swagger.annotations.ApiModelProperty;
import org.modelmapper.ModelMapper;
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
@RequestMapping(value = "/personas")
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

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Atleta pelo seu ID")
    public ResponseEntity<AtleteDTO> readAtleteById(@PathVariable Long id) {
        Optional<Atlete> atlete = atleteRepository.findById(id);
        return atlete.map(value -> ResponseEntity.ok(new AtleteDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo atleta")
    @Transactional
    public ResponseEntity<AtleteDTO> createAtlete(@RequestBody @Valid AtleteDTO atleteDTO, UriComponentsBuilder uriComponentsBuilder) {
        Atlete atlete = atleteService.desconvertObject(atleteDTO);
        atleteService.save(atlete);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(atlete.getId()).toUri();
        return ResponseEntity.created(uri).body(new AtleteDTO(atlete));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um atleta salvo")
    @Transactional
    public ResponseEntity<AtleteDTO> updateAtlete(@PathVariable Long id, @RequestBody @Valid AtleteDTO atleteDTO) {
        Optional<Atlete> verifyId = atleteRepository.findById(id);
        if (verifyId.isPresent()) {
            Atlete updatedAtlete = atleteService.desconvertObject(atleteDTO);
            Atlete atlete = atleteService.updateObject(id, updatedAtlete, atleteRepository);
            return ResponseEntity.ok(new AtleteDTO(atlete));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um atleta salvo")
    @Transactional
    public ResponseEntity<Long> deleteAtlete(@PathVariable Long id) {
        Optional<Atlete> verifyId = atleteRepository.findById(id);
        if (verifyId.isPresent()) {
            atleteRepository.deleteById(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }
}
