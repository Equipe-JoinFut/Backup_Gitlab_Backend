package com.ages.joinfut.service;

import com.ages.joinfut.dto.ClubDTO;
import com.ages.joinfut.model.Club;
import com.ages.joinfut.repository.AdressRepository;
import com.ages.joinfut.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClubService {
    
    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private AdressRepository adressRepository;

    private AdressService adressService = new AdressService();

    @Transactional
    public void save(Club club) {
        clubRepository.save(club);

        if (club.getAdress() != null) {
            club.getAdress().setClub(club);
            adressService.save(club.getAdress(), adressRepository);
        }
    }

    public void delete( @PathVariable Long id) {
        Optional<Club> clubGetter = clubRepository.findById(id);
        Club club = clubGetter.get();
        
        if (club.getAdress() != null && club.getAdress().getId() != null) {
            adressRepository.delete(club.getAdress());
        }

        clubRepository.delete(club);
    }

    public Club update(Long id, Club updated, ClubRepository clubRepository) {
        Club saved = clubRepository.findByidClub(id);

        if (updated.getClub() != null && !updated.getClub().equals(saved.getClub())) {
            saved.setClub(updated.getClub());
        }
        
        if (updated.getCorporateName() != null && !updated.getCorporateName().equals(saved.getCorporateName())) {
            saved.setCorporateName(updated.getCorporateName());
        }
        
        if (updated.getFantasyName() != null && !updated.getFantasyName().equals(saved.getFantasyName())) {
            saved.setFantasyName(updated.getFantasyName());
        }
        
        if (updated.getCnpj() != null && !updated.getCnpj().equals(saved.getCnpj())) {
            saved.setCnpj(updated.getCnpj());
        }
        
        if (updated.getAdress() != null && !updated.getAdress().equals(saved.getAdress())) {
            saved.setAdress(updated.getAdress());
        }
        
        return saved;
    }

    public List<ClubDTO> convertList(List<Club> clubs) {
        return clubs.stream().map(ClubDTO::new).collect(Collectors.toList());
    }

    public ClubDTO DTODataConverter(Club club) {
        ClubDTO clubDTO = new ClubDTO();
        clubDTO.setIdClub(club.getIdClub());
        clubDTO.setClub(club.getClub());
        clubDTO.setCorporateName(club.getCorporateName());
        clubDTO.setFantasyName(club.getFantasyName());
        clubDTO.setCnpj(club.getCnpj());

        if (club.getAdress() != null) {
            clubDTO.setAdress(adressService.convertObjet(club.getAdress()));
        }
        
        return clubDTO;
    }

    public Club EntityDataConverter(ClubDTO clubDTO) {
        Club club = new Club();
        club.setIdClub(club.getIdClub());
        club.setClub(club.getClub());
        club.setCorporateName(club.getCorporateName());
        club.setFantasyName(club.getFantasyName());
        club.setCnpj(club.getCnpj());
       
        if (clubDTO.getAdress() != null) {
            club.setAdress(adressService.desconvertObject(clubDTO.getAdress()));
        }
        
        return club;
    }

    public ClubDTO convertObject(Club club){
        return new ClubDTO(club);
    }


    public List<Club> desconvertList(List<ClubDTO> clubDTOS) {
        return clubDTOS.stream().map(Club::new).collect(Collectors.toList());
    }

    public Club desconvertObject(ClubDTO clubDTO) {
        return new Club(clubDTO);
    }
}
