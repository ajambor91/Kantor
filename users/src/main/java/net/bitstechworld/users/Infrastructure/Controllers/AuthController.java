package net.bitstechworld.users.Infrastructure.Controllers;


import lombok.RequiredArgsConstructor;
import net.bitstechworld.users.Application.DTO.UserLoginRecord;
import net.bitstechworld.users.Application.DTO.UserRecord;
import net.bitstechworld.users.Application.DTO.UserRegisteredRecord;
import net.bitstechworld.users.Application.Ports.LoginUserUseCase;
import net.bitstechworld.users.Application.Ports.RegisterUserUseCase;
import net.bitstechworld.users.Infrastructure.DTO.LoginRequest;
import net.bitstechworld.users.Infrastructure.DTO.LoginResponse;
import net.bitstechworld.users.Infrastructure.DTO.RegisterRequest;
import net.bitstechworld.users.Infrastructure.DTO.RegisterResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUserUseCase authService;
    private final LoginUserUseCase loginService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            UserRegisteredRecord userRegisteredRecord = this.authService.registerUser(new UserRecord(registerRequest.email(), registerRequest.rawPassword()));
            return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterResponse(userRegisteredRecord.id(), userRegisteredRecord.email(), userRegisteredRecord.createdAt()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest registerRequest) {
        try {
            UserLoginRecord userLoginRecord = this.loginService.loginUser(new UserRecord(registerRequest.email(), registerRequest.rawPassword()));
            return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(userLoginRecord.id(), userLoginRecord.email(), userLoginRecord.jwt(), userLoginRecord.createdAt()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
