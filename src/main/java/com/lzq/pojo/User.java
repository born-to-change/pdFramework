package com.lzq.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class User {
    @NonNull
    private String token;
    @NonNull
    private String userPassword;
    @NonNull
    private Integer userId;
    @NonNull
    private String userName;

    private String telephone;
    private Integer memoryQuota;
    private Integer proSize;
    private Integer isAdmin;
    private Integer isRoot;
}