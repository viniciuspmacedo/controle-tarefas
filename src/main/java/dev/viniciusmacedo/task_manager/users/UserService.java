package dev.viniciusmacedo.task_manager.users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserModel editById(Long id, UserModel userModel) {
        if (userRepository.existsById(id)) {
            userModel.setId(id);
            return userRepository.save(userModel);
        } else {
            return null;
        }
    }

}
