package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
public class Image {
    @NonNull
    private Integer imageId;
    @NonNull
    private Integer videoId;
    private Timestamp imageTime;
    private Integer tag;
    @NonNull
    private String imageUrl;
}