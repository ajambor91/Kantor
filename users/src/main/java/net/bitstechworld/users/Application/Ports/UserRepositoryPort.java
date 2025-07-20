package net.bitstechworld.users.Application.Ports;

import net.bitstechworld.users.Domain.User;

public interface UserRepositoryPort {
    User saveUser(User user);
    User getUserByEmail(String email);
}
