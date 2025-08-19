package dev.viniciusmacedo.task_manager.tasks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    public TaskModel findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

}
