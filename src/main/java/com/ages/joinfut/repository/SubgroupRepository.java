package com.ages.joinfut.repository;

import com.ages.joinfut.model.Club;
import com.ages.joinfut.model.Subgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubgroupRepository extends JpaRepository<Subgroup, Long> {
    Subgroup findByidSubgroup(Long id);
    List<Subgroup> findByClub(Club club);
}
