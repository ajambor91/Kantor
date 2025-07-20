package net.bitstechworld.users.Infrastructure.Encoders;


import net.bitstechworld.users.Application.Ports.PasswordEncoderPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.CharBuffer;

public class PasswordEncoder implements PasswordEncoderPort {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final String passwordPepper;
    public PasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder, String passwordPepper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.passwordPepper = passwordPepper;
    }

    @Override
    public String hashPassword(char[] rawPassword) {
        return this.bCryptPasswordEncoder.encode(CharBuffer.wrap(this.addPepper(rawPassword)));
    }

    @Override
    public boolean validatePassword(char[] rawPassword, String hashedPassword) {
        char[] pepperedPassword = this.addPepper(rawPassword);
        return this.bCryptPasswordEncoder.matches(CharBuffer.wrap(pepperedPassword), hashedPassword);
    }

    private char[] addPepper(char[] rawPassword) {
        char[] peppersChars = this.passwordPepper.toCharArray();
        char[] pepperedPassword = new char[peppersChars.length + rawPassword.length];
        System.arraycopy(rawPassword, 0, pepperedPassword, 0, rawPassword.length);
        System.arraycopy(peppersChars, 0, pepperedPassword, rawPassword.length, peppersChars.length);
        return pepperedPassword;
    }
}
