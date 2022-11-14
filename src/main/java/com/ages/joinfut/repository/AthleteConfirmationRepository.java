package com.ages.joinfut.repository;

import com.ages.joinfut.model.AthleteConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteConfirmationRepository extends JpaRepository<AthleteConfirmation, Long> {

    AthleteConfirmation findByidAthleteConfirmation(Long id);

}
