package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Project {
    @NonNull
    private Integer proId;
    @NonNull
    private Integer userId;
    @NonNull
    private String proName;
    @NonNull
    private Timestamp proTime;
    private String proDescription;
}
