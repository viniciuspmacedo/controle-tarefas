package dev.viniciusmacedo.task_manager.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findById")
    public String getTaskById(){
        return "Usuário por id";
    }

    @GetMapping("/findAll")
    public List<UserModel> findAll(){
        return userService.findAll();
    }

    @PutMapping("/editById")
    public String editUser(){
        return "Usuário editado com sucesso";
    }

    @PostMapping("/create")
    public String createUser(){
        return "Usuário salvo com sucesso";
    }

    @DeleteMapping("/delete")
    public String deleteUser(){
        return "Usuário deletado com sucesso";
    }
}
