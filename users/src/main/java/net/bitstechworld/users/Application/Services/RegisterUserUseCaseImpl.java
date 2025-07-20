package net.bitstechworld.users.Application.Services;

import net.bitstechworld.users.Application.DTO.UserRecord;
import net.bitstechworld.users.Application.DTO.UserRegisteredRecord;
import net.bitstechworld.users.Application.Ports.PasswordEncoderPort;
import net.bitstechworld.users.Application.Ports.RegisterUserUseCase;
import net.bitstechworld.users.Application.Ports.UserRepositoryPort;
import net.bitstechworld.users.Domain.User;

import java.util.Arrays;

public class RegisterUserUseCaseImpl implements RegisterUserUseCase {
    private final PasswordEncoderPort passwordEncoderPort;
    private final UserRepositoryPort userRepositoryPort;
    public RegisterUserUseCaseImpl(PasswordEncoderPort passwordEncoderPort, UserRepositoryPort userRepositoryPort) {
        this.passwordEncoderPort = passwordEncoderPort;
        this.userRepositoryPort = userRepositoryPort;
    }
    @Override
    public UserRegisteredRecord registerUser(UserRecord userRecord) {
        String hashedPassword = this.passwordEncoderPort.hashPassword(userRecord.rawPassword());
        Arrays.fill(userRecord.rawPassword(), '\0');
        User user =  User.registerUser(userRecord.email(), hashedPassword);
        User registseredUser = this.userRepositoryPort.saveUser(user);
        return new UserRegisteredRecord(registseredUser.getId(), registseredUser.getEmail(), registseredUser.getCreatedAt());
    }
}
