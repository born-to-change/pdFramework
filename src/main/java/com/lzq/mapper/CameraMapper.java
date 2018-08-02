package com.lzq.mapper;

import com.lzq.pojo.Camera;

import java.util.List;

public interface CameraMapper {
    Boolean createCamera(Camera camera);
    Boolean deleteCamera(Camera camera);
    Camera updateCamera(Camera camera);
    List<Camera> getCamerasByProId(Integer proId);
}
