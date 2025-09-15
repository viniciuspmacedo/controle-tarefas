package dev.viniciusmacedo.task_manager.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca usuário por Id.", description = "Rota retorna um usuário pelo seu Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrada."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrada.")
    })
    public ResponseEntity<?> findUserById(
            @Parameter(required = true, description = "Usuário envia o Id do usuário no caminho da requisição.")
            @PathVariable Long id) {
        if (userService.findById(id) != null) {
            return ResponseEntity.ok(userService.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário de id: " + id + " não encontrado");
        }

    }

    @GetMapping
    @Operation(summary = "Retorna todos os usuários", description = "Rota retorna uma lista contendo todos os usuários cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso."),
            @ApiResponse(responseCode = "400", description = "Falha ao listar os usuários")
    }
    )
    public ResponseEntity<?> findAll() {
        if (userService.findAll() != null) {
            return ResponseEntity.ok(userService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário cadastrado");
        }
    }

    @PutMapping("{id}")
    @Operation(summary = "Edita um usuário.", description = "Esta altera um usuário existente e salva as alterações no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário alterado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na alteração do usuário.")
    })
    public ResponseEntity<?> editById(
            @Parameter(required = true, description = "Usuário envia o Id do usuário a ser alterado no caminho da requisição.")
            @PathVariable Long id,
            @Parameter(required = true, description = "Usuário envia os dados do usuário no corpo da requisição.")
            @RequestBody UserDTO userDTO) {
        if (userService.findById(id) != null) {
            return ResponseEntity.ok(userService.editById(id, userDTO));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário de id: " + id + " não encontrado");
        }
    }

    @PostMapping()
    @Operation(summary = "Cria um usuário.", description = "Rota cria um novo usuaário e salva no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao criar o usuário.")
    })
    public ResponseEntity<UserDTO> createUser(
            @Parameter(required = true, description = "Usuário envia os dados do novo usuário no corpo da requisição.")
            @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um usuário", description = "Rota deleta um usuário com base em seu Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrada.")
    })
    public ResponseEntity<?> deleteUser(
            @Parameter(required = true, description = "Usuário envia o Id do usuário a ser deletado no caminho da requisição")
            @PathVariable Long id) {
        if (userService.findById(id) != null) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário de id: " + id + " não encontrado");
        }
    }
}
