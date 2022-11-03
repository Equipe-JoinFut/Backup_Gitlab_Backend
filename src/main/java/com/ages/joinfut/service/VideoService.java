package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.AthleteMapper;
import com.ages.joinfut.config.mappers.VideoMapper;
import com.ages.joinfut.dto.AthleteDTO;
import com.ages.joinfut.dto.VideoDTO;
import com.ages.joinfut.model.Athlete;
import com.ages.joinfut.model.AthleteClub;
import com.ages.joinfut.model.Video;
import com.ages.joinfut.repository.AdressRepository;
import com.ages.joinfut.repository.AthleteClubRepository;
import com.ages.joinfut.repository.AthleteRepository;
import com.ages.joinfut.repository.ContactRepository;
import com.ages.joinfut.repository.VideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    private AthleteService athleteService= new AthleteService();


    public VideoService() {}

    @Transactional
    public Video save(VideoDTO videoDTO) {
        
        Video video = VideoMapper.MAPPER.VideoDTOToVideo(videoDTO);

        videoRepository.save(video);


        if (video.getAthlete() != null) {
            // video.getAthlete().setVideo(video); ta errado isso??
            athleteService.save(AthleteMapper.MAPPER.AthleteToAthleteDTO(video.getAthlete()));
        }

        return video;
    }

    @Transactional
    public void delete(@PathVariable Long id) {
        Optional<Video> videoGetter = videoRepository.findById(id);
        Video video = videoGetter.get();

        if (video.getAthlete() != null && video.getAthlete().getId() != null) {
            athleteService.delete(video.getAthlete().getId());
        }

        videoRepository.delete(video);
    }






}
