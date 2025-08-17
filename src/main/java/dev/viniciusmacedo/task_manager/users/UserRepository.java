package dev.viniciusmacedo.task_manager.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
