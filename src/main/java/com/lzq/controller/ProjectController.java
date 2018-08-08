package com.lzq.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lzq.Model.InvalidUserResult;
import com.lzq.common.ResultInfo;
import com.lzq.pojo.Project;
import com.lzq.pojo.User;
import com.lzq.service.ProjectService;
import com.lzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
//    ResultInfo.Result createProject(Project project);
//    ResultInfo.Result deleteProject(Integer projectId);
//    Project getProjectByProjectId(Integer projectId);
//    List<Project> getProjectsByUserId(Integer userId);
//    List<Project> getAllProjects();
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result createProject(@RequestBody String data) {
        Map<String, String> keyMap = JSON.parseObject(data, Map.class);
        Gson gson = new Gson();
        String pro = gson.toJson(keyMap.get("project"));
        Project project= gson.fromJson(pro, Project.class);
//        String projectName = keyMap.get("proName");
//        Integer userId = Integer.valueOf(keyMap.get("userId"));
//        String proDescription = keyMap.get("proDescription");
//        Project project = new Project();
//        project.setProTime(new Timestamp(System.currentTimeMillis()));
//        project.setProDescription(proDescription);
//        project.setUserId(userId);
//        project.setProName(projectName);

        return projectService.createProject(project);
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result deleteProject(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer proId = keyMap.get("proId");
        return projectService.deleteProject(proId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getProjectByProjectId", method = RequestMethod.POST)
    @ResponseBody
    public Project getProjectByProjectId(@RequestBody String data) {
        Map<String, Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer proId = keyMap.get("proId");
        return projectService.getProjectByProjectId(proId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getProjectsByUserId", method = RequestMethod.POST)
    @ResponseBody
    public List<Project> getProjectsByUserId(@RequestBody String data) {
        Map<String,Integer> keyMap = JSON.parseObject(data, Map.class);
        Integer userId = keyMap.get("userId");
        return projectService.getProjectsByUserId(userId);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getAllProjects", method = RequestMethod.POST)
    @ResponseBody
    public List<Project> getAllProjects(@RequestBody String data) {
        return projectService.getAllProjects();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/updateProject", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo.Result updateProject(@RequestBody String data) {
        Map<String, String> keyMap = JSON.parseObject(data, Map.class);
        Gson gson = new Gson();
        String pro = gson.toJson(keyMap.get("project"));
        Project project= gson.fromJson(pro, Project.class);
        return projectService.updateProject(project);
    }
}
