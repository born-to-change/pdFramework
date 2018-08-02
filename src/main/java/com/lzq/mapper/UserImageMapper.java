package com.lzq.mapper;

import com.lzq.pojo.Image;
import com.lzq.pojo.UserImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserImageMapper {

    boolean createUserImage(UserImage image);

    boolean deleteUserImage(UserImage image);

    List<Image> getImagesByProjectId(Integer proId);

}
