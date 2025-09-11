package dev.viniciusmacedo.task_manager.tasks;

import dev.viniciusmacedo.task_manager.users.UserModel;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskModel map(TaskDTO dto) {
        return new TaskModel(dto.getId(), dto.getTitle(), dto.getDescription(), dto.getUserId());
    }

    public TaskDTO map(TaskModel task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getUserId() != null ? task.getUserId() : null
        );
    }

}
