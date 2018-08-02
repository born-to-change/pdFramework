package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.pojo.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectService {
    ResultInfo.Result createProject(Project project);
    ResultInfo.Result deleteProject(Integer projectId);
    Project getProjectByProjectId(Integer projectId);
    List<Project> getProjectsByUserId(Integer userId);
    List<Project> getAllProjects();
}
