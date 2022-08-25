package com.ages.joinfut.Controller;

import com.ages.joinfut.DTO.TemplateDTO;
import com.ages.joinfut.Model.Template;
import com.ages.joinfut.Repository.TemplateRepository;
import com.ages.joinfut.Service.TemplateService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/example")
public class TemplateController {

    private static final String URL_PLURAL = "/templates";
    private static final String URL_SINGULAR = "/template/{id}";

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private TemplateService templateService;

    /**
     * Requisição GET ALL do REST API
     * @return ResponseEntity
     */
    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os templates cadastrados")
    public ResponseEntity<List<TemplateDTO>> readAllTemplates() {
        List<Template> templates = templateRepository.findAll();
        List<TemplateDTO> templateDTO = templateService.convertList(templates);
        return new ResponseEntity<>(templateDTO, HttpStatus.OK);
    }

    /**
     * Requisição GET BY ID do REST API
     * @param id
     * @return ResponseEntity
     */
    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um template pelo seu ID")
    public ResponseEntity<TemplateDTO> readTemplateById(@PathVariable Long id) {
        Optional<Template> template = templateRepository.findById(id);
        return template.map(value -> ResponseEntity.ok(new TemplateDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo template")
    @Transactional //Obrigatório em todas as requisições de escrita
    public ResponseEntity<TemplateDTO> createTemplate(@RequestBody @Valid TemplateDTO templateDTO, UriComponentsBuilder uriComponentsBuilder) {
        Template template = templateService.desconvertObject(templateDTO);
        templateRepository.save(template);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(template.getId()).toUri();
        return ResponseEntity.created(uri).body(new TemplateDTO(template));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um template salvo")
    @Transactional
    public ResponseEntity<TemplateDTO> updateTemplate(@PathVariable Long id, @RequestBody @Valid TemplateDTO templateDTO) {
        Optional<Template> verifyId = templateRepository.findById(id);
        if (verifyId.isPresent()) {
            Template updatedTemplate = templateService.desconvertObject(templateDTO);
            Template template = templateService.updateObject(id, updatedTemplate, templateRepository);
            return ResponseEntity.ok(new TemplateDTO(template));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um template salvo")
    @Transactional
    public ResponseEntity<Long> deleteTemplate(@PathVariable Long id) {
        Optional<Template> verifyId = templateRepository.findById(id);
        if (verifyId.isPresent()) {
            templateRepository.deleteById(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }


}
