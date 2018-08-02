package com.lzq.mapper;

import com.lzq.pojo.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {
    boolean createImage(Image image);

    boolean deleteImage(Integer imageId);

    List<Image> getImagesByVideoId(Integer videoId);
}