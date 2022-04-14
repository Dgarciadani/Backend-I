package com.grego.MasterClass_Javier_Integrative_Class.service;

import com.grego.MasterClass_Javier_Integrative_Class.model.Project;
import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.ProjectDTO;
import com.grego.MasterClass_Javier_Integrative_Class.repository.IProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository projectRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        return toProjectDTO(projectRepository.save(toProject(projectDTO)));
    }

    @Override
    public ProjectDTO findProjectById(Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        return project.map(this::toProjectDTO).orElse(null);
    }

    @Override
    public void UpdateProject(Integer id, ProjectDTO projectDTO) {
        Project project = toProject(projectDTO);
        project.setId(id);
        projectRepository.save(project);

    }

    @Override
    public void deleteProject(Integer id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }
    }

    @Override
    public Set<ProjectDTO> findAll() {
      return projectRepository.findAll().stream().map(this::toProjectDTO).collect(java.util.stream.Collectors.toSet());
    }

    //--Mapper--//
    public ProjectDTO toProjectDTO(Project project) {
        return modelMapper.map(project, ProjectDTO.class);
    }

    public Project toProject(ProjectDTO projectDTO) {
        return modelMapper.map(projectDTO, Project.class);
    }
}
