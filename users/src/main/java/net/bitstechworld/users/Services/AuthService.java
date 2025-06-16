package net.bitstechworld.users.Services;

import net.bitstechworld.users.DTO.UserLoginRequest;
import net.bitstechworld.users.Entities.User;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class AuthService {

    public boolean authUser(UserLoginRequest userDTO) {
        if (userDTO == null) {
            throw new NoSuchElementException("User DTO cannot be null!!");
        }
        User user = new User(userDTO);

        return "PASSWORD".equals(new String(user.getRawPassword())) && "LOGIN".equals(user.getName());

    }
}
