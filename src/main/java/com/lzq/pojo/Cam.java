package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Cam {
    @NonNull
    private Integer cameraId;
    @NonNull
    private String videoImage;
    private String cameraDescription;
    @NonNull
    private Integer proId;
    @NonNull
    private Double camLng;
    @NonNull
    private Double camLat;
    @NonNull
    private String camName;

}
