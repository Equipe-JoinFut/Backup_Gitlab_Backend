package com.ages.joinfut.repository;

import com.ages.joinfut.model.Sieve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SieveRepository extends JpaRepository<Sieve, Long> {
    Sieve findByIdSieve(Long id);
}
