package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoService {
    ResultInfo.Result createVideo(Video video);

    ResultInfo.Result updateVideo(Video video);

    ResultInfo.Result deleteVideo(Integer videoId);

    Video getVideoByCameraId(Integer cameraId);

}
