package com.ages.joinfut.service;

import com.ages.joinfut.model.NdaContract;
import com.ages.joinfut.repository.NdaContractRepository;


import javax.transaction.Transactional;

public class NdaContractService {

    public NdaContractService() {}

    @Transactional
    public void save(NdaContract ndaContract, NdaContractRepository ndaContractRepository) { ndaContractRepository.save(ndaContract); }

    public NdaContract update(Long id, NdaContract updated, NdaContractRepository ndaContractRepository) {
        NdaContract saved = ndaContractRepository.findByidNdaContract(id);
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
