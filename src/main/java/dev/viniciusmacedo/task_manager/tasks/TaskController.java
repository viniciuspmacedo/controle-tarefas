package dev.viniciusmacedo.task_manager.tasks;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping("/findById")
    public String getTaskById(){
        return "Tarefa por id";
    }

    @GetMapping("/findAll")
    public String findAll(){
        return "Lista de Tarefas";
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
