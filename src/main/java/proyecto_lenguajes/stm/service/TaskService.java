package proyecto_lenguajes.stm.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import proyecto_lenguajes.stm.Models.Task;
import proyecto_lenguajes.stm.repository.TaskRepository;

@Service
@AllArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task add(Task Task) {
        return taskRepository.save(Task);
    }

    public List<Task> get() {
        return taskRepository.findAll();
    }

    public Optional<Task> getById(int id) {
        return taskRepository.findById(id);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }

    public List<Task> list() {
        return taskRepository.findAll();
    }

    public Task update(int id, Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("proyecto no encontrado con ID: " + id);
        }
    }
}
