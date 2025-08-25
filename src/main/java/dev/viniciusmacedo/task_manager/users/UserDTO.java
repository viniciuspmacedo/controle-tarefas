package dev.viniciusmacedo.task_manager.users;

import dev.viniciusmacedo.task_manager.tasks.TaskDTO;

import java.util.List;

public record UserDTO(Long id, String username, String email, List<TaskDTO> tasks) {
}
