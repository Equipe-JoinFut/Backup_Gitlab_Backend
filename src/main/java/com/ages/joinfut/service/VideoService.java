package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.VideoMapper;
import com.ages.joinfut.dto.VideoDTO;
import com.ages.joinfut.model.Video;
import com.ages.joinfut.repository.VideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;


    public VideoService() {}

    @Transactional
    public Video save(Video video, VideoRepository videoRepository) {
        videoRepository.save(video);
        return video;
    }

    @Transactional
    public void delete(@PathVariable Long id) {
        Optional<Video> videoGetter = videoRepository.findById(id);
        Video video = videoGetter.get();

        videoRepository.delete(video);
    }

    @Transactional
    public Video update(Long id, VideoDTO videoDTO, VideoRepository videoRepository) {
        Video updated = VideoMapper.MAPPER.VideoDTOToVideo(videoDTO);

        Video saved = videoRepository.findByidVideo(id);

        if (updated.getDescription() != null && !updated.getDescription().equals(saved.getDescription())) {
            saved.setDescription(updated.getDescription());
        }

        return saved;
    }


    public List<VideoDTO> convertList(List<Video> videos) {
        return videos.stream().map(video -> VideoMapper.MAPPER.VideoToVideoDTO(video)).collect(Collectors.toList());
    }
}
