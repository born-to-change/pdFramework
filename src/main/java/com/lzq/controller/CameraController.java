package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lzq.common.ResultInfo;
import com.lzq.pojo.Cam;
import com.lzq.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/camera")
public class CameraController {
    @Autowired
    private CameraService cameraService;
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/createCamera", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result createCamera(@RequestBody String data) {
        Map<String, String> keyMap = JSON.parseObject(data, Map.class);
        Gson gson = new Gson();
        String cam = gson.toJson(keyMap.get("camera"));
        Cam camera= gson.fromJson(cam,Cam.class);
        return cameraService.createCamera(camera);
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/deleteCamera", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result deleteCamera(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer cameraId = keyMap.get("cameraId");
        return cameraService.deleteCamera(cameraId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getCamerasByProId", method = RequestMethod.POST)
    @ResponseBody
    public List<Cam> getCamerasByProId(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer proId = keyMap.get("proId");
        return cameraService.getCamerasByProId(proId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/updateCamera", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result updateCamera(@RequestBody String data) {
        Map<String, String> keyMap = JSON.parseObject(data, Map.class);
        Gson gson = new Gson();
        String cam = gson.toJson(keyMap.get("camera"));
        Cam camera= gson.fromJson(cam,Cam.class);
        return cameraService.updateCamera(camera);
    }
}
