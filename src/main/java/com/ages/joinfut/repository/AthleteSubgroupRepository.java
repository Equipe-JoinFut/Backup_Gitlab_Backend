package com.ages.joinfut.repository;

import com.ages.joinfut.model.AthleteSubgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteSubgroupRepository extends JpaRepository<AthleteSubgroup, Long> {
    AthleteSubgroup findByidAthleteSubgroup(Long id);
}
