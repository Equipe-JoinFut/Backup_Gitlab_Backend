package com.ages.joinfut.repository;

import com.ages.joinfut.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Club findByidClub(Long id);
}
