package com.ages.joinfut.repository;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Athlete findByidAthlete(Long id);

    List<Athlete> findByDominantLegOrAthleteHeightOrAgeOrAthleteWeightOrPosition(DominantLeg dominantLeg, Double athleteHeight, Integer age, Double athleteWeight, Position position);

}
