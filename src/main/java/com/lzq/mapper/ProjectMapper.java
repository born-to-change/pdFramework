package com.lzq.mapper;

import com.lzq.pojo.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    Boolean createProject(Project project);
    Boolean updateProject(Project project);
    Boolean deleteProject(Integer projectId);
    Project getProjectByProjectId(Integer projectId);
    List<Project> getProjectsByUserId(Integer userId);
    List<Project> getAllProjects();
}
