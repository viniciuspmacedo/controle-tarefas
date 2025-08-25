package dev.viniciusmacedo.task_manager.users;

import dev.viniciusmacedo.task_manager.tasks.TaskDTO;
import dev.viniciusmacedo.task_manager.tasks.TaskMapper;
import dev.viniciusmacedo.task_manager.tasks.TaskModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final TaskMapper taskMapper;

    public UserMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public UserModel map(UserDTO dto) {
        UserModel user = new UserModel();
        user.setId(dto.id());
        user.setUsername(dto.username());
        user.setEmail(dto.email());

        if (dto.tasks() != null) {
            List<TaskModel> tasks = dto.tasks().stream()
                    .map(taskMapper::map)
                    .collect(Collectors.toList());
            user.setTasks(tasks);
        }

        return user;
    }

    public UserDTO map(UserModel user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getTasks().stream().map(taskMapper::map).collect(Collectors.toList()));
    }
}
