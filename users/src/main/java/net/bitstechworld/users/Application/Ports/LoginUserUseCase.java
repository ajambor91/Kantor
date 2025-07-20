package net.bitstechworld.users.Application.Ports;

import net.bitstechworld.users.Application.DTO.UserLoginRecord;
import net.bitstechworld.users.Application.DTO.UserRecord;

public interface LoginUserUseCase {
    UserLoginRecord loginUser(UserRecord userRecord);
}
