package com.ages.joinfut.repository;

import com.ages.joinfut.model.Atlete;
import com.ages.joinfut.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByidContact(Long id);
    List<Contact> findByAtlete(Atlete atlete);
}
