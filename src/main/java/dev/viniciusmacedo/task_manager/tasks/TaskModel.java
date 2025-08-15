package dev.viniciusmacedo.task_manager.tasks;

import dev.viniciusmacedo.task_manager.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

public class TaskModel {
    private Long id;
    private String title;
    private String description;
    private User user;

    public TaskModel() {
    }

    public TaskModel(Long id, String title, String description, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return Objects.equals(id, taskModel.id) && Objects.equals(title, taskModel.title) && Objects.equals(description, taskModel.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}
