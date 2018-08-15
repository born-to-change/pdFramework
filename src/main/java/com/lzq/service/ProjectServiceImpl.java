package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.mapper.ProjectMapper;
import com.lzq.pojo.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public ResultInfo.Result createProject(Project project){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            projectMapper.createProject(project);

        } catch (Exception e) {
            log.warn("create project failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }
    public ResultInfo.Result deleteProject(Integer projectId){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            projectMapper.deleteProject(projectId);

        } catch (Exception e) {
            log.warn("delete project failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }
    public Project getProjectByProjectId(Integer projectId){
        Project project;
        try{
            project = projectMapper.getProjectByProjectId(projectId);
        }catch (Exception e) {
            log.warn("get project by projectId failed", e);
            return null;
        }
        return project;
    }
    public List<Project> getProjectsByUserId(Integer userId){
        List<Project> projectList;
        try{
            projectList = projectMapper.getProjectsByUserId(userId);
        }catch (Exception e) {
            log.warn("get projects by userId failed", e);
            return null;
        }
        return projectList;
    }
    public List<Project> getAllProjects(){
        List<Project> projectList;
        try{
            projectList = projectMapper.getAllProjects();
        }catch (Exception e) {
            log.warn("get all projects failed", e);
            return null;
        }
        return projectList;
    }
    public ResultInfo.Result updateProject(Project project){
        ResultInfo.Result ret = ResultInfo.Result.builder().isSuccess(true).build();
        try {
            projectMapper.updateProject(project);
        } catch (Exception e) {
            log.warn("update project failed", e);
            ret.setSuccess(false);
            ret.setErrorMessage(e.getMessage());
            return ret;
        }
        return ret;
    }

    public Project getProjectByProName(String proName){
        Project project;
        try{
            project = projectMapper.getProjectByProName(proName);
        }catch (Exception e) {
            log.warn("get projects by proName failed", e);
            return null;
        }
        return project;
    }
}
