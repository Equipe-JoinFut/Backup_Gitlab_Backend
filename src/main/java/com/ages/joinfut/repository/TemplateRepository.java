package com.ages.joinfut.repository;

import com.ages.joinfut.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
    Template findByidTemplate(Long id);
    Template findBynome(String nome);
}
