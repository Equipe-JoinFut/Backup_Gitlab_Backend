package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.VideoDTO;
import com.ages.joinfut.dto.VideoSlimDTO;
import com.ages.joinfut.model.Video;
import com.ages.joinfut.model.VideoSlim;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VideoMapper {

    VideoMapper MAPPER = Mappers.getMapper(VideoMapper.class);

    VideoDTO VideoToVideoDTO(Video video);
    VideoSlimDTO VideoToVideoSlimDTO(Video video);
    Video VideoDTOToVideo(VideoDTO videoDTO);
    Video VideoSlimDTOToVideo(VideoSlimDTO videoSlimDTO);
    VideoSlim VideoToVideoSlim(Video video);
}
