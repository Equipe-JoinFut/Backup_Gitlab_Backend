package com.ages.joinfut.repository;

import com.ages.joinfut.model.Subgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubgroupRepository extends JpaRepository<Subgroup, Long> {

}
