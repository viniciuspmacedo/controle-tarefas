package dev.viniciusmacedo.task_manager.tasks;

import dev.viniciusmacedo.task_manager.users.UserDTO;

public record TaskDTO(Long id, String title, String description, Long userId) {
}
