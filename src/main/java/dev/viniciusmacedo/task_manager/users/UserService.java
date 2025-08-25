package dev.viniciusmacedo.task_manager.users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::map).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(userMapper::map).orElse(null);

    }

    public UserDTO createUser(UserDTO user) {
        userRepository.save(userMapper.map(user));
        return user;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO editById(Long id, UserDTO userDTO) {
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isPresent()){
            UserModel updatedUser = userMapper.map(userDTO);
            updatedUser.setId(id);
            return userMapper.map(userRepository.save(updatedUser));
        }else {
            return null;
        }

    }

}
