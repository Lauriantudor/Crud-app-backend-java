package com.tudy.Crud.app.backend.controller;

import com.tudy.Crud.app.backend.model.Project;
import com.tudy.Crud.app.backend.sevice.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
@CrossOrigin("http://localhost:4200/")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("{id}")
    public Project getProjectById(@PathVariable long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("{id}")
    public Project updateProject(@PathVariable long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
    }
}
