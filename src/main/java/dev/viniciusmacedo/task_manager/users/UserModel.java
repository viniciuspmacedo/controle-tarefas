package dev.viniciusmacedo.task_manager.users;

import dev.viniciusmacedo.task_manager.tasks.TaskModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String email;

    @OneToMany(mappedBy = "userId")
    private List<TaskModel> tasks;

    public UserModel(Long id, String username, String email, List<TaskModel> tasks) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.tasks = tasks;
    }

    public UserModel() {
    }

    public void setId(Long id) {
        this.id = id;
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
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTasks(List<TaskModel> tasks) {
    }
}
