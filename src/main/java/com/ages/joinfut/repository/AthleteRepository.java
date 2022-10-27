package com.ages.joinfut.repository;

import com.ages.joinfut.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Athlete findByidAthlete(Long id);
}
