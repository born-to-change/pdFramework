package com.lzq.service;

import com.lzq.mapper.FileMapper;
import com.lzq.pojo.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FileServiceImpl implements FileService{
    @Autowired
    private FileMapper fileMapper;

    public List<File> getImagesByUserId(Integer userId){
        List<File> fileList;
        try{
            fileList = fileMapper.getImagesByUserId(userId);
        }catch (Exception e) {
            log.warn("get user images by userId failed", e);
            return null;
        }
        return fileList;
    }

    public List<File> getVideosByUserId(Integer userId){
        List<File> fileList;
        try{
            fileList = fileMapper.getVideosByUserId(userId);
        }catch (Exception e) {
            log.warn("get user videos by userId failed", e);
            return null;
        }
        return fileList;
    }
}
