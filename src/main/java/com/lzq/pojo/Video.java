package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Video {
    @NonNull
    private Integer videoId;
    @NonNull
    private String videoImage;

}
