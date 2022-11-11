package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.SieveMapper;
import com.ages.joinfut.dto.SieveDTO;
import com.ages.joinfut.model.Sieve;
import com.ages.joinfut.repository.SieveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SieveService {
    @Autowired
    private SieveRepository sieveRepository;
    private SubgroupService subgroupService = new SubgroupService();
    private ClubService clubService = new ClubService();

    public SieveService(){
    }

    @Transactional
    public Sieve save(SieveDTO sieveDTO){
        Sieve sieve = SieveMapper.MAPPER.SieveDTOToSieve(sieveDTO);

        sieveRepository.save(sieve);

        if(sieve.getSubgroup() != null){

        }

        if(sieve.getClub() != null){

        }

        return sieve;
    }

    public List<SieveDTO> convertList(List<Sieve> sieves) {
        return sieves.stream().map(sieve -> SieveMapper.MAPPER.SieveToSieveDTO(sieve)).collect(Collectors.toList());
    }

    @Transactional
    public void delete(@PathVariable Long id){
        Optional<Sieve> sieveGetter = sieveRepository.findById(id);
        Sieve sieve = sieveGetter.get();
        if(sieve.getSubgroup() != null && sieve.getSubgroup().getId() != null){
            subgroupService.delete(sieve.getSubgroup().getId());
        }
        if(sieve.getClub() != null && sieve.getClub().getId() != null){
            clubService.delete(sieve.getClub().getId());
        }
        sieveRepository.delete(sieve);
    }

    @Transactional
    public Sieve update(Long id, SieveDTO sieveDTO, SieveRepository sieveRepository){
        Sieve updated = SieveMapper.MAPPER.SieveDTOToSieve(sieveDTO);
        Sieve saved = sieveRepository.findByIdSieve(id);
        if (updated.getSieveName() != null && !updated.getSieveName().equals(saved.getSieveName())) {
            saved.setSieveName(updated.getSieveName());
        }
        if(updated.getLocal() != null && !updated.getLocal().equals(saved.getLocal())){
            saved.setLocal(updated.getLocal());
        }
        if (updated.getDate() != null && !updated.getDate().equals(saved.getDate())) {
            saved.setDate(updated.getDate());
        }
        if (updated.getStatus() != null && !updated.getStatus().equals(saved.getStatus())) {
            saved.setStatus(updated.getStatus());
        }
        return saved;
    }
}
