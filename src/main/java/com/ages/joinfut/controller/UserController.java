package com.ages.joinfut.controller;

import com.ages.joinfut.dto.UserDTO;
import com.ages.joinfut.model.User;
import com.ages.joinfut.repository.UserRepository;
import com.ages.joinfut.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final String URL_PLURAL = "/users";
    private static final String URL_SINGULAR = "/user/{id}";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os usuários cadastrados")
    public ResponseEntity<List<UserDTO>> readAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTO = userService.convertList(users);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um usuário pelo seu ID")
    public ResponseEntity<UserDTO> readUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> ResponseEntity.ok(new UserDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo usuário")
    @Transactional
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        User user = userService.desconvertObject(userDTO);
        userRepository.save(user);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDTO(user));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um usuário salvo")
    @Transactional
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {
        Optional<User> verifyId = userRepository.findById(id);
        if (verifyId.isPresent()) {
            User updatedUser = userService.desconvertObject(userDTO);
            User user = userService.updateObject(id, updatedUser, userRepository);
            return ResponseEntity.ok(new UserDTO(user));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Remove um usuário salvo")
    @Transactional
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        Optional<User> verifyId = userRepository.findById(id);
        if (verifyId.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }
}
