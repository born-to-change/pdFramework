package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
public class Image {

    private Integer imageId;
    @NonNull
    private Integer cameraId;
    @NonNull
    private Integer proId;
    @NonNull
    private String camName;
    @NonNull
    private Double camLng;
    @NonNull
    private Double camLat;
    @NonNull
    private String imageUrl;


    private Timestamp imageTime;
    private Integer tag;




    private String finalImageUrl;
    private String searchImageUrl;
}
