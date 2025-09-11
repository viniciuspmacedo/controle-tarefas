package dev.viniciusmacedo.task_manager.ui;

import dev.viniciusmacedo.task_manager.users.UserDTO;
import dev.viniciusmacedo.task_manager.users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/users")
public class UserUIController {

    public final UserService userService;

    public UserUIController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsersPage(Model model){
        List<UserDTO> users = userService.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }

    @GetMapping("/create")
    public String getCreateUserPage(Model model){
        model.addAttribute("newUser", new UserDTO());
        return "create_user_page";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute UserDTO user){
        userService.createUser(user);
        return "redirect:/ui/users";
    }

    @GetMapping("/edit/{id}")
    public String getEditUserPage(@PathVariable Long id, Model model){
        UserDTO userToEdit = userService.findById(id);
        model.addAttribute("userToEdit", userToEdit);
        return "edit_user_page";
    }

    @PutMapping("edit/{id}")
    public String editUser(@ModelAttribute UserDTO user, @PathVariable Long id){
        userService.editById(id, user);
        return "redirect:/ui/users";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model){
        UserDTO user = userService.findById(id);
        model.addAttribute("user", user);
        return "user_details_page";
    }


}
