package com.lzq.mapper;

import com.lzq.pojo.File;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMapper {
    List<File> getImagesByUserId(Integer userId);

    List<File> getVideosByUserId(Integer userId);

    File getFileByFileId(Integer fileId);
}
