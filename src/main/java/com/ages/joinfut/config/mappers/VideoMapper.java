package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.VideoDTO;
import com.ages.joinfut.model.Video;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VideoMapper {

    VideoMapper MAPPER = Mappers.getMapper(VideoMapper.class);

    VideoDTO VideoToVideoDTO(Video video);
    Video VideoDTOToVideo(VideoDTO videoDTO);
}
