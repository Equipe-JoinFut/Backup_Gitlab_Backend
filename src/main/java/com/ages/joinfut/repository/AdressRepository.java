package com.ages.joinfut.repository;

import com.ages.joinfut.Enum.State;
import com.ages.joinfut.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
    Adress findByidAdress(Long id);
}
