package com.ages.joinfut.controller;

import com.ages.joinfut.config.mappers.SieveMapper;
import com.ages.joinfut.dto.SieveDTO;
import com.ages.joinfut.model.Sieve;
import com.ages.joinfut.repository.SieveRepository;
import com.ages.joinfut.service.SieveService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/personas")
public class SieveController {
    private static final String URL_PLURAL = "/sieves";

    private static final String URL_SINGULAR = "/sieve/{id}";
    private SieveRepository sieveRepository;
    private SieveService sieveService;

    public SieveController(SieveRepository sieveRepository, SieveService sieveService){
        this.sieveRepository = sieveRepository;
        this.sieveService = sieveService;
    }

    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos as Peneiras cadastradas")
    public ResponseEntity<List<SieveDTO>> readAllSieves() {
        List<Sieve> sieves = sieveRepository.findAll();
        List<SieveDTO> sievesDTO = sieveService.convertList(sieves);
        return new ResponseEntity<>(sievesDTO, HttpStatus.OK);
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de uma Peneira pelo seu ID")
    public ResponseEntity<SieveDTO> readSieveById(@PathVariable Long id) {
        Optional<Sieve> sieve = sieveRepository.findById(id);
        return sieve.map(value -> ResponseEntity.ok(SieveMapper.MAPPER.SieveToSieveDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria uma nova peneira")
    @Transactional
    public ResponseEntity<SieveDTO> createSieve(@RequestBody @Valid SieveDTO sieveDTO, UriComponentsBuilder uriComponentsBuilder) {
        Sieve sieve = sieveService.save(sieveDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(sieve.getId()).toUri();
        return ResponseEntity.created(uri).body(SieveMapper.MAPPER.SieveToSieveDTO(sieve));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza uma peneira salva")
    @Transactional
    public ResponseEntity<SieveDTO> updateSieve(@PathVariable Long id, @RequestBody @Valid SieveDTO sieveDTO) {
        Optional<Sieve> verifyId = sieveRepository.findById(id);
        if (verifyId.isPresent()) {
            Sieve sieve = sieveService.update(id, sieveDTO, sieveRepository);
            return ResponseEntity.ok(SieveMapper.MAPPER.SieveToSieveDTO(sieve));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove uma peneira salva")
    @Transactional
    public ResponseEntity<Long> deleteSieve(@PathVariable Long id) {
        Optional<Sieve> verifyId = sieveRepository.findById(id);
        if (verifyId.isPresent()) {
            sieveService.delete(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }
}
