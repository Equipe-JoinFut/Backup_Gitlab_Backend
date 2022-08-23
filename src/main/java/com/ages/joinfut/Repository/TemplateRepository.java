package com.ages.joinfut.Repository;

import com.ages.joinfut.Model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
    Template findByiTemplate(Long id);
    Template findBynome(String nome);
}
