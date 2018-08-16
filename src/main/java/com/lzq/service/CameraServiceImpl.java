package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.mapper.CameraMapper;
import com.lzq.pojo.Cam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CameraServiceImpl implements CameraService{
    @Autowired
    private CameraMapper cameraMapper;

    public ResultInfo.Result createCamera(Cam cam){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            cameraMapper.createCamera(cam);

        } catch (Exception e) {
            log.warn("create cam failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public ResultInfo.Result deleteCamera(Integer cameraId){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            cameraMapper.deleteCamera(cameraId);

        } catch (Exception e) {
            log.warn("delete image failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public List<Cam> getCamerasByProId(Integer proId){
        List<Cam> cams;
        try{
            cams = cameraMapper.getCamerasByProId(proId);
        }catch (Exception e) {
            log.warn("get cams by proId failed", e);
            return null;
        }
        return cams;
    }

    public Cam getCameraByCamId(Integer cameraId){
       Cam cam;
        try{
            cam = cameraMapper.getCameraByCamId(cameraId);
        }catch (Exception e) {
            log.warn("get cams by camId failed", e);
            return null;
        }
        return cam;
    }

    public Cam getCamByBingingFileId(Integer BingingFileId){
        Cam cam;
        try{
            cam = cameraMapper.getCamByBingingFileId(BingingFileId);
        }catch (Exception e) {
            log.warn("get cams by BingingFileId failed", e);
            return null;
        }
        return cam;
    }

    public Cam getCameraByCamName(String camName){
        Cam cam;
        try{
            cam = cameraMapper.getCameraByCamName(camName);
        }catch (Exception e) {
            log.warn("get cams by camName failed", e);
            return null;
        }
        return cam;
    }

    public ResultInfo.Result updateCamera(Cam cam){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            cameraMapper.updateCamera(cam);

        } catch (Exception e) {
            log.warn("update image failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }
}

