package com.ages.joinfut.controller;

import com.ages.joinfut.config.EmailSender;
import com.ages.joinfut.config.mappers.AthleteConfirmationMapper;
import com.ages.joinfut.dto.AthleteConfirmationDTO;
import com.ages.joinfut.model.AthleteConfirmation;
import com.ages.joinfut.model.Sieve;
import com.ages.joinfut.repository.AthleteConfirmationRepository;
import com.ages.joinfut.repository.SieveRepository;
import com.ages.joinfut.service.AthleteConfirmationService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/informations")
public class AthleteConfirmationController {

    private static final String URL_PLURAL = "/athletes-confirmations";
    private static final String URL_SINGULAR = "/athlete-confirmation/{id}";
    private final EmailSender emailSender;


    private AthleteConfirmationRepository athleteConfirmationRepository;
    private AthleteConfirmationService athleteConfirmationService;
    private SieveRepository sieveRepository;

    @Autowired
    public AthleteConfirmationController (
            AthleteConfirmationRepository athleteConfirmationRepository,
            AthleteConfirmationService athleteConfirmationService,
            EmailSender emailSender,
            SieveRepository sieveRepository
    ){
        this.athleteConfirmationRepository = athleteConfirmationRepository;
        this.athleteConfirmationService = athleteConfirmationService;
        this.emailSender = emailSender;
        this.sieveRepository = sieveRepository;
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo status")
    @Transactional
    public ResponseEntity<AthleteConfirmationDTO> createAthleteConfirmation(@RequestBody @Valid AthleteConfirmationDTO athleteConfirmationDTO, UriComponentsBuilder uriComponentsBuilder) {
        AthleteConfirmation athleteConfirmation = athleteConfirmationService.save(athleteConfirmationDTO);
        Sieve sieve = sieveRepository.findById(athleteConfirmation.getSieve().getId()).get();
        String data = sieve.getSieveName() + "," + sieve.getLocal() + "," + sieve.getDate() + "," + sieve.getTime() + "," + String.valueOf(athleteConfirmation.getAthleteConfirmedReject());
        this.emailSender.sendEmail("springboottestsjoinfut@gmail.com","Confirmacao de Atleta",data);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(athleteConfirmation.getId()).toUri();
        return ResponseEntity.created(uri).body(AthleteConfirmationMapper.MAPPER.AthleteConfirmationToAthleteConfirmationDTO(athleteConfirmation));
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca um status pelo seu ID")
    public ResponseEntity<AthleteConfirmationDTO> readAthleteConfirmationById(@PathVariable Long id) {
        Optional<AthleteConfirmation> athleteConfirmation = athleteConfirmationRepository.findById(id);
        return athleteConfirmation.map(value -> ResponseEntity.ok(AthleteConfirmationMapper.MAPPER.AthleteConfirmationToAthleteConfirmationDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
