package dev.viniciusmacedo.task_manager.tasks;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca tarefa por Id.", description = "Rota retorna uma tarefa pelo seu Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada."),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada.")
    })
    public ResponseEntity<?> getTaskById(
            @Parameter(required = true, description = "Usuário envia o Id da tarefa no caminho da requisição.")
            @PathVariable Long id) {
        if (taskService.findById(id) != null) {
            return ResponseEntity.ok(taskService.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }

    @GetMapping()
    @Operation(summary = "Retorna todas as tarefas", description = "Rota retorna uma lista contendo todas as tarefas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefas listadas com sucesso."),
            @ApiResponse(responseCode = "400", description = "Falha ao listar as tarefas")
    }
    )
    public ResponseEntity<?> findAll() {
        if (taskService.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        } else {
            return ResponseEntity.ok(taskService.findAll());

        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edita uma tarefa.", description = "Esta altera uma tarefa existente e salva as alterações no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa alterada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na alteração da tarefa.")
    })
    public ResponseEntity<?> editTask(
            @Parameter(required = true, description = "Usuário envia o Id da tarefa a ser alterada no caminho da requisição.")
            @PathVariable Long id,
            @Parameter(required = true, description = "Usuário envia os dados da tarefa no corpo da requisição.")
            @RequestBody TaskDTO taskDTO) {
        if (taskService.findById(id) != null) {
            return ResponseEntity.ok(taskService.editById(id, taskDTO));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }

    @PostMapping
    @Operation(summary = "Cria uma tarefa.", description = "Rota cria uma nova tarefa e a salva no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao criar a tarefa.")
    })
    public ResponseEntity<TaskDTO> createTask(
            @Parameter(required = true, description = "Usuário envia os dados da nova tarefa no corpo da requisição.")
            @RequestBody TaskDTO task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma tarefa", description = "Rota deleta uma tarefa com base em seu Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada.")
    })
    public ResponseEntity<?> deleteTask(
            @Parameter(required = true, description = "Usuário envia o Id da tarefa a ser deletada no caminho da requisição")
            @PathVariable Long id) {
        if (taskService.findById(id) != null) {
            taskService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
    }


}
