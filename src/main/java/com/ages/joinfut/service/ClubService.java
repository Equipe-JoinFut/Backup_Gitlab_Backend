package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.ClubMapper;
import com.ages.joinfut.dto.ClubDTO;
import com.ages.joinfut.model.Club;
import com.ages.joinfut.repository.AdressRepository;
import com.ages.joinfut.repository.ClubRepository;
import com.ages.joinfut.repository.NdaContractRepository;
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
    private NdaContractRepository ndaContractRepository;

    @Autowired
    private AdressRepository adressRepository;

    private AdressService adressService = new AdressService();
    private NdaContractService ndaContractService = new NdaContractService();

    @Transactional
    public Club save(ClubDTO clubDTO) {
        Club club = ClubMapper.MAPPER.ClubDTOToClub(clubDTO);

        clubRepository.save(club);

        if (club.getAdress() != null) {
            club.getAdress().setClub(club);
            adressService.save(club.getAdress(), adressRepository);
        }

        if (club.getNdaContract() != null) {
            club.getNdaContract().setClub(club);
            ndaContractService.save(club.getNdaContract(), ndaContractRepository);
        }
        return club;
    }

    public void delete( @PathVariable Long id) {
        Optional<Club> clubGetter = clubRepository.findById(id);
        Club club = clubGetter.get();
        
        if (club.getAdress() != null && club.getAdress().getId() != null) {
            adressRepository.delete(club.getAdress());
        }

        if (club.getNdaContract() != null && club.getNdaContract().getId() != null) {
            ndaContractRepository.delete(club.getNdaContract());
        }

        clubRepository.delete(club);
    }

    public Club update(Long id, ClubDTO clubDTO, ClubRepository clubRepository) {
        Club updated = ClubMapper.MAPPER.ClubDTOToClub(clubDTO);
        Club saved = clubRepository.findByidClub(id);

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

        if (updated.getNdaContract() != null && !updated.getNdaContract().equals(saved.getNdaContract())) {
            saved.setNdaContract(ndaContractService.update(updated.getNdaContract().getId(), updated.getNdaContract(), ndaContractRepository));
        }
        
        return saved;
    }

    public List<ClubDTO> convertList(List<Club> clubs) {
        return clubs.stream().map(club -> ClubMapper.MAPPER.ClubToClubDTO(club)).collect(Collectors.toList());
    }
}
