package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.lzq.Model.InvalidUserResult;
import com.lzq.pojo.User;
import com.lzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
    @ResponseBody
    public void inValidUser(@RequestBody String data) {
    }

}
