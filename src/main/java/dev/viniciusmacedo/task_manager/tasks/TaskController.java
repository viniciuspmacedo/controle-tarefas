package dev.viniciusmacedo.task_manager.tasks;

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
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping()
    public List<TaskDTO> findAll() {
        return taskService.findAll();
    }

    @PutMapping("/{id}")
    public TaskDTO editTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        return taskService.editById(id, taskDTO);
    }

    @PostMapping
    public TaskDTO createTask(@RequestBody TaskDTO task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }


}
