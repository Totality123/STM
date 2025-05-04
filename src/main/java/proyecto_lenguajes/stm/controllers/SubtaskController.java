package proyecto_lenguajes.stm.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import proyecto_lenguajes.stm.Models.Subtask;
import proyecto_lenguajes.stm.service.SubtaskService;

@RestController
@RequestMapping("/subtasks")
public class SubtaskController {

    private final SubtaskService subtaskService;

    public SubtaskController(SubtaskService subtaskService) {
        this.subtaskService = subtaskService;
    }

    @GetMapping
    public List<Subtask> list() {
        return subtaskService.list();
    }

    @GetMapping("/listByid/{id}")
    public List<Subtask> listByid(@PathVariable int id) {
        return subtaskService.listByid(id);
    }

    @PostMapping("/add")
    public Subtask add(@RequestBody Subtask subtask) {
        return subtaskService.add(subtask);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        subtaskService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Subtask update(@PathVariable int id, @RequestBody Subtask subtask) {
        return subtaskService.update(id, subtask);
    }

    @GetMapping("/{id}")
    public Subtask getById(@PathVariable int id) {
        return subtaskService.getById(id).orElse(null);
    }
}
