package com.ages.joinfut.controller;

import com.ages.joinfut.config.mappers.AthleteMapper;
import com.ages.joinfut.dto.AthleteDTO;
import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.repository.AthleteRepository;
import com.ages.joinfut.service.AthleteService;
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
@RequestMapping(value = "/personas")
public class AthleteController {

    private static final String URL_PLURAL = "/athletes";
    private static final String URL_SINGULAR = "/athlete/{id}";

    private AthleteRepository athleteRepository;
    private AthleteService athleteService;
    private AthleteMapper athleteMapper;

    @Autowired
    public AthleteController(
            AthleteRepository athleteRepository,
            AthleteService athleteService
    ){
        this.athleteRepository = athleteRepository;
        this.athleteService = athleteService;
    }


    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os Atletas cadastrados")
    public ResponseEntity<List<AthleteDTO>> readAllAthletes() {
        List<Athlete> athletes = athleteRepository.findAll();
        List<AthleteDTO> athletesDTO = athleteService.convertList(athletes);
        return new ResponseEntity<>(athletesDTO, HttpStatus.OK);
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Atleta pelo seu ID")
    public ResponseEntity<AthleteDTO> readAthleteById(@PathVariable Long id) {
        Optional<Athlete> athlete = athleteRepository.findById(id);
        return athlete.map(value -> ResponseEntity.ok(athleteMapper.AthleteToAthleteDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo atleta")
    @Transactional
    public ResponseEntity<AthleteDTO> createAthlete(@RequestBody @Valid AthleteDTO athleteDTO, UriComponentsBuilder uriComponentsBuilder) {
        Athlete athlete = athleteService.save(athleteDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(athlete.getId()).toUri();
        return ResponseEntity.created(uri).body(athleteMapper.AthleteToAthleteDTO(athlete));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um atleta salvo")
    @Transactional
    public ResponseEntity<AthleteDTO> updateAthlete(@PathVariable Long id, @RequestBody @Valid AthleteDTO athleteDTO) {
        Optional<Athlete> verifyId = athleteRepository.findById(id);
        if (verifyId.isPresent()) {
            Athlete athlete = athleteService.update(id, athleteDTO, athleteRepository);
            return ResponseEntity.ok(athleteMapper.AthleteToAthleteDTO(athlete));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um atleta salvo")
    @Transactional
    public ResponseEntity<Long> deleteAthlete(@PathVariable Long id) {
        Optional<Athlete> verifyId = athleteRepository.findById(id);
        if (verifyId.isPresent()) {
            athleteService.delete(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }
}
