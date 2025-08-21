package dev.viniciusmacedo.task_manager.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.viniciusmacedo.task_manager.users.UserModel;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_task")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserModel user;

    public TaskModel() {
    }

    public TaskModel(Long id, String title, String description, UserModel user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel userModel) {
        this.user = userModel;
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
