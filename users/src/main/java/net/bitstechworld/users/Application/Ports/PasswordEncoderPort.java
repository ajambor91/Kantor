package net.bitstechworld.users.Application.Ports;

public interface PasswordEncoderPort {
    String hashPassword(char[] rawPassword);
    boolean validatePassword(char[] rawPassword, String hashedPassword);
}