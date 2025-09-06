package dev.viniciusmacedo.task_manager.tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        if (taskService.findById(id) != null) {
            return ResponseEntity.ok(taskService.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        if (taskService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        } else {
            return ResponseEntity.ok(taskService.findAll());

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        if (taskService.findById(id) != null) {
            return ResponseEntity.ok(taskService.editById(id, taskDTO));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        if (taskService.findById(id) != null) {
            taskService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }


}
