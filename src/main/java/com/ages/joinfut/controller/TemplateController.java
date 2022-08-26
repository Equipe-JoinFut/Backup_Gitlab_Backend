package com.ages.joinfut.controller;

import com.ages.joinfut.dto.TemplateDTO;
import com.ages.joinfut.model.Template;
import com.ages.joinfut.repository.TemplateRepository;
import com.ages.joinfut.service.TemplateService;
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

    // Caminhos da URL dependendo do tipo de requisição
    private static final String URL_PLURAL = "/templates";
    private static final String URL_SINGULAR = "/template/{id}";

    // Vinculos dos repository
    @Autowired //Autowired permite ao Spring resolver primeiro e depois injetar a dependencia na classe atual
    private TemplateRepository templateRepository;

    // Vinculos dos services
    @Autowired
    private TemplateService templateService;

    /**
     * Requisição GET ALL do REST API
     * (Serve para buscar todos os objetos desse tipo do banco)
     * @return ResponseEntity
     */
    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE) //GetMapping mapeia esse método como GET e retorna um JSON
    @ApiModelProperty("Busca em lista de todos os templates cadastrados")// Comentário do documento de métodos
    public ResponseEntity<List<TemplateDTO>> readAllTemplates() {
        List<Template> templates = templateRepository.findAll(); //Método de busca de todos os objetos do repository genérico
        List<TemplateDTO> templateDTO = templateService.convertList(templates);
        return new ResponseEntity<>(templateDTO, HttpStatus.OK);
    }

    /**
     * Requisição GET BY ID do REST API
     * (Serve para buscar do banco de dados um objeto pelo seu Id)
     * @param id
     * @return ResponseEntity
     */
    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um template pelo seu ID")
    public ResponseEntity<TemplateDTO> readTemplateById(@PathVariable Long id) {
        Optional<Template> template = templateRepository.findById(id); //Método de busca por ID do repository genérico
        return template.map(value -> ResponseEntity.ok(new TemplateDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Requisição POST do REST API
     * (Serve para cadastrar um objeto novo)
     * @param templateDTO
     * @param uriComponentsBuilder
     * @return ResponseEntity
     */
    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE) // PostMapping diz que esse método é do tipo POST e retorna um JSON
    @ApiModelProperty("Cria um novo template")
    @Transactional //Obrigatório em todas as requisições de escrita
    public ResponseEntity<TemplateDTO> createTemplate(@RequestBody @Valid TemplateDTO templateDTO, UriComponentsBuilder uriComponentsBuilder) {
        // RequestBody transforma o Body da requisição em um objeto DTO
        // Valid ativa as validações construidas nas configurações do projeto (config.validation)
        Template template = templateService.desconvertObject(templateDTO);
        templateRepository.save(template); // método para salvar o novo objeto no banco do repository genérico
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(template.getId()).toUri(); // tratamento do body de resposta de retorno
        return ResponseEntity.created(uri).body(new TemplateDTO(template));
    }

    /**
     * Requisição PUT do REST API
     * (Serve para atualizar um objeto salvo do banco com novos valores de entrada)
     * @param id
     * @param templateDTO
     * @return ResponseEntity
     */
    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE) // PutMapping diz que esse método é do tipo PUT e retorna um JSON
    @ApiModelProperty("Atualiza um template salvo")
    @Transactional
    public ResponseEntity<TemplateDTO> updateTemplate(@PathVariable Long id, @RequestBody @Valid TemplateDTO templateDTO) {
        Optional<Template> verifyId = templateRepository.findById(id);
        if (verifyId.isPresent()) {
            Template updatedTemplate = templateService.desconvertObject(templateDTO);
            Template template = templateService.updateObject(id, updatedTemplate, templateRepository); //método do service de fazer atualização do objeto entrado
            return ResponseEntity.ok(new TemplateDTO(template));
        }
        return ResponseEntity.notFound().build(); //Tratamento de requisição quando não encontrado
    }

    /**
     * Requisição DELETE do REST API
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE) //DeleteMapping serve para dizer que esse método deleta um objeto
    @ApiModelProperty("Remove um template salvo")
    @Transactional
    public ResponseEntity<Long> deleteTemplate(@PathVariable Long id) {
        Optional<Template> verifyId = templateRepository.findById(id);
        if (verifyId.isPresent()) {
            templateRepository.deleteById(id); //método de deletar pelo ID do repositório global
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }
    //ResponseEntity é uma entidade genérica que é o retorno em JSON do que for definido nesses métodos
    // ResponseEntity possui HeadersBuilders que são retornos HTTP:
    // ResponseEntity.ok() retorna 201 OK
    // ResponseEntity.ok(object) retorna 201 OK com o objeto como JSON
    // ResponseEntity.notFound().build() retorna 404 NOT FOUND e o build construi response quando não tem nada
    // ResponseEntity.created(uri).body(object); retorna 200 CREATED e retorna um JSON com dados do objeto salvos
    // return new ResponseEntity<>(object, HttpStatus.OK); retorna uma lista e o status 201 OK

}
