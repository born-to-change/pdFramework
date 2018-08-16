package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.pojo.Cam;

import java.util.List;

public interface CameraService {
    ResultInfo.Result createCamera(Cam cam);
    ResultInfo.Result deleteCamera(Integer cameraId);
    ResultInfo.Result updateCamera(Cam cam);
    List<Cam> getCamerasByProId(Integer proId);
    Cam getCameraByCamId(Integer cameraId);
    Cam getCameraByCamName(String camName);
    Cam getCamByBingingFileId(Integer BingingFileId);
}
