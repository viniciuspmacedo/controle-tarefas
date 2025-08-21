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

    @GetMapping("/{id}")
    public UserModel findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserModel> findAll() {
        return userService.findAll();
    }

    @PutMapping("/editById")
    public String editUser() {
        return "Usuário editado com sucesso";
    }

    @PostMapping()
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
