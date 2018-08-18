package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class File {
    @NonNull
    private Integer fileId;
    @NonNull
    private Integer userId;
    @NonNull
    private Integer categoryId;
    @NonNull
    private String fileUrl;
    @NonNull
    private String fileName;

}
