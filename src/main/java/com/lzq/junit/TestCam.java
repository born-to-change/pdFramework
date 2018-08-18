package com.lzq.junit;

import com.lzq.mapper.CameraMapper;
import com.lzq.pojo.Cam;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCam {

    @Test
    public void TestCreateCam(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CameraMapper mapper = ac.getBean(CameraMapper.class);
        Cam cam = new Cam();
        cam.setCamName("cam1");
        cam.setProId(3);
        cam.setVideoImage("/File/upload/a.jpg");
        cam.setCamLat(39.904089);
        cam.setCamLng(116.415306);
        cam.setCameraDescription("test");
        mapper.createCamera(cam);
    }

    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CameraMapper mapper = ac.getBean(CameraMapper.class);
        mapper.getCamByBingingFileId(1,4);
    }

}
