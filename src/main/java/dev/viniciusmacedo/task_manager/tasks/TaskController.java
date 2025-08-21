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
    public TaskModel getTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping()
    public List<TaskModel> findAll() {
        return taskService.findAll();
    }

    @PutMapping("/{id}")
    public TaskModel editTask(@PathVariable Long id, @RequestBody TaskModel taskModel) {
        return taskService.editById(id, taskModel);
    }

    @PostMapping
    public TaskModel createTask(@RequestBody TaskModel task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
    }


}
