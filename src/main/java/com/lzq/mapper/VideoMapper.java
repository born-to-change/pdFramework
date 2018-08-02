package com.lzq.mapper;

import com.lzq.pojo.Camera;
import com.lzq.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {
    boolean createVideo(Video video);

    boolean deleteVideo(Integer videoId);

    Camera updateVideo(Video video);

    Video getVideoByCameraId(Integer cameraId);
}