package com.ages.joinfut.repository;

import com.ages.joinfut.Enum.DominantLeg;
import com.ages.joinfut.Enum.Position;
import com.ages.joinfut.Enum.State;
import com.ages.joinfut.model.Adress;
import com.ages.joinfut.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Athlete findByidAthlete(Long id);

    List<Athlete> findByathleteHeight(Double athleteHeight);
//    List<Athlete> findWithFilters(Objects...list) {
//        for( Object object : list) {
//            if object ! = null
//                query += where object ...
//        }
//    }
    List<Athlete> findByage(Integer age);

    List<Athlete> findByathleteWeight(Double athleteWeight);

    List<Athlete> findBydominantLeg(DominantLeg dominantLeg);

    List<Athlete> findByposition(Position position);

    List<Adress> findBystate(State state);

}
