package com.ages.joinfut.repository;

import com.ages.joinfut.model.AtleteDecease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtleteDeceaseRepository extends JpaRepository<AtleteDecease, Long> {
    AtleteDecease findByidAtleteDecease(Long id);
}
