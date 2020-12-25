package com.ing.tech.controller;

import com.ing.tech.model.dto.UserRequestDTO;
import com.ing.tech.model.dto.UserResponseDTO;
import com.ing.tech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.registerUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.checkCredentials(userRequestDTO.getNationalID(), userRequestDTO.getPassword());

        UserResponseDTO userResponseDTO = userService.updateUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody UserRequestDTO userRequestDTO) {
        // return JWT token (username and pass now act as jwt, kinda)
        return null;
    }

}
