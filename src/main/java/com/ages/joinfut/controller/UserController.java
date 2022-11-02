package com.ages.joinfut.controller;

import com.ages.joinfut.config.mappers.UserMapper;
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
@RequestMapping(value = "/personas")
public class UserController {

    private static final String URL_PLURAL = "/users";
    private static final String URL_SINGULAR = "/user/{id}";

    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(
            UserRepository userRepository,
            UserService userService
    ){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca em lista de todos os usuários cadastrados pelo Email e Senha")
    public ResponseEntity<List<UserDTO>> readAllUsers(@RequestParam(value = "email", required = false) String email, @RequestParam(value = "password", required = false) String password) {
        if (email != null && password != null) {
            List<User> users = userRepository.findByEmailAndPassword(email, userService.hash(password));
            List<UserDTO> userDTO = userService.convertList(users);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            List<User> users = userRepository.findAll();
            List<UserDTO> userDTO = userService.convertList(users);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }
    }

    @GetMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Busca de um usuário pelo seu ID")
    public ResponseEntity<UserDTO> readUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> ResponseEntity.ok(UserMapper.MAPPER.UserToUserDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = URL_PLURAL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Cria um novo usuário")
    @Transactional
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        User user = userService.save(userDTO);
        URI uri = uriComponentsBuilder.path(URL_SINGULAR).buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(UserMapper.MAPPER.UserToUserDTO(user));
    }

    @PutMapping(value = URL_SINGULAR, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiModelProperty("Atualiza um usuário salvo")
    @Transactional
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {
        Optional<User> verifyId = userRepository.findById(id);
        if (verifyId.isPresent()) {
            User user = userService.update(id, userDTO, userRepository);
            return ResponseEntity.ok(UserMapper.MAPPER.UserToUserDTO(user));
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
