package com.lzq.controller;


import com.alibaba.fastjson.JSON;
import com.lzq.Model.InvalidUserResult;
import com.lzq.common.ResultInfo;
import com.lzq.pojo.User;
import com.lzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {
    public static Integer currentUserId;
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/inValidUser", method = RequestMethod.POST)
    @ResponseBody
    public InvalidUserResult.Result inValidUser(@RequestBody String data) {
        Map<String, String> keyMap = JSON.parseObject(data, Map.class);
        String userName = keyMap.get("userName");
        String userPassword = keyMap.get("userPassword");
        User user = userService.getUserByUserName(userName);
        InvalidUserResult.Result result = InvalidUserResult.Result.builder().user(user).isSuccess(true).build();
        if(Objects.nonNull(user) && user.getUserPassword().equals(userPassword)){
            currentUserId = user.getUserId();
            return result;
        }else {
            result.setSuccess(false);
            return result;
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result createUser(@RequestBody String data) {

        User user = JSON.parseObject(data, User.class);
        return userService.createUser(user);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result updateUser(@RequestBody String data) {
        User user = JSON.parseObject(data, User.class);
        return userService.updateUser(user);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result deleteUser(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        int userId = keyMap.get("data");
        return userService.deleteUser(userId);
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    @ResponseBody
    public User getUserById(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        int userId = keyMap.get("data");
        return userService.getUserById(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getUserByUserName", method = RequestMethod.POST)
    @ResponseBody
    public User getUserByUserName(@RequestBody String data) {
        Map<String, String> keyMap = JSON.parseObject(data, Map.class);
        String userLabel = keyMap.get("data");
        return userService.getUserByUserName(userLabel);
    }

}
