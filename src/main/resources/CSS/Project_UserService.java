package proyecto_lenguajes.stm.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import proyecto_lenguajes.stm.Model.Project_User;
import proyecto_lenguajes.stm.repository.Project_UserRepository;

@Service
@AllArgsConstructor
public class Project_UserService {
    
      @Autowired
    private Project_UserRepository project_UserRepository;

    public Project_User add(Project_User project_User) {
        return project_UserRepository.save(project_User);
    }

    public List<Project_User> get() {
        return project_UserRepository.findAll();
    }

    public Optional<Project_User> getById(int id) {
        return project_UserRepository.findById(id);
    }
    public void delete(int id) {
        project_UserRepository.deleteById(id);
    }

    public Project_User update(int id, Project_User project_User) {
        Optional<Project_User> existingproject_User = project_UserRepository.findById(id);
        if (existingproject_User.isPresent()) {
            return project_UserRepository.save(project_User);
        } else {
            throw new RuntimeException("relacion Proyecto/Usuario no encontrado con ID: " + id);
        }
    }
}



