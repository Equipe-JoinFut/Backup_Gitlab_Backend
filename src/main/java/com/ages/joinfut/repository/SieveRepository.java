package com.ages.joinfut.repository;

import com.ages.joinfut.model.Club;
import com.ages.joinfut.model.Sieve;
import com.ages.joinfut.model.Subgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SieveRepository extends JpaRepository<Sieve, Long> {
    Sieve findByIdSieve(Long id);

    List<Sieve> findByClub(Club club);
}
