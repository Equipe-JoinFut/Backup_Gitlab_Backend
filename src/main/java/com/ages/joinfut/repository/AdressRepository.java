package com.ages.joinfut.repository;

import com.ages.joinfut.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
    Adress findByidAdress(Long id);
}
