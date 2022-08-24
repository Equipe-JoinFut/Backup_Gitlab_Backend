package com.ages.joinfut.Controller;

import com.ages.joinfut.DTO.TemplateDTO;
import com.ages.joinfut.Model.Template;
import com.ages.joinfut.Repository.TemplateRepository;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/example")
public class TemplateController {

    private static final String URL_PLURAL = "/templates";
    private static final String URL_SINGULAR = "/template/{id}";

    @Autowired
    private TemplateRepository templateRepository;

    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os templates cadastrados")
    public ResponseEntity<List<TemplateDTO>> buscaTemplates() {
        List<Template> templates = templateRepository.findAll();
        List<TemplateDTO> templateDTO = TemplateDTO.convertList(templates);
        return new ResponseEntity<>(templateDTO, HttpStatus.OK);
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um template pelo seu ID")
    public ResponseEntity<TemplateDTO> buscaTemplatePorId(@PathVariable Long id) {
        Template template = templateRepository.findByiTemplate(id);
        TemplateDTO templateDTO = TemplateDTO.convertId(template);
        return new ResponseEntity<>(templateDTO, HttpStatus.OK);
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo template")
    public ResponseEntity<TemplateDTO> cadastraTemplate(@RequestBody @Valid TemplateDTO templateDTO, UriComponentsBuilder uriComponentsBuilder) {
        Template template = Template.desconvertId(templateDTO);
        templateRepository.save(template);
        URI uri = uriComponentsBuilder.path("template/{id}").buildAndExpand(template.getId()).toUri();
        return ResponseEntity.created(uri).body(new TemplateDTO(template));
    }
}
