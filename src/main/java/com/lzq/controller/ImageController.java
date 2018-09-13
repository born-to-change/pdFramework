package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lzq.common.ResultInfo;
import com.lzq.pojo.Cam;
import com.lzq.pojo.Image;
import com.lzq.service.CameraService;
import com.lzq.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/createImage", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result createImage(@RequestBody String data) {
        Image image = JSON.parseObject(data,Image.class);
//        Map<String, String> keyMap = JSON.parseObject(data, Map.class);
//        Gson gson = new Gson();
//        String img = gson.toJson(keyMap.get("image"));
//        Image image = gson.fromJson(img,Image.class);
        return imageService.createImage(image);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/deleteImage", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result deleteImage(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer imageId = keyMap.get("imageId");
        return imageService.deleteImage(imageId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getImagesByCameraId", method = RequestMethod.POST)
    @ResponseBody
    public List<Image> getImagesByCameraId(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer cameraId = keyMap.get("cameraId");
        return imageService.getImagesByCameraId(cameraId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/updateImage", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result updateImage(@RequestBody String data) {
        Image image = JSON.parseObject(data,Image.class);
//        Map<String, String> keyMap = JSON.parseObject(data, Map.class);
//        Gson gson = new Gson();
//        String img = gson.toJson(keyMap.get("image"));
//        Image image= gson.fromJson(img,Image.class);
        return imageService.updateImage(image);
    }
}
