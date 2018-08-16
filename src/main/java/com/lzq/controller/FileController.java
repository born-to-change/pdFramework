package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.lzq.pojo.Cam;
import com.lzq.pojo.File;
import com.lzq.service.CameraService;
import com.lzq.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    private CameraService cameraService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getImagesByUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<File> getImagesByUserId(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data, Map.class);
        Integer userId = Integer.parseInt(keyMap.get("userId"));
        return fileService.getImagesByUserId(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getVideosByUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<File> getVideosByUserId(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data, Map.class);
        Integer userId = Integer.parseInt(keyMap.get("userId"));
        Integer proId = Integer.parseInt(keyMap.get("proId"));
        List<Cam> cams = cameraService.getCamerasByProId(proId);
        List<File> files =  fileService.getVideosByUserId(userId);
        files.forEach(x->{
            cams.forEach(it->{
                if(it.getBingingFileId().equals(x.getFileId())){
                    files.remove(x);
                }
            });
        });
        return files;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getFileByFileId", method = RequestMethod.POST)
    @ResponseBody
    public File getFileByFileId(@RequestBody String data) {
        Map<String,String> keyMap = JSON.parseObject(data, Map.class);
        Integer fileId = Integer.parseInt(keyMap.get("fileId"));
        return fileService.getFileByFileId(fileId);
    }
}
