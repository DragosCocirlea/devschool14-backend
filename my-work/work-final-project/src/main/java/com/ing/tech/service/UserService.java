package com.ing.tech.service;

import com.ing.tech.exceptions.UserEmailAlreadyExistsException;
import com.ing.tech.exceptions.UserIdAlreadyExistsException;
import com.ing.tech.exceptions.WrongCredentialsException;
import com.ing.tech.model.User;
import com.ing.tech.model.dto.UserRequestDTO;
import com.ing.tech.model.dto.UserResponseDTO;
import com.ing.tech.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        // check if another user has the same national ID
        Optional<User> userById = userRepository.getByNationalID(userRequestDTO.getNationalID());
        if (userById.isPresent()) {
            throw new UserIdAlreadyExistsException();
        }

        // check if another user has the same email
        Optional<User> userByEmail = userRepository.getByEmail(userRequestDTO.getEmail());
        if (userByEmail.isPresent()) {
            throw new UserEmailAlreadyExistsException();
        }

        User user = new User(userRequestDTO);
        return new UserResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO);
        return new UserResponseDTO(userRepository.save(user));
    }

    public User checkCredentials(String nationalID, String password) {
        Optional<User> existingUser = userRepository.getByNationalID(nationalID);
        existingUser.orElseThrow(WrongCredentialsException::new);
        byte[] hashedPassword = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            hashedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (!Arrays.equals(hashedPassword, existingUser.get().getHashedPassword())) {
            throw new WrongCredentialsException();
        }

        return existingUser.get();
    }
}
