package dev.viniciusmacedo.task_manager.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        if (userService.findById(id) != null) {
            return ResponseEntity.ok(userService.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário de id: " + id + " não encontrado");
        }

    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        if (userService.findAll() != null) {
            return ResponseEntity.ok(userService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário cadastrado");
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editById(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        if (userService.findById(id) != null) {
            return ResponseEntity.ok(userService.editById(id, userDTO));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário de id: " + id + " não encontrado");
        }
    }

    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userService.findById(id) != null) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário de id: " + id + " não encontrado");
        }
    }
}
