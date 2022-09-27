package com.ages.joinfut.repository;


import com.ages.joinfut.model.NdaContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NdaContractRepository extends JpaRepository<NdaContract, Long> {

    NdaContract findByidNdaContract(Long id);
}
