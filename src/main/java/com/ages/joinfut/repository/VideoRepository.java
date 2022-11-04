package com.ages.joinfut.repository;

import com.ages.joinfut.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Video findByidVideo(Long id);
}
