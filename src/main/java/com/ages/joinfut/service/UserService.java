package com.ages.joinfut.service;

import com.ages.joinfut.dto.AthleteDTO;
import com.ages.joinfut.model.Athlete;
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

    public UserService(){
    }

    @Transactional
    public void save(User user) {
        if (user.getCreationDate() == null) {
            user.setCreationDate(new Date());
        }
        user.setPassword(hash(user.getPassword()));
        userRepository.save(user);
    }

    public List<UserDTO> convertList(List<User> users) {
        return users.stream().map(UserDTO   ::new).collect(Collectors.toList());
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

        if (updated.getAthlete() != null && !updated.getAthlete().equals(saved.getAthlete())){
            saved.setAthlete(updated.getAthlete());
        }

        if (updated.getClub() != null && !updated.getClub().equals(saved.getClub())){
            saved.setClub(updated.getClub());
        }

        return saved;
    }

    public UserDTO DTODataConverter(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(user.getIdUser());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCreationDate(user.getCreationDate());
        userDTO.setUserType(user.getUserType());
        if (user.getAthlete() != null) {
            userDTO.setAthlete(athleteService.convertObject(user.getAthlete()));
        }
        if (user.getClub() != null) {
            userDTO.setClub(clubService.convertObject(user.getClub()));
        }
        return userDTO;
    }

    public User EntityDataConverter(UserDTO userDTO) {
        User user = new User();
        user.setIdUser(userDTO.getIdUser());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreationDate(userDTO.getCreationDate());
        user.setUserType(userDTO.getUserType());
        if (userDTO.getAthlete() != null) {
            user.setAthlete(athleteService.desconvertObject(userDTO.getAthlete()));
        }
        if (userDTO.getClub() != null) {
            user.setClub(clubService.desconvertObject(userDTO.getClub()));
        }
        return user;
    }

    public String hash(String passwordRaw){
        passwordRaw = "@-0" + passwordRaw + "magic@@futbola";
        String hashPass = Hashing.sha256().hashString(passwordRaw, StandardCharsets.UTF_8).toString();
        hashPass = hashPass + "duvideiDecifrar";
        hashPass = Hashing.sha256().hashString(passwordRaw, StandardCharsets.UTF_8).toString();
        return hashPass;
    }

}
