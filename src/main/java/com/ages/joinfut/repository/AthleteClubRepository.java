package com.ages.joinfut.repository;

import com.ages.joinfut.model.AthleteClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteClubRepository extends JpaRepository<AthleteClub, Long> {
    AthleteClub findByidAthleteClub(Long id);
}
