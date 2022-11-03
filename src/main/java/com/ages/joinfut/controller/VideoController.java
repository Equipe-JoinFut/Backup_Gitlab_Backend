package com.ages.joinfut.controller;

import com.ages.joinfut.config.mappers.VideoMapper;
import com.ages.joinfut.dto.VideoDTO;
import com.ages.joinfut.model.Video;
import com.ages.joinfut.repository.VideoRepository;
import com.ages.joinfut.service.VideoService;

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
@RequestMapping(value = "/informations")
public class VideoController {
    
    private static final String URL_PLURAL = "/videos";
    private static final String URL_SINGULAR = "/video/{id}";

    private VideoRepository videoRepository;
    private VideoService videoService;

    @Autowired
    public VideoController(
        VideoRepository videoRepository, 
        VideoService videoService
    ){
        this.videoRepository = videoRepository;
        this.videoService = videoService;
    }


    @GetMapping(value = URL_PLURAL, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os videos cadastrados")
    public ResponseEntity<List<VideoDTO>> readAllVideos() {
        List<Video> videos = videoRepository.findAll();
        List<VideoDTO> videosDTO = videoService.convertList(videos);
        return new ResponseEntity<>(videosDTO, HttpStatus.OK);
    }


    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um Video pelo seu ID")
    public ResponseEntity<VideoDTO> readVideoById(@PathVariable Long id) {
        Optional<Video> video = videoRepository.findById(id);
        return video.map(value -> ResponseEntity.ok(VideoMapper.MAPPER.VideoToVideoDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo video")
    @Transactional
    public ResponseEntity<VideoDTO> createVideo(@RequestBody @Valid VideoDTO videoDTO, UriComponentsBuilder uriComponentsBuilder) {
        Video video = videoService.save(videoDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(VideoMapper.MAPPER.VideoToVideoDTO(video));
    }


    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um video salvo")
    @Transactional
    public ResponseEntity<VideoDTO> updateVideo(@PathVariable Long id, @RequestBody @Valid VideoDTO videoDTO) {
        Optional<Video> verifyId = videoRepository.findById(id);
        if (verifyId.isPresent()) {
            Video video = videoService.update(id, videoDTO, videoRepository);
            return ResponseEntity.ok(VideoMapper.MAPPER.VideoToVideoDTO(video));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um video salvo")
    @Transactional
    public ResponseEntity<Long> deleteVideo(@PathVariable Long id) {
        Optional<Video> verifyId = videoRepository.findById(id);
        if (verifyId.isPresent()) {
            videoService.delete(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }

}
