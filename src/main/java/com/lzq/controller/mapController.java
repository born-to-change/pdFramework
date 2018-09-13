package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.lzq.common.ResultInfo;
import com.lzq.pojo.Image;
import com.lzq.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.testng.collections.Lists;
import org.testng.collections.Maps;
import java.util.Arrays;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/map")
public class mapController {
    @Autowired
    private ImageService imageService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getMapByProId", method = RequestMethod.POST)
    @ResponseBody
    public List<Image> getMapByProId(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer proId = keyMap.get("proId");
        List<Image> imageList = imageService.getImagesByProId(proId);
//        Map<Timestamp, List<Double>> lineMarksMap = Maps.newHashMap();
////        imageList.forEach(x -> {
////            List<Double> marksList = Lists.newArrayList();
////            marksList.add(x.getCamLat());
////            marksList.add(x.getCamLng());
////            lineMarksMap.put(x.getImageTime(),marksList);
////        });
////
////        List<List<Double>> path = Lists.newArrayList();
////        lineMarksMap.keySet()
        imageList.sort(Comparator.comparing(Image::getImageTime));
        System.out.println(imageList);
        return imageList;

    }
}
