package proyecto_lenguajes.stm.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import proyecto_lenguajes.stm.Models.Project;
import proyecto_lenguajes.stm.repository.ProjectRepository;

@Service
@AllArgsConstructor
public class ProjectService {
    
      @Autowired
    private ProjectRepository projectRepository;

    public Project add(Project project) {
        return projectRepository.save(project);
    }

    public Project get(int id) {
        return projectRepository.getById(id);
    }

    public Optional<Project> getById(int id) {
        return projectRepository.findById(id);
    }
    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    public List<Project> list() {
        return projectRepository.findAll();
    }

    public List<Project> listByid(int id_usuario) {
        return projectRepository.listByid(id_usuario);
    }

    public Project update(int id, Project Project) {
        Optional<Project> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()) {
            Project updatedCategory = existingProject.get();
            updatedCategory.setName(Project.getName());
            return projectRepository.save(updatedCategory);
        } else {
            throw new RuntimeException("proyecto no encontrado con ID: " + id);
        }
    }



}
