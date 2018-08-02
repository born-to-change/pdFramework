package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserVideo {
    @NonNull
    private Integer userVideoId;
    @NonNull
    private Integer userVideoUrl;
    @NonNull
    private Integer projectId;
}
