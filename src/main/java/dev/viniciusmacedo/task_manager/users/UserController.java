package dev.viniciusmacedo.task_manager.users;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/findById")
    public String getTaskById(){
        return "Usuário por id";
    }

    @GetMapping("/findAll")
    public String findAll(){
        return "Lista de Usuários";
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
