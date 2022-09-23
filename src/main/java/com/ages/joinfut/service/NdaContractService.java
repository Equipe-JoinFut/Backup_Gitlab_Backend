package com.ages.joinfut.service;

import com.ages.joinfut.dto.NdaContractDTO;
import com.ages.joinfut.model.NdaContract;
import com.ages.joinfut.repository.NdaContractRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

public class NdaContractService {

    public NdaContractService() {}

    @Transactional
    public void save(NdaContract ndaContract, NdaContractRepository ndaContractRepository) { ndaContractRepository.save(ndaContract); }

    public NdaContractDTO convertObject(NdaContract ndaContract) { return new NdaContractDTO(ndaContract); }

    public List<NdaContract> desconvertList(List<NdaContractDTO> ndaContractsDTOS) {
        return ndaContractsDTOS.stream().map(NdaContract::new).collect(Collectors.toList());
    }

    public NdaContract desconvertObject(NdaContractDTO ndaContractDTO){ return new NdaContract(ndaContractDTO); }

    public NdaContract update(Long id, NdaContract updated, NdaContractRepository ndaContractRepository) {
        NdaContract saved = ndaContractRepository.findByNdaContract(id);
        if (updated.getInfoNda() != null && !updated.getInfoNda().equals(saved.getInfoNda())) {
            saved.setInfoNda(updated.getInfoNda());
        }
        if (updated.getStatusNda() != null && !updated.getStatusNda().equals(saved.getStatusNda())) {
            saved.setStatusNda(updated.getStatusNda());
        }
        ndaContractRepository.save(saved);
        return saved;
    }
}
