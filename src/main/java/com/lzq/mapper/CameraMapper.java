package com.lzq.mapper;

import com.lzq.pojo.Cam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CameraMapper {
    Boolean createCamera(Cam cam);
    Boolean deleteCamera(Integer cameraId);
    Boolean updateCamera(Cam cam);
    List<Cam> getCamerasByProId(Integer proId);
    Cam getCameraByCamId(Integer cameraId);
    Cam getCameraByCamName(String camName);
    Cam getCamByBingingFileId(@Param("proId")Integer proId,@Param("bingingFileId")Integer bingingFileId);
}
