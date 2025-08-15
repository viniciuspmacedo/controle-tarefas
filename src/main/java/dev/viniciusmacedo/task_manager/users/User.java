package dev.viniciusmacedo.task_manager.users;

import dev.viniciusmacedo.task_manager.tasks.TaskModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private Long id;
    private String username;
    private List<TaskModel> tasks = new ArrayList<>();

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TaskModel> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
