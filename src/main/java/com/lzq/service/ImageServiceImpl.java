package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.mapper.ImageMapper;
import com.lzq.pojo.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageMapper imageMapper;

    public ResultInfo.Result createImage(Image image){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            imageMapper.createImage(image);

        } catch (Exception e) {
            log.warn("create image failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public ResultInfo.Result deleteImage(Integer imageId){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            imageMapper.deleteImage(imageId);

        } catch (Exception e) {
            log.warn("delete image failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public List<Image> getImagesByVideoId(Integer videoId){
        List<Image> imageList;
        try{
            imageList = imageMapper.getImagesByVideoId(videoId);
        }catch (Exception e) {
            log.warn("get images by videoId failed", e);
            return null;
        }
        return imageList;
    }
}
