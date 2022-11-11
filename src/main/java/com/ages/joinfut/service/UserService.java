package com.ages.joinfut.service;

import com.ages.joinfut.config.mappers.UserMapper;
import com.ages.joinfut.model.User;
import com.ages.joinfut.dto.UserDTO;
import com.ages.joinfut.repository.AthleteRepository;
import com.ages.joinfut.repository.ClubRepository;
import com.ages.joinfut.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private ClubRepository clubRepository;

    private AthleteService athleteService = new AthleteService();
    private ClubService clubService = new ClubService();

    public UserService(){}

    @Transactional
    public User save(UserDTO userDTO) {
        User user = UserMapper.MAPPER.UserDTOToUser(userDTO);

        if (user.getCreationDate() == null) {
            user.setCreationDate(new Date());
        }
        user.setPassword(hash(user.getPassword()));

        userRepository.save(user);

        return user;
    }

    public List<UserDTO> convertList(List<User> users) {
        return users.stream().map(user -> UserMapper.MAPPER.UserToUserDTO(user)).collect(Collectors.toList());
    }

    public User update(Long id, UserDTO userDTO, UserRepository userRepository) {
        User updated = UserMapper.MAPPER.UserDTOToUser(userDTO);
        User saved = userRepository.findByidUser(id);
        String updateHash = hash(updated.getPassword());

        if (updated.getEmail() != null && !updated.getEmail().equals(saved.getEmail())) {
            saved.setEmail(updated.getEmail());
        }

        if (updated.getPassword() != null && !updateHash.equals(saved.getPassword())) {
            saved.setPassword(updateHash);
        }
        if (updated.getUserType() != null && !updated.getUserType().equals(saved.getUserType())){
            saved.setUserType(updated.getUserType());
        }

        return saved;
    }

    public String hash(String passwordRaw){
        passwordRaw = "@-0" + passwordRaw + "magic@@futbola";
        String hashPass = Hashing.sha256().hashString(passwordRaw, StandardCharsets.UTF_8).toString();
        hashPass = hashPass + "duvideiDecifrar";
        hashPass = Hashing.sha256().hashString(passwordRaw, StandardCharsets.UTF_8).toString();
        return hashPass;
    }

}
