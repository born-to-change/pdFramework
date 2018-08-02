package com.lzq.mapper;

import com.lzq.pojo.UserImage;
import com.lzq.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserVideoMapper {

    boolean createUserVideo(UserImage image);

    boolean deleteUserVideo(UserImage image);

    List<Video> getVideosByProjectId(Integer proId);

}
