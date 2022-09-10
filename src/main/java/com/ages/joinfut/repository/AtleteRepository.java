package com.ages.joinfut.repository;

import com.ages.joinfut.model.Atlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtleteRepository extends JpaRepository<Atlete, Long> {

    Atlete findByidAtlete(Long id);
}
