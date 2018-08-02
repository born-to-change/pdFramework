package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Camera {
    @NonNull
    private Integer cameraId;
    @NonNull
    private String videoImage;
    private String cameraDescription;
    @NonNull
    private Integer proId;

}
