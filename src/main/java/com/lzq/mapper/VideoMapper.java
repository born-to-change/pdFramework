package com.lzq.mapper;

import com.lzq.pojo.Cam;
import com.lzq.pojo.Video;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoMapper {
    boolean createVideo(Video video);

    boolean deleteVideo(Integer videoId);

    Cam updateVideo(Video video);

    Video getVideoByCameraId(Integer cameraId);
}