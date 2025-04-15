package proyecto_lenguajes.stm.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import proyecto_lenguajes.stm.Model.Subtask;
import proyecto_lenguajes.stm.repository.SubtaskRepository;

@Service
@AllArgsConstructor
public class SubtaskService {
    
      @Autowired
    private SubtaskRepository subtaskRepository;

    public Subtask add(Subtask subtask) {
        return subtaskRepository.save(subtask);
    }

    public List<Subtask> get() {
        return subtaskRepository.findAll();
    }

    public Optional<Subtask> getById(int id) {
        return subtaskRepository.findById(id);
    }
    public void delete(int id) {
        subtaskRepository.deleteById(id);
    }

    public Subtask update(int id, Subtask subtask) {
        Optional<Subtask> existingSubtask = subtaskRepository.findById(id);
        if (existingSubtask.isPresent()) {
            return subtaskRepository.save(subtask);
        } else {
            throw new RuntimeException("subtarea no encontrado con ID: " + id);
        }
    }
}
