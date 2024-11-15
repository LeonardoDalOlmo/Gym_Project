package com.example.Gym.Project.Service;

import com.example.Gym.Project.DTO.UserDTO;
import com.example.Gym.Project.Model.User;
import com.example.Gym.Project.Repository.RoleRepository;
import com.example.Gym.Project.Repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public UserDTO insert(UserDTO dto) {
        User user = new User();
        copyDtotoEntity(dto, user);
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
