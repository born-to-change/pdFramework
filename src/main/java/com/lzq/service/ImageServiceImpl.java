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

    public List<Image> getImagesByCameraId(Integer cameraId){
        List<Image> imageList;
        try{
            imageList = imageMapper.getImagesByCameraId(cameraId);
        }catch (Exception e) {
            log.warn("get images by cameraId failed", e);
            return null;
        }
        return imageList;
    }
    public ResultInfo.Result updateImage(Image image){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            imageMapper.updateImage(image);

        } catch (Exception e) {
            log.warn("update image failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public List<Image> getImagesByProId(Integer proId){
        List<Image> imageList;
        try{
            imageList = imageMapper.getImagesByProId(proId);
        }catch (Exception e) {
            log.warn("get images by proId failed", e);
            return null;
        }
        return imageList;
    }


}
