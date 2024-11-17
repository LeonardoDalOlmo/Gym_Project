package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.UserDTO;
import com.example.Gym.Project.Model.User;
import com.example.Gym.Project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public UserDTO insert(UserDTO dto) {
        User user = new User();
        copyDtotoEntity(dto, user);
        var senhaCriptografada = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(senhaCriptografada);
        userRepository.save(user);
        return new UserDTO(user);
    }

    private static void copyDtotoEntity(UserDTO dto, User entity){
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setPassword(dto.getPassword());
        entity.setLogin(dto.getLogin());

    }
}
