package dev.viniciusmacedo.task_manager.ui;

import dev.viniciusmacedo.task_manager.tasks.TaskDTO;
import dev.viniciusmacedo.task_manager.tasks.TaskService;
import dev.viniciusmacedo.task_manager.users.UserDTO;
import dev.viniciusmacedo.task_manager.users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/tasks")
public class TaskUIController {
    private final TaskService taskService;
    private final UserService userService;

    public TaskUIController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping()
    public String getTasksPage(Model model) {
        List<TaskDTO> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks_page";
    }

    @GetMapping("/create")
    public String getCreateTaskPage(Model model){
        List<UserDTO> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("newTask", new TaskDTO());
        return "create_task_page";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute TaskDTO task){
        taskService.createTask(task);
        return "redirect:/ui/tasks";
    }

    @GetMapping("/edit/{id}")
    public String getEditTaskPage(Model model, @PathVariable Long id){
        TaskDTO task = taskService.findById(id);
        model.addAttribute("taskToEdit", task);
        return "edit_task_page";
    }

    @PutMapping("/edit/{id}")
    public String editTask(@ModelAttribute TaskDTO task, @PathVariable Long id){
        taskService.editById(id, task);
        return "redirect:/ui/tasks";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
        return "redirect:/ui/tasks";
    }
}
