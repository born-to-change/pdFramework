package com.lzq.mapper;

import com.lzq.pojo.Cam;

import java.util.List;

public interface CameraMapper {
    Boolean createCamera(Cam cam);
    Boolean deleteCamera(Integer cameraId);
    Cam updateCamera(Cam cam);
    List<Cam> getCamerasByProId(Integer proId);
}
