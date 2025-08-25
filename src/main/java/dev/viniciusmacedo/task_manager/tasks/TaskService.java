package dev.viniciusmacedo.task_manager.tasks;

import dev.viniciusmacedo.task_manager.users.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDTO> findAll() {
        return taskRepository.findAll().stream().map(taskMapper::map).collect(Collectors.toList());
    }

    public TaskDTO findById(Long id) {
        Optional<TaskModel> taskModel = taskRepository.findById(id);
        return taskModel.map(taskMapper::map).orElse(null);
    }

    public TaskDTO createTask(TaskDTO task) {
        TaskModel taskModel = taskMapper.map(task);
        taskModel = taskRepository.save(taskModel);
        return taskMapper.map(taskModel);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO editById(Long id, TaskDTO taskDTO) {
        Optional<TaskModel> task = taskRepository.findById(id);
        if (task.isPresent()) {
            TaskModel updatedTask = taskMapper.map(taskDTO);
            updatedTask.setId(id);
            return taskMapper.map(taskRepository.save(updatedTask));
        } else {
            return null;
        }
    }

}
