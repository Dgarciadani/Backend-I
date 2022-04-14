package com.grego.MasterClass_Javier_Integrative_Class.service;

import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.ProjectDTO;

import java.util.Set;

public interface IProjectService {
    ProjectDTO saveProject(ProjectDTO projectDTO);

    ProjectDTO findProjectById(Integer id);

    void UpdateProject(Integer id, ProjectDTO projectDTO);

    void deleteProject(Integer id);

    Set<ProjectDTO> findAll();

}
