package com.ages.joinfut.controller;

import com.ages.joinfut.config.mappers.ClubMapper;
import com.ages.joinfut.dto.ClubDTO;
import com.ages.joinfut.model.Club;
import com.ages.joinfut.repository.ClubRepository;
import com.ages.joinfut.service.ClubService;

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
public class ClubController {

    private static final String URL_PLURAL = "/clubs";
    private static final String URL_SINGULAR = "/club/{id}";

    private ClubRepository clubRepository;
    private ClubService clubService;

    @Autowired
    public ClubController(
            ClubRepository clubRepository,
            ClubService clubService
    ){
        this.clubRepository = clubRepository;
        this.clubService = clubService;
    }

    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os Clubes cadastrados")
    public ResponseEntity<List<ClubDTO>> readAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        List<ClubDTO> clubsDTOs = clubService.convertList(clubs);
        return new ResponseEntity<>(clubsDTOs, HttpStatus.OK);
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Clube pelo seu ID")
    public ResponseEntity<ClubDTO> readClubById(@PathVariable Long id) {
        Optional<Club> club = clubRepository.findById(id);
        return club.map(value -> ResponseEntity.ok(ClubMapper.MAPPER.ClubToClubDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo clube")
    @Transactional
    public ResponseEntity<ClubDTO> createClub(@RequestBody @Valid ClubDTO clubDTO, UriComponentsBuilder uriComponentsBuilder) {
        Club club = clubService.save(clubDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(club.getId()).toUri();
        return ResponseEntity.created(uri).body(ClubMapper.MAPPER.ClubToClubDTO(club));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um clube salvo")
    @Transactional
    public ResponseEntity<ClubDTO> updateClub(@PathVariable Long id, @RequestBody @Valid ClubDTO clubDTO) {
        Optional<Club> verifyId = clubRepository.findById(id);
        if (verifyId.isPresent()) {
            Club club = clubService.update(id, clubDTO, clubRepository);
            return ResponseEntity.ok(ClubMapper.MAPPER.ClubToClubDTO(club));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um clube salvo")
    @Transactional
    public ResponseEntity<Long> deleteClub(@PathVariable Long id) {
            Optional<Club> verifyId = clubRepository.findById(id);
        if (verifyId.isPresent()) {
            clubService.delete(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }
}
