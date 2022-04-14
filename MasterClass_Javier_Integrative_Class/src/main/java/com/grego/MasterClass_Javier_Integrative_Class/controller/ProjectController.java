package com.grego.MasterClass_Javier_Integrative_Class.controller;

import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.PersonDTO;
import com.grego.MasterClass_Javier_Integrative_Class.model.dtos.ProjectDTO;
import com.grego.MasterClass_Javier_Integrative_Class.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/id={id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Integer id) {
        return ResponseEntity.ok(projectService.findProjectById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<ProjectDTO> addProject(@RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectService.saveProject(projectDTO));
    }
    @PutMapping("/id={id}")
    public void updateProject(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO) {
        projectService.updateProject(id, projectDTO);
    }
    @DeleteMapping("/id={id}")
    public void deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<ProjectDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

}
