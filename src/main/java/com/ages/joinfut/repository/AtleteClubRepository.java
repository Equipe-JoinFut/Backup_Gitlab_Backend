package com.ages.joinfut.repository;

import com.ages.joinfut.model.AtleteClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtleteClubRepository extends JpaRepository<AtleteClub, Long> {
    AtleteClub findByidAtleteClub(Long id);
}
