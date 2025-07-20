package net.bitstechworld.users.Application.Services;

import net.bitstechworld.users.Application.DTO.UserLoginRecord;
import net.bitstechworld.users.Application.DTO.UserRecord;
import net.bitstechworld.users.Application.Ports.JWTPort;
import net.bitstechworld.users.Application.Ports.LoginUserUseCase;
import net.bitstechworld.users.Application.Ports.PasswordEncoderPort;
import net.bitstechworld.users.Application.Ports.UserRepositoryPort;
import net.bitstechworld.users.Domain.User;

public class LoginUserUseCaseImpl implements LoginUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final JWTPort jwtPort;
    public LoginUserUseCaseImpl(UserRepositoryPort userRepositoryPort, PasswordEncoderPort passwordEncoderPort, JWTPort jwtPort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
        this.jwtPort = jwtPort;
    }
    @Override
    public UserLoginRecord loginUser(UserRecord userRecord) {
        User userFromDB = this.userRepositoryPort.getUserByEmail(userRecord.email());
        userFromDB.isPasswordValid(userRecord.rawPassword(), this.passwordEncoderPort);
        return new UserLoginRecord(userFromDB.getId(), userFromDB.getEmail(), this.jwtPort.generateJWT(userFromDB.getId(), userFromDB.getEmail()), userFromDB.getCreatedAt());
    }
}
