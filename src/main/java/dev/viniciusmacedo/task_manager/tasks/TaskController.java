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
    public TaskModel getTaskById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @GetMapping()
    public List<TaskModel> findAll(){
        return taskService.findAll();
    }

    @PutMapping("/editById")
    public String editTask(){
        return "Tarefa editada com sucesso";
    }

    @PostMapping("/create")
    public String createTask(){
        return "Tarefa salva com sucesso";
    }

    @DeleteMapping("/delete")
    public String deleteTask(){
        return "Tarefa deletada com sucesso";
    }


}
