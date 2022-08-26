package com.ages.joinfut.service;

import com.ages.joinfut.dto.TemplateDTO;
import com.ages.joinfut.model.Template;
import com.ages.joinfut.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemplateService {

    public List<TemplateDTO> convertList(List<Template> templates) {
        return templates.stream().map(TemplateDTO::new).collect(Collectors.toList());
    }

    public TemplateDTO convertObject(Template template) {
        return new TemplateDTO(template);
    }

    public List<Template> desconvertList(List<TemplateDTO> templateDTOS) {
        return templateDTOS.stream().map(Template::new).collect(Collectors.toList());
    }

    public Template desconvertObject(TemplateDTO templateDTO) {
        return new Template(templateDTO);
    }

    public Template updateObject(Long id, Template updated, TemplateRepository templateRepository) {
        Template saved = templateRepository.findByiTemplate(id);
        if (updated.getNome() != null && !updated.getNome().equals(saved.getNome())) {
            saved.setNome(updated.getNome());
        }
        if (updated.getTemplateEnum() != null && !updated.getTemplateEnum().equals(saved.getTemplateEnum())) {
            saved.setTemplateEnum(updated.getTemplateEnum());
        }
        if (updated.getFlagAtivo() != null && !updated.getFlagAtivo().equals(saved.getFlagAtivo())) {
            saved.setFlagAtivo(updated.getFlagAtivo());
        }
        return saved;
    }
}
