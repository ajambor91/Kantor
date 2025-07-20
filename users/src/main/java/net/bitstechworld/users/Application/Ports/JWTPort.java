package net.bitstechworld.users.Application.Ports;

public interface JWTPort {
    String generateJWT(long id, String email);
}
