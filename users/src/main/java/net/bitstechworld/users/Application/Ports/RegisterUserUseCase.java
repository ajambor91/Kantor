package net.bitstechworld.users.Application.Ports;

import net.bitstechworld.users.Application.DTO.UserRecord;
import net.bitstechworld.users.Application.DTO.UserRegisteredRecord;

public interface RegisterUserUseCase {
    UserRegisteredRecord registerUser(UserRecord userRecord);
}
