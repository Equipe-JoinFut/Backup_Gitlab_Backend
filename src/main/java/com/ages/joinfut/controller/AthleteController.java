package com.ages.joinfut.controller;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.Enum.State;
import com.ages.joinfut.config.mappers.AthleteMapper;
import com.ages.joinfut.dto.AthleteDTO;
import com.ages.joinfut.model.Adress;
import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.repository.AthleteRepository;
import com.ages.joinfut.service.AthleteService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @PersistenceContext
    private EntityManager entityManager;

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
    public ResponseEntity<List<AthleteDTO>> readAllAthletes(
            @RequestParam(value = "dominantLeg", required = false) DominantLeg dominantLeg,
            @RequestParam(value = "age", required = false) String age,
            @RequestParam(value = "athleteWeight", required = false) String athleteWeight,
            @RequestParam(value = "position", required = false) Position position,
            @RequestParam(value = "state", required = false) State state
    )
    {
        if(dominantLeg != null || age != null || athleteWeight != null || position != null || state != null) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Athlete> criteria = criteriaBuilder.createQuery(Athlete.class);
            Root<Athlete> root = criteria.from(Athlete.class);
            criteria.select(root);

            // Filtro da perna dominante
            if (dominantLeg != null && age == null && athleteWeight == null && position == null && state == null) {
                Predicate predDominantLeg = criteriaBuilder.equal(root.get("dominantLeg"), dominantLeg);
                criteria.where(predDominantLeg);
            }

            // Filtro do estado
            if (dominantLeg == null && age == null && athleteWeight == null && position == null && state != null) {
                Join<Adress, Athlete> adressJoin = root.join("adress");
                Predicate predState = criteriaBuilder.equal(adressJoin.get("state"), state);
                criteria.where(predState);
            }

            // Filtro da Idade
            if (dominantLeg == null && age != null && athleteWeight == null && position == null && state == null) {
                String[] ages = age.split(",");
                int ageMin = Integer.parseInt(ages[0]);
                int ageMax = Integer.parseInt(ages[1]);
                Predicate predAge = criteriaBuilder.between(root.get("age"),ageMin,ageMax);
                criteria.where(predAge);
            }

            // Filtro do Peso
            if (dominantLeg == null && age == null && athleteWeight != null && position == null && state == null) {
                String[] weights = athleteWeight.split(",");
                Double weightMin = Double.parseDouble(weights[0]);
                Double weightMax = Double.parseDouble(weights[1]);
                Predicate predWeight = criteriaBuilder.between(root.get("athleteWeight"),weightMin,weightMax);
                criteria.where(predWeight);
            }

            // Filtro da posição
            if (dominantLeg == null && age == null && athleteWeight == null && position != null && state == null) {
                Predicate predPosition = criteriaBuilder.equal(root.get("position"), position);
                criteria.where(predPosition);
            }

            // Multiplos Filtros
            if (dominantLeg != null && age != null && athleteWeight != null && position != null && state != null){
                String[] weights = athleteWeight.split(",");
                String[] ages = age.split(",");
                Double weightMin = Double.parseDouble(weights[0]);
                int ageMin = Integer.parseInt(ages[0]);
                Double weightMax = Double.parseDouble(weights[1]);
                int ageMax = Integer.parseInt(ages[1]);
                Predicate predWeight = criteriaBuilder.between(root.get("athleteWeight"),weightMin,weightMax);
                Predicate predDominantLeg = criteriaBuilder.equal(root.get("dominantLeg"), dominantLeg);
                Predicate predAge = criteriaBuilder.between(root.get("age"),ageMin,ageMax);
                Predicate predPosition = criteriaBuilder.equal(root.get("position"), position);
                Predicate multipleFilters = criteriaBuilder.or(
                        predDominantLeg,predAge,predWeight,predPosition);
                criteria.where(multipleFilters);
            }

            List<Athlete> athletes = entityManager.createQuery(criteria).getResultList();
            List<AthleteDTO> athletesDTO = athleteService.convertList(athletes);
            return new ResponseEntity<>(athletesDTO, HttpStatus.OK);
        } else {
            List<Athlete> athletes = athleteRepository.findAll();
            List<AthleteDTO> athletesDTO = athleteService.convertList(athletes);
            return new ResponseEntity<>(athletesDTO, HttpStatus.OK);
        }
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Atleta pelo seu ID")
    public ResponseEntity<AthleteDTO> readAthleteById(@PathVariable Long id) {
        Optional<Athlete> athlete = athleteRepository.findById(id);
        return athlete.map(value -> ResponseEntity.ok(AthleteMapper.MAPPER.AthleteToAthleteDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo atleta")
    @Transactional
    public ResponseEntity<AthleteDTO> createAthlete(@RequestBody @Valid AthleteDTO athleteDTO, UriComponentsBuilder uriComponentsBuilder) {
        Athlete athlete = athleteService.save(athleteDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(athlete.getId()).toUri();
        return ResponseEntity.created(uri).body(AthleteMapper.MAPPER.AthleteToAthleteDTO(athlete));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um atleta salvo")
    @Transactional
    public ResponseEntity<AthleteDTO> updateAthlete(@PathVariable Long id, @RequestBody @Valid AthleteDTO athleteDTO) {
        Optional<Athlete> verifyId = athleteRepository.findById(id);
        if (verifyId.isPresent()) {
            Athlete athlete = athleteService.update(id, athleteDTO, athleteRepository);
            return ResponseEntity.ok(AthleteMapper.MAPPER.AthleteToAthleteDTO(athlete));
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

    //Adress State

}


