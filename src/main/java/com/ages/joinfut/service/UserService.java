package com.ages.joinfut.service;

import com.ages.joinfut.model.User;
import com.ages.joinfut.dto.UserDTO;
import com.ages.joinfut.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(){
    }

    @Transactional
    public void save(User user) {
        if (user.getCreationDate() == null) {
            user.setCreationDate(new Date());
        }
        userRepository.save(user);
    }

    public List<UserDTO> convertList(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO convertObject(User user) {
        return new UserDTO(user);
    }

    public List<User> desconvertList(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(User::new).collect(Collectors.toList());
    }

    public User desconvertObject(UserDTO templateDTO) {
        return new User(templateDTO);
    }

    public User updateObject(Long id, User updated, UserRepository userRepository) {
        User saved = userRepository.findByidUser(id);
        if (updated.getEmail() != null && !updated.getEmail().equals(saved.getEmail())) {
            saved.setEmail(updated.getEmail());
        }

        if (updated.getPassword() != null && !updated.getPassword().equals(saved.getPassword())) {
            saved.setPassword(updated.getPassword());
        }
        return saved;
    }


}
