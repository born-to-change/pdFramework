package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.mapper.VideoMapper;
import com.lzq.pojo.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    private VideoMapper videoMapper;

    public ResultInfo.Result createVideo(Video video){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            videoMapper.createVideo(video);

        } catch (Exception e) {
            log.warn("create video failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public ResultInfo.Result updateVideo(Video video){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            videoMapper.updateVideo(video);

        } catch (Exception e) {
            log.warn("update video failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public ResultInfo.Result deleteVideo(Integer videoId){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            videoMapper.deleteVideo(videoId);

        } catch (Exception e) {
            log.warn("delete video failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public Video getVideoByCameraId(Integer cameraId){
        Video video;
        try {
            video = videoMapper.getVideoByCameraId(cameraId);

        } catch (Exception e) {
            log.warn("get video by cameraId failed", e);
            return null;
        }
        return video;
    }
}
