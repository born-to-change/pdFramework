package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserImage {
    @NonNull
    private Integer userImageId;
    @NonNull
    private Integer userImageUrl;
    @NonNull
    private Integer projectId;
}
